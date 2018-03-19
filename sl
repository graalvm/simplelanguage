#!/usr/bin/env bash

VERSION="0.32"
LANGUAGE_PATH="./language/target/simplelanguage-$VERSION-SNAPSHOT.jar"
LAUNCHER_PATH="./launcher/target/launcher-$VERSION-SNAPSHOT.jar"
MAIN_CLASS="com.oracle.truffle.sl.launcher.SLMain"

#######################################################################
#            Check if the language and launcher jars exist            #
#######################################################################
if [[ ! -f $LANGUAGE_PATH ]]; then
    echo "Could not find language on $LANGUAGE_PATH. Did you run mvn package?"
    exit
fi

if [[ ! -f $LAUNCHER_PATH ]]; then
    echo "Could not find launcher on $LAUNCHER_PATH. Did you run mvn package?"
    exit
fi

#######################################################################
#                 Check graalvm location and version.                 #
#      Fallback is JAVA_HOME which may or may not be a GraalVM.       #
#######################################################################
if [[ -d "graalvm" ]]; then
    GRAALVM_VERSION=$(grep "GRAALVM_VERSION" ./graalvm/release)
    if [[ "$GRAALVM_VERSION" == "" ]]; then
       echo "Cannot find GRAALVM_VERSION entry in ./graalvm/release"
       exit
    fi
    GRAALVM_VERSION=$(echo "$GRAALVM_VERSION" | awk 'BEGIN {FS="\""} {print $2}')
    if [[ "$GRAALVM_VERSION" != "$VERSION" ]]; then
        echo "Wrong version of GraalVM in ./graalvm. Expected: $VERSION, found $GRAALVM_VERSION"
        exit
    fi
    JAVACMD=${JAVACMD:=./graalvm/bin/java}
elif [[ "$JAVA_HOME" != "" ]]; then
    GRAALVM_VERSION=$(grep "GRAALVM_VERSION" "$JAVA_HOME"/release)
    if [[ "$GRAALVM_VERSION" != "" ]]; then
        GRAALVM_VERSION=$(echo "$GRAALVM_VERSION" | awk 'BEGIN {FS="\""} {print $2}')
        if [[ "$GRAALVM_VERSION" != "$VERSION" ]]; then
            echo "Wrong version of GraalVM in \$JAVA_HOME. Expected: $VERSION, found $GRAALVM_VERSION"
            exit
        fi
    fi
    JAVACMD=${JAVACMD:=$JAVA_HOME/bin/java}
else
    echo "The ./graalvm directory missing and JAVA_HOME not set"
    exit
fi

#######################################################################
#          Parse arguments, prepare Java command and execute.         #
#######################################################################
if [[ "$GRAALVM_VERSION" != "" ]]; then
    PROGRAM_ARGS=""
    JAVA_ARGS=""

    for opt in "$@"
    do
      case $opt in
        -debug)
          JAVA_ARGS="$JAVA_ARGS -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=y" ;;
        -dump)
          JAVA_ARGS="$JAVA_ARGS -Dgraal.Dump= -Dgraal.MethodFilter=Truffle.* -Dgraal.TruffleBackgroundCompilation=false -Dgraal.TraceTruffleCompilation=true -Dgraal.TraceTruffleCompilationDetails=true" ;;
        -disassemble)
          JAVA_ARGS="$JAVA_ARGS -XX:CompileCommand=print,*OptimizedCallTarget.callRoot -XX:CompileCommand=exclude,*OptimizedCallTarget.callRoot -Dgraal.TruffleBackgroundCompilation=false -Dgraal.TraceTruffleCompilation=true -Dgraal.TraceTruffleCompilationDetails=true" ;;
        -J*)
          opt=${opt:2}
          JAVA_ARGS="$JAVA_ARGS $opt" ;;
        *)
          PROGRAM_ARGS="$PROGRAM_ARGS $opt" ;;
      esac
    done
    $JAVACMD $JAVA_ARGS -Dtruffle.class.path.append=$LANGUAGE_PATH -cp $LAUNCHER_PATH $MAIN_CLASS $PROGRAM_ARGS
else
    echo "Warning: Could not find GraalVM on $JAVA_HOME or in ./graalvm folder. Running on JDK without support for compilation."
    echo
    PROGRAM_ARGS=""
    JAVA_ARGS=""

    for opt in "$@"
    do
      case $opt in
        -debug)
          JAVA_ARGS="$JAVA_ARGS -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=y" ;;
        -dump)
          echo "NOTE: Ignoring -dump, only supported on GraalVM." ;;
        -disassemble)
          echo "NOTE: Ignoring -disassemble" ;;
        -J*)
          opt=${opt:2}
          JAVA_ARGS="$JAVA_ARGS $opt" ;;
        *)
          PROGRAM_ARGS="$PROGRAM_ARGS $opt" ;;
      esac
    done
    if [[ ! -d $HOME/.m2 ]]; then
        echo "Could not find mvn cache at $HOME/.m2"
        exit
    fi
    GRAAL_SDK_PATH="$HOME/.m2/repository/org/graalvm/graal-sdk/$VERSION/graal-sdk-$VERSION.jar"
    TRUFFLE_API_PATH="$HOME/.m2/repository/com/oracle/truffle/truffle-api/$VERSION/truffle-api-$VERSION.jar"
    $JAVACMD -cp $GRAAL_SDK_PATH:$LAUNCHER_PATH:$LANGUAGE_PATH:$TRUFFLE_API_PATH $MAIN_CLASS $PROGRAM_ARGS
fi

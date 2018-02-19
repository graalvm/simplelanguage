#!/usr/bin/env bash

LANGUAGE_PATH="./language/target/simplelanguage-0.31-SNAPSHOT.jar"
LAUNCHER_PATH="./launcher/target/launcher-0.31-SNAPSHOT.jar"
MAIN_CLASS="com.oracle.truffle.sl.launcher.SLMain"

JAVACMD=${JAVACMD:=./graalvm/bin/java}

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

JAVA_ARGS="$JAVA_ARGS -XX:+UseJVMCIClassLoader -Dtruffle.class.path.append=$LANGUAGE_PATH"
TRUFFLE_LIB="./graalvm/jre/lib/truffle"
BOOTCLASSPATH="-Xbootclasspath/a:$TRUFFLE_LIB/truffle-api.jar:$TRUFFLE_LIB/locator.jar:$TRUFFLE_LIB/truffle-nfi.jar"

$JAVACMD $JAVA_ARGS $BOOTCLASSPATH -cp $LAUNCHER_PATH $MAIN_CLASS $PROGRAM_ARGS

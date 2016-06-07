#!/usr/bin/env bash

JAVACMD=${JAVACMD:=./graalvm/bin/java}
SIMPLELANGUAGE_JAR=${SIMPLELANGUAGE_JAR:=./target/simplelanguage-complete-0.12-SNAPSHOT.jar}

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

$JAVACMD $JAVA_ARGS -jar $SIMPLELANGUAGE_JAR $PROGRAM_ARGS

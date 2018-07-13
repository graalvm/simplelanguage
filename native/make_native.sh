#!/usr/bin/env bash
$JAVA_HOME/bin/native-image --tool:truffle -H:MaxRuntimeCompileMethods=1200 \
    -cp ../language/target/simplelanguage.jar:../launcher/target/launcher-1.0.0-rc3-SNAPSHOT.jar \
    com.oracle.truffle.sl.launcher.SLMain \
    slnative

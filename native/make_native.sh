#!/usr/bin/env bash
if [[ $SL_BUILD_NATIVE == "false" ]]; then
    echo "Skipping the native image build because SL_BUILD_NATIVE is set to false."
    exit 0
fi
$JAVA_HOME/bin/native-image --tool:truffle -H:MaxRuntimeCompileMethods=1200 \
    -cp ../language/target/simplelanguage.jar:../launcher/target/launcher-1.0.0-rc5-SNAPSHOT.jar \
    com.oracle.truffle.sl.launcher.SLMain \
    slnative

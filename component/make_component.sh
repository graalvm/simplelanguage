#!/usr/bin/env bash

COMPONENT_DIR="component_temp_dir"
LANGUAGE_PATH="$COMPONENT_DIR/jre/languages/sl"

rm -rf COMPONENT_DIR

mkdir -p "$LANGUAGE_PATH"
cp ../language/target/simplelanguage.jar "$LANGUAGE_PATH"

mkdir -p "$LANGUAGE_PATH/launcher"
cp ../launcher/target/sl-launcher.jar "$LANGUAGE_PATH/launcher/"

mkdir -p "$LANGUAGE_PATH/bin"
cp ../sl $LANGUAGE_PATH/bin/

mkdir -p "$COMPONENT_DIR/META-INF"
MANIFEST="$COMPONENT_DIR/META-INF/MANIFEST.MF"
touch "$MANIFEST"
echo "Bundle-Name: Simple Language" >> "$MANIFEST"
echo "Bundle-Symbolic-Name: com.oracle.truffle.sl" >> "$MANIFEST"
echo "Bundle-Version: 1.0.0-rc5" >> "$MANIFEST"
echo 'Bundle-RequireCapability: org.graalvm; filter:="(&(graalvm_version=1.0.0-rc5)(os_arch=amd64))"' >> "$MANIFEST"
echo "x-GraalVM-Polyglot-Part: True" >> "$MANIFEST"

cd $COMPONENT_DIR
jar cfm ../sl-component.jar META-INF/MANIFEST.MF .

echo "bin/sl = ../jre/languages/sl/bin/sl" > META-INF/symlinks
jar uf ../sl-component.jar META-INF/symlinks

echo "jre/languages/sl/bin/sl = rwxrwxr-x" > META-INF/permissions
jar uf ../sl-component.jar META-INF/permissions
cd ..
rm -rf $COMPONENT_DIR

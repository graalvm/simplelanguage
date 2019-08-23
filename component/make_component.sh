#!/usr/bin/env bash

COMPONENT_DIR="component_temp_dir"
LANGUAGE_PATH="$COMPONENT_DIR/jre/languages/sl"
if [[ -f ../native/slnative ]]; then
    INCLUDE_SLNATIVE="TRUE"
fi

rm -rf COMPONENT_DIR

mkdir -p "$LANGUAGE_PATH"
cp ../language/target/simplelanguage.jar "$LANGUAGE_PATH"

mkdir -p "$LANGUAGE_PATH/launcher"
cp ../launcher/target/sl-launcher.jar "$LANGUAGE_PATH/launcher/"

mkdir -p "$LANGUAGE_PATH/bin"
cp ../sl $LANGUAGE_PATH/bin/
if [[ $INCLUDE_SLNATIVE = "TRUE" ]]; then
    cp ../native/slnative $LANGUAGE_PATH/bin/
fi

touch "$LANGUAGE_PATH/native-image.properties"

mkdir -p "$COMPONENT_DIR/META-INF"
{
    echo "Bundle-Name: Simple Language";
    echo "Bundle-Symbolic-Name: com.oracle.truffle.sl";
    echo "Bundle-Version: 19.2.0";
    echo 'Bundle-RequireCapability: org.graalvm; filter:="(&(graalvm_version=19.2.0)(os_arch=amd64))"';
    echo "x-GraalVM-Polyglot-Part: True"
} > "$COMPONENT_DIR/META-INF/MANIFEST.MF"

(
cd $COMPONENT_DIR || exit 1
jar cfm ../sl-component.jar META-INF/MANIFEST.MF .

echo "bin/sl = ../jre/languages/sl/bin/sl" > META-INF/symlinks
if [[ $INCLUDE_SLNATIVE = "TRUE" ]]; then
    echo "bin/slnative = ../jre/languages/sl/bin/slnative" >> META-INF/symlinks
fi
jar uf ../sl-component.jar META-INF/symlinks

{
    echo "jre/languages/sl/bin/sl = rwxrwxr-x"
    echo "jre/languages/sl/bin/slnative = rwxrwxr-x"
} > META-INF/permissions
jar uf ../sl-component.jar META-INF/permissions
)
rm -rf $COMPONENT_DIR

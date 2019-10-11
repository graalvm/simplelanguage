#!/usr/bin/env bash
set -e

readonly COMPONENT_DIR="component_temp_dir"
readonly LANGUAGE_PATH="$COMPONENT_DIR/jre/languages/sl"
readonly SIMPLE_LANGUAGE_JAR="../language/target/simplelanguage.jar"
if [[ -f ../native/slnative ]]; then
    INCLUDE_SLNATIVE="TRUE"
fi

if [[ -d "$COMPONENT_DIR" ]]; then
    read -p "'$COMPONENT_DIR' already exists. Do you want to remove it? (y/N): " user_input
    if [[ "${user_input}" != "y" ]]; then
        exit 0
    fi
    rm -rf "$COMPONENT_DIR"
fi

if [[ ! -f "$SIMPLE_LANGUAGE_JAR" ]]; then
    echo "Could not find '$SIMPLE_LANGUAGE_JAR'. Did you run mvn package?"
    exit 1
fi

mkdir -p "$LANGUAGE_PATH"
cp "$SIMPLE_LANGUAGE_JAR" "$LANGUAGE_PATH"

mkdir -p "$LANGUAGE_PATH/launcher"
cp ../launcher/target/sl-launcher.jar "$LANGUAGE_PATH/launcher/"

mkdir -p "$LANGUAGE_PATH/bin"
cp ../sl "$LANGUAGE_PATH/bin/"
if [[ "$INCLUDE_SLNATIVE" = "TRUE" ]]; then
    cp ../native/slnative "$LANGUAGE_PATH/bin/"
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

pushd "$COMPONENT_DIR" > /dev/null
jar cfm ../sl-component.jar META-INF/MANIFEST.MF .

echo "bin/sl = ../jre/languages/sl/bin/sl" > META-INF/symlinks
if [[ "$INCLUDE_SLNATIVE" = "TRUE" ]]; then
    echo "bin/slnative = ../jre/languages/sl/bin/slnative" >> META-INF/symlinks
fi
jar uf ../sl-component.jar META-INF/symlinks

{
    echo "jre/languages/sl/bin/sl = rwxrwxr-x"
    echo "jre/languages/sl/bin/slnative = rwxrwxr-x"
} > META-INF/permissions
jar uf ../sl-component.jar META-INF/permissions
popd > /dev/null

rm -rf "$COMPONENT_DIR"

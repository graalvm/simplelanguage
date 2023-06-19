{
  local javaBuild = {
    targets: ['gate'],
    timelimit: '00:59:59',
    run: [
      ['mvn', 'clean'],
      ['mvn', 'package'],
      ['./sl', 'language/tests/Add.sl'],
    ],

    environment+: {
      SL_BUILD_NATIVE: 'false'
    },
  },

  local graalvmBuild = {
    targets: ['gate'],
    timelimit: '00:59:59',
    run+: [
      ["$JAVA_HOME/bin/gu", 'install', 'native-image'],
      ['mvn', 'clean'],
      ['mvn', 'package'],
      ['./sl', 'language/tests/Add.sl'],
      ['./native/slnative', 'language/tests/Add.sl'],
      ["$JAVA_HOME/bin/gu", 'install', '-L', 'component/sl-component.jar'],
      ["$JAVA_HOME/bin/sl", 'language/tests/Add.sl'],
      ["$JAVA_HOME/bin/slnative", 'language/tests/Add.sl'],
      ["$JAVA_HOME/bin/polyglot", '--jvm', '--language', 'sl', '--file', 'language/tests/Add.sl'],
      ["$JAVA_HOME/bin/gu", 'remove', 'sl'],
      ['./generate_parser.sh'],
      ['mvn', 'package'],
      ['./sl', 'language/tests/Add.sl'],
    ]
  },

  local graalvm20 = {
    downloads+: {
      JAVA_HOME: { name: 'graalvm-community-java20', version: '23.0.0', platformspecific: true },
    },
  },

  local linux = {
    capabilities+: ['linux', 'amd64'],
    packages+: {
      maven: '==3.3.9',
      devtoolset: "==7",  # GCC 7.3.1, make 4.2.1, binutils 2.28, valgrind 3.13.0
    },
    docker: {
      image: "buildslave_ol7",
      mount_modules: true,
    },
  },

  local darwin = {
    capabilities+: ['darwin_sierra', 'amd64'],
    environment+: {
      MACOSX_DEPLOYMENT_TARGET: '10.11',
    },
  },

  local fixDarwinJavaHome = {
    environment+: {
      JAVA_HOME: '$JAVA_HOME/Contents/Home'
    },
  },

  builds: [
    graalvmBuild + linux + graalvm20 + { name: 'linux-graalvm20' },

    graalvmBuild + darwin + fixDarwinJavaHome + graalvm20 + { name: 'darwin-graalvm20' },

    # Blocked by the sl script being unable to find maven repo
  ],
}

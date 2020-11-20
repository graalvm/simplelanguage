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

  local java8 = {
    downloads+: {
      JAVA_HOME: {"name": "oraclejdk", "version": "8u261+33-jvmci-20.2-b03", "platformspecific": true },
    }
  },

  local java11 = {
    downloads+: {
      JAVA_HOME: {"name": "oraclejdk", "version": "11.0.6+8", "platformspecific": true },
    }
  },

  local graalvm8 = {
    downloads+: {
      JAVA_HOME: { name: 'graalvm-ce-java8', version: '20.3.0', platformspecific: true },
    }
  },

  local graalvm11 = {
    downloads+: {
      JAVA_HOME: { name: 'graalvm-ce-java11', version: '20.3.0', platformspecific: true },
    }
  },

  local linux = {
    capabilities+: ['linux', 'amd64'],
    packages+: {
      maven: '==3.3.9',
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
    graalvmBuild + linux + graalvm8  + { name: 'linux-graalvm8' },
    graalvmBuild + linux + graalvm11 + { name: 'linux-graalvm11' },

    graalvmBuild + darwin + fixDarwinJavaHome + graalvm8  + { name: 'darwin-graalvm8' },
    graalvmBuild + darwin + fixDarwinJavaHome + graalvm11 + { name: 'darwin-graalvm11' },

    # Blocked by the sl script being unable to find maven repo
    # javaBuild + linux + java8  + { name: 'linux-java8' },
    # javaBuild + linux + java11 + { name: 'linux-java11' },

    # javaBuild + darwin + java8  + { name: 'darwin-java8' },
    # javaBuild + darwin + java11 + { name: 'darwin-java11' },
  ],
}

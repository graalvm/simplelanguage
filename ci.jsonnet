{
  local graalvmBuild = {
    targets: ['gate'],
    timelimit: '00:59:59',
    run+: [
      ['mvn', 'clean'],
      ['mvn', 'package', '-Pnative'],
      ['./sl', 'language/tests/Add.sl'],
      ['./standalone/target/slnative', 'language/tests/Add.sl'],
      ['./generate_parser.sh'],
      ['mvn', 'package'],
      ['./sl', 'language/tests/Add.sl'],
    ]
  },

  local graalvm = {
    downloads+: {
      JAVA_HOME: { name: 'graalvm-community-java24', version: '24.2.0', platformspecific: true },
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
    capabilities+: ["darwin", "!darwin_sierra", "!darwin_mojave", "!darwin_catalina", "aarch64"],
    packages+: {
      maven: '==3.3.9',
    },
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
    graalvmBuild + linux + graalvm + { name: 'linux-graalvm' },

    graalvmBuild + darwin + fixDarwinJavaHome + graalvm + { name: 'darwin-graalvm' },

    # Blocked by the sl script being unable to find maven repo
  ],
}

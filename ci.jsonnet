{
  local basicBuild = {
    targets: ['gate'],
    timelimit: '00:59:59',
    run: [
      ['mvn', 'clean'],
      ['mvn', 'package'],
      ['./sl', 'language/tests/Add.sl'],
    ],
  },

  local graalvm = {
    downloads+: {
      JAVA_HOME: { name: 'graalvm-ee-java8', version: '20.2.0', platformspecific: true },
    }
    run+= [
      ['./native/slnative', 'language/tests/Add.sl']
      ["$JAVA_HOME/bin/gu", 'install', '-L', 'component/sl-component.jar ']
      ["$JAVA_HOME/bin/sl", 'language/tests/Add.sl']
      ["$JAVA_HOME/bin/slnative", 'language/tests/Add.sl']
      ["$JAVA_HOME/bin/polyglot", '--jvm', '--language', 'sl' '--file', 'language/tests/Add.sl']
      ["$JAVA_HOME/bin/gu", 'remove', 'sl']
      ['./generate_parser.sh']
      ['mvn' 'package']
      ['./sl' 'language/tests/Add.sl']
    ]
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
      JAVA_HOME: '$JAVA_HOME/Contents/Home'
    },
  },

  builds: [
    basicBuild + linux + graalvm + { name: 'linux' },

    basicBuild + darwin + graalvm + { name: 'darwin' },
  ],
}

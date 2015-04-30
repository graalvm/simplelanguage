# SimpleLanguage

A simple language built using Truffle for the GraalVM.

Fork this repository to begin your own Truffle language.

## Compiling

    mvn package

## Testing

    mvn test

## Running

    bin/sl HelloWorld.sl

## Running With Graal

Download one of:

* http://lafo.ssw.uni-linz.ac.at/graalvm/openjdk-8-graalvm-b132-linux-x86_64-0.7.tar.gz
* http://lafo.ssw.uni-linz.ac.at/graalvm/openjdk-8-graalvm-b132-macosx-x86_64-0.7.tar.gz

Then run:

    JAVACMD=graalvm-jdk1.8.0/bin/java bin/sl HelloWorld.sl

At the moment there is no Windows build of Graal, but you can still run
SimpleLanguage in the interpreted mode on a standard JVM:

    java -jar target/simplelanguage-complete-0.1-SNAPSHOT.jar HelloWorld.sl

## Options

To pass options to the JVM, prefix with `-J`. For example, `-J-Xmx1G`.

## Documentation

SimpleLanguage is heavily documented to explain the how and why of writing a
Truffle language. A good way to read this documentation is to generate HTML of
the JavaDoc comments and read that, and then read the source alongside the
comments.

    mvn javadoc:javadoc

Start with the `SLMain` class.

You should also have access to the [Truffle documentation
itself](http://lafo.ssw.uni-linz.ac.at/javadoc/graalvm/all/index.html).

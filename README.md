# SimpleLanguage

A simple demonstration language built using Truffle for the GraalVM.

SimpleLanguage is heavily documented to explain the how and why of writing a
Truffle language. A good way to read this documentation is to generate HTML of
the JavaDoc comments and read that, and then read the source alongside the
comments.

This repository is licensed under the permissive UPL licence. Fork it to begin
your own Truffle language.

## Prerequisites
* JDK 8
* maven3 

## Installation

* Clone SL repository using
  `git clone https://github.com/graalvm/simplelanguage`
* Download Graal VM Development Kit (verson 0.31) from 
  http://www.oracle.com/technetwork/oracle-labs/program-languages/downloads
* Unpack the downloaded `graalvm_*.tar.gz` into `simplelanguage/graalvm`. 
* Set enviroment variable `JAVA_HOME` to the path of the graalvm folder.
* Verify that the file `simplelanguage/graalvm/bin/java` exists and is executable
* Execute `mvn package`

## IDE Setup 

### Eclipse
* Tested with Eclipse Neon.2 Release (4.6.2)
* Open Eclipse with a new workspace
* Install `m2e` and `m2e-apt` plugins from the Eclipse marketplace (Help -> Eclipse Marketplace...)
* File -> Import... -> Existing Maven Projects -> Select `simplelanguage` folder -> Finish

### Netbeans
* Tested with Netbeans 8.2
* Open Netbeans
* File -> Open Project -> Select `simplelanguage` folder -> Check "Open Required Projects:" -> Open Project

### IntelliJ IDEA
* Tested with IntelliJ IDEA 2016.3.4
* Open IntelliJ IDEA
* File -> New -> Project from existing Sources -> Select `simplelanguage` folder -> Check "Create module groups for multi-module Maven projects" -> Finish

## Running

* Execute `./sl tests/HelloWorld.sl` to run a simple language source file.
* Execute `./sl -disassemble tests/SumPrint.sl` to see assembly code for Truffle compiled functions.

## IGV

* Download the Ideal Graph Visualizer (IGV) from
  https://lafo.ssw.uni-linz.ac.at/pub/idealgraphvisualizer/
* Unpack the downloaded `.zip` file  
* Execute `bin/idealgraphvsiualizer` to start IGV
* Execute `./sl -dump tests/SumPrint.sl` to dump graphs to IGV.

## Debugging

* Execute `./sl -debug tests/HelloWorld.sl`.
* Attach a Java remote debugger (like Eclipse) on port 8000.

## Tested Compatibility

Simple language is compatible to:

* Truffle-Version: 0.31
* GraalVM-Version: 0.31

## Further information

* [Truffle JavaDoc](http://lafo.ssw.uni-linz.ac.at/javadoc/truffle/latest/)
* [Truffle on Github](http://github.com/graalvm/truffle)
* [Graal on Github](http://github.com/graalvm/graal-core)
* [Truffle Tutorials and Presentations](https://wiki.openjdk.java.net/display/Graal/Publications+and+Presentations)
* [Truffle FAQ and Guidelines](https://wiki.openjdk.java.net/display/Graal/Truffle+FAQ+and+Guidelines)
* [Graal VM]( http://www.oracle.com/technetwork/oracle-labs/program-languages/overview) on the Oracle Technology Network
* [Papers on Truffle](http://ssw.jku.at/Research/Projects/JVM/Truffle.html)
* [Papers on Graal](http://ssw.jku.at/Research/Projects/JVM/Graal.html)

## License

The Truffle framework is licensed under the [GPL 2 with Classpath exception](http://openjdk.java.net/legal/gplv2+ce.html).
The SimpleLanguage is licensed under the [Universal Permissive License (UPL)](http://opensource.org/licenses/UPL).



# SimpleLanguage

A simple language built using Truffle for the GraalVM.

SimpleLanguage is heavily documented to explain the how and why of writing a
Truffle language. A good way to read this documentation is to generate HTML of
the JavaDoc comments and read that, and then read the source alongside the
comments.

This repository is licensed under the permissive UPL licence. Fork it to begin
your own Truffle language.

## Prerequisites
* JDK 8
* maven3 
* Eclipse (optional)

## Installation

* Clone SL repository using
  `git clone https://github.com/graalvm/simplelanguage`
* Download Graal VM Development Kit from 
  http://www.oracle.com/technetwork/oracle-labs/program-languages/downloads
* Unpack the downloaded `graalvm_*.tar.gz` into `simplelanguage/graalvm`. 
* Verify that the file `simplelanguage/graalvm/bin/java` exists and is executable
* Execute `./build` (which just runs `mvn package`)

## Eclipse

* Create a new workspace
* File -> Import... -> Existing Project into Workspace -> Select `simplelanguage` folder -> Finish

## Running

* Execute `./sl tests/HelloWorld.sl` to run a simple language source file.
* Execute `./sl -disassemble tests/LoopSum.sl` to see assembly code for Truffle compiled functions.

## IGV

* Download the Ideal Graph Visualizer (IGV) from
  https://lafo.ssw.uni-linz.ac.at/pub/idealgraphvisualizer/
* Unpack the downloaded `.zip` file  
* Execute `bin/idealgraphvsiualizer` to start IGV
* Execute `./sl -dump tests/LoopSum.sl` to dump graphs to IGV.

## Debugging

* Execute `./sl -debug tests/HelloWorld.sl`.
* Attach a Java remote debugger (like Eclipse) on port 8000.

## Further information

* Truffle JavaDoc: http://lafo.ssw.jku.at/javadoc/truffle/all/
* https://wiki.openjdk.java.net/display/Graal/Publications+and+Presentations
* http://ssw.jku.at/Research/Projects/JVM/Truffle.html

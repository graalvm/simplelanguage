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
* ant (for IGV)
* eclipse (optional)

## Installation

* Clone SL repository using: "git clone https://github.com/grashalm/simplelanguage"
* Download for Linux: https://lafo.ssw.uni-linz.ac.at/pub/graalvm_linux.zip 
* Download for Mac: https://lafo.ssw.uni-linz.ac.at/pub/graalvm_mac.zip
* Unpack the downloaded graalvm_*.zip into simplelanguage/graalvm. 
* Verify that the file "simplelanguage/graalvm/bin/java" exists
* Execute "./build"

## Eclipse instructions

* Create a new workspace
* Right click on the package explorer -> Import... -> Existing Project into Workspace -> Select simple language folder -> Finish

## IGV

* Execute "./igv" to start the ideal graph visualizer

## Running

* Execute "./run example_*.sl" to run a simple language source file.
* Execute "./run_dump example_*.sl" to dump graphs to the igv.
* Execute "./run_assembly example_*.sl" to dump compiled assembly of simple language functions.

## Debugging

* Execute "./debug example_*.sl" to debug you simpel language source file.
* Attach a Java remote debugger (like eclipse) on port 8000.

## Further information
* Truffle JavaDoc: http://lafo.ssw.jku.at/javadoc/truffle/all/
* https://wiki.openjdk.java.net/display/Graal/Publications+and+Presentations
* http://ssw.jku.at/Research/Projects/JVM/Truffle.html

## Things to try

###1) Fix a bug
* Add a test case to src/test/sl that fails and fix it. (its easy to break SimpleLanguage). 
* You can build and run the tests using the "mvn package" command.

###2) An extension to Simple Language
* Introduce floating point values (SL just supports only fixed point values at the moment)
* Implement a builtin printf that takes a String and an Object array and produces a formatted result. (Hint: you need to register the builtin in SLContext#installBuiltins). Try to think of ways how you could optimize the operation using nodes that it could constant fold the full operation.
* Add support for counted loops (for (i = 0; i < 100; i++) {}

###3) Division speculation
* Optimize the division implementation (SLDivNode) to cache for the identity of the second double division argument. 
* Identify the main loop in the output if you run the example with ./run_assembly and ensure that the idiv instruction is gone. 
* Open igv by running ./igv and dump the compiler graph by running "./run_dump example_divion.sl". Inspect the graph and ensure that the division operation is gone.



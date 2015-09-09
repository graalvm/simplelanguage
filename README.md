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

## Installation:

* Clone SL repository using: "git clone https://github.com/grashalm/simplelanguage"
* Download for Linux: http://chara.epfl.ch/summer-school/graalvm_linux.zip
* Download for Mac: http://chara.epfl.ch/summer-school/graalvm_mac.zip
* Unpack the downloaded graalvm_*.zip into simplelanguage/graalvm. 
* Verify that the file "simplelanguage/graalvm/bin/java" exists
* Execute "./build"

## Eclipse instructions:

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


## Further information:
* Truffle JavaDoc: http://lafo.ssw.jku.at/javadoc/truffle/all/
* https://wiki.openjdk.java.net/display/Graal/Publications+and+Presentations
* http://ssw.jku.at/Research/Projects/JVM/Truffle.html

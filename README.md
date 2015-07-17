# SimpleLanguage @ DSLDI summer school

A simple language built using Truffle for the GraalVM.

This fork of simple language intended to be used by the audience of the DSLDI summer school in Lausanne 2015.

This repository is licensed under the permissive UPL licence. Fork it to begin
your own Truffle language.

## Prerequisites
* maven3 
* ant (for IGV)
* eclipse (optional)

## Installation:

* Clone SL repository using:
   "git clone https://github.com/grashalm/simplelanguage"
* Download 
   for Linux: http://chara.epfl.ch/summer-school/graalvm_linux.zip
* Download for Mac: http://chara.epfl.ch/summer-school/graalvm_mac.zip
* Unpack the downloaded graalvm_*.zip into simplelanguage/graalvm. 
* Verify that the file "simplelanguage/graalvm/java" exists
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


## Instructions for "Can we fold it yet"?
If you want to play with the can we fold it yet examples yourself please follow these instructions:

* Clone JRuby 9k master
* Extract downloaded graalvm (see installation) into $JRuby/graalvm-jdk1.8.0 directory.
* `$ function jt { ruby tool/jt.rb $@; }`
* `$ jt build`
* `$ jt run --graal test/truffle/can-we-fold-yet.rb`

## Exercise
Fork this repository and develop, alter or extend something some part of SimpleLanguage.
Send the link to your repository to christian.humer@oracle.com.
For questions feel free to use the same adress.


## Further information:
* Truffle JavaDoc: http://lafo.ssw.jku.at/javadoc/truffle/all/
* https://wiki.openjdk.java.net/display/Graal/Publications+and+Presentations
* http://ssw.jku.at/Research/Projects/JVM/Truffle.html

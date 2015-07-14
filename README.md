# SimpleLanguage

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
   Linux: https://www.dropbox.com/s/wdtl6dubyax4sg4/graalvm_linux.zip?dl=0
   Mac: https://www.dropbox.com/s/evtg738slq4neas/graalvm_mac.zip?dl=0
* Unpack graalvm_*.zip into simplelanguage/graalvm
   (Verify that the file "simplelanguage/graalvm/java" exists)
* Execute "./build"

## Eclipse instructions:

* Create a new workspace
* Right click on the package explorer -> Import... -> Existing Project into Workspace -> Select simple language folder -> Finish

## Running

* Execute "./run Test.sl" to run a simple language source file.
* Execute "./run_igv Test.sl" to dump graphs to the igv.
* Execute "./run_assembly Test.sl" to dump compiled assembly of simple language functions.

## Debugging

* Execute "./debug Test.sl" to debug you simpel language source file.
* Attach a Java remote debugger (like eclipse) on port 8000.

## IGV

* Execute "./igv" to start the ideal graph visualizer

You should also have access to the [Truffle documentation
itself](http://lafo.ssw.uni-linz.ac.at/javadoc/graalvm/all/index.html).

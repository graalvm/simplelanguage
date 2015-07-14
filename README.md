# SimpleLanguage

A simple language built using Truffle for the GraalVM.

This fork of simple language intended to be used by the audience of the DSLDI summer school in Lausanne 2015.

This repository is licensed under the permissive UPL licence. Fork it to begin
your own Truffle language.

## Prerequisites
  maven3 
  ant (for IGV)
  eclipse (optional)

## Installation:

1) Clone this repository using:
   "git clone https://github.com/grashalm/simplelanguage"
2) Download 
   Linux: https://www.dropbox.com/s/59i89031u2085kv/graalvm.zip?dl=0
   Mac: 
3) Unpack graalvm_*.zip into simplelanguage/graalvm
   (Verify that the file "simplelanguage/graalvm/java" exists)
4) Execute "./build"

## Eclipse instructions:

Right click the package explorer 
-> Import... 
-> Existing Project into Workspace 
-> Select simple language folder 
-> Finish

## Running

Execute "./run Test.sl" to run a simple language source file.
Execute "./run_igv Test.sl" to dump graphs to the igv.
Execute "./run_assembly Test.sl" to dump compiled assembly of simple language functions.

## Debugging

Execute "./debug Test.sl" to debug you simpel language source file.
Attach a Java remote debugger (like eclipse) on port 8000.

## IGV

Execute "./igv" to start the ideal graph visualizer

You should also have access to the [Truffle documentation
itself](http://lafo.ssw.uni-linz.ac.at/javadoc/graalvm/all/index.html).

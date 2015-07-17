# SimpleLanguage @ DSLDI summer school

A simple language built using Truffle for the GraalVM.

This fork of simple language intended to be used by the audience of the DSLDI summer school in Lausanne 2015.

This repository is licensed under the permissive UPL licence. Fork it to begin
your own Truffle language.

## Prerequisites
* JDK 8
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


## Instructions for "Can we fold it yet"?
If you want to play with the can we fold it yet examples yourself please follow these instructions:

* Clone JRuby 9k master
* Extract downloaded graalvm (see installation) into $JRuby/graalvm-jdk1.8.0 directory.
* `$ function jt { ruby tool/jt.rb $@; }`
* `$ jt build`
* `$ jt run --graal test/truffle/can-we-fold-yet.rb`

## Exercise

The following exercises are suggestions for things to try in the exercise track. Please see the slideset from today as reference: https://github.com/Grashalm/simplelanguage/blob/master/Truffle-API-Introduction.pdf.

###1) Division speculation
* Optimize the division implementation (SLDivNode) to cache for the identity of the second double division argument. 
* Identify the main loop in the output if you run the example with ./run_assembly and ensure that the idiv instruction is gone. 
* Open igv by running ./igv and dump the compiler graph by running "./run_dump example_divion.sl". Inspect the graph and ensure that the division operation is gone.
* If you run the example_division_polymorphic.sl with an inline cache for the second division argument of size 2, how many loops does the compiled machine code contain? Identify the Graal compiler phase that is responsible for generating multiple loops.

###2) Zero overhead tracing (example_trace.sl)
* Implement tracing for SLAddNode like below, but with zero overhead for the isTracingEnabled() check.
```java
    @Specialization(rewriteOn = ArithmeticException.class)
    protected long add(long left, long right) {
        long result = ExactMath.addExact(left, right);
        if (SLEnableTracingBuiltin.isTracingEnabled()) {
        	trace(result);
        }
        return result;
    }
    
```
	
* Verify by running example_trace.sl and inspecting the compiler graph in the IGV tool that there is no check for SLEnableTracingBuiltin#isTracingEnabled left in compiled code. 

###3) Try to run the "can we fold it yet" demo 
* ... and find out which of these Ruby examples Truffle Ruby can fold. Here are some examples that you could try:
```ruby
14
14 + 2
eval([1, 2, 3].inspect).sort[1] * 2
eval(rand < 0.5 ? '14 - 2' : '10 + 2')
eval('rand')
x = 14; p = Proc.new { }; p.binding.local_variable_get(:x)
eval(rand < 0.5 ? '14 - 2' : '10 + 2')
({x: 1, y: 2, z: 3})[:y]
({x: 1, y: 2, z: 3}).map { |k, v| v } [1]
14.5.object_id
14.send(:*, 2)
14.send('*', 2)
14.send((')'.ord + 1).chr, 2)
14.object_id
rand * 2
'foo' + 'bar'
```

###4) Your change to Simple Language
* Implement a change to SimpleLanguage of your choice. 
  - Introduce floating point values (SL just supports fixed point values at the moment)
  - Implement a builtin printf that takes a String and an Object array and produces a formatted result. (Hint: you need to register the builtin in SLContext#installBuiltins). Try to think of ways how you could optimize the operation using nodes that it could constant fold the full operation.
  - Add support for counted loops (for (i = 0; i < 100; i++) {}
  - ... your idea?
  

## Further information:
* Truffle JavaDoc: http://lafo.ssw.jku.at/javadoc/truffle/all/
* https://wiki.openjdk.java.net/display/Graal/Publications+and+Presentations
* http://ssw.jku.at/Research/Projects/JVM/Truffle.html

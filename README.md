
# SimpleLanguage

A simple demonstration language built using Truffle for GraalVM.

SimpleLanguage is heavily documented to explain the how and why of writing a
Truffle language. A good way to find out more is to read the source with
comments. Start reading [here](https://github.com/graalvm/simplelanguage/blob/master/language/src/main/java/com/oracle/truffle/sl/SLLanguage.java).
We also like to encourage people to clone the repository and start hacking.

This repository is licensed under the permissive UPL licence. Fork it to begin
your own Truffle language.

For instructions on how to get started please refer to [our website](http://www.graalvm.org/docs/graalvm-as-a-platform/implement-language/).

## Setup

* GraalVM 22.3.0
* openjdk 17.0.1
* Simple Language commit hash: ``5973a0e89ab046ab07b0a58607277b68a5a93bab``

## Notes

To download the [Ideal Graph Visualizer](https://www.graalvm.org/latest/tools/igv/), go through **Archived Enterprise Releases** and select the matching versio to your architecture.

In earlier versions of IGV, the dumps weren't trasmitted through the local network. Instead the were saved to a directory that you can manually import through the interface afterwards.

In newer versions, there is an issue with the Coloring of the Nodes.

## TODO

### High Priority:

* [X] Choose version of GraalVM, IGV, jdk
* [X] Understand ANTLR
* [X] Use ANTLR for Parser and Lexer generation
* [ ] Understand IGV and graph components
* [X] Change grammar to support **for** loop (with all its variations)
* [ ] Understand caching in code
* [ ] Understand and edit the tests
* [ ] Add **pfor** implementation (it may be more difficult than we thought, execution of many frames "simultaneously", have to think of weird cases)
* [ ] Presentation
* [ ] Documentation (it may be a nice idea to also collect any source (videos, wikis) we found and put it on a README.md)

### Low priority:

* [X] Move implementation of "string"*x from **master** to this branch
* [ ] Add **switch** case or any other additional functionality to language (*for* was the hardest, anything else will be very quick)

open module org.graalvm.sl.tck {
  requires org.graalvm.polyglot;
  requires org.graalvm.polyglot_tck;
  requires junit;
  
  provides org.graalvm.polyglot.tck.LanguageProvider with
    com.oracle.truffle.sl.tck.SLTCKLanguageProvider;
}

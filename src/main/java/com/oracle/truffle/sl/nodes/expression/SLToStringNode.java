package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.Node;

public abstract class SLToStringNode extends Node {

	public abstract String execute(Object operand);
	

	public static SLToStringNode create() {
		return SLToStringNodeGen.create();
	}
	
	@Specialization
	@TruffleBoundary
    public String toString(long value) {
        return String.valueOf(value);
    }

    @Specialization
    public String toString(boolean value) {
        return String.valueOf(value);
    }
    
    public String toString(String value) {
        return String.valueOf(value);
    }

    @Specialization
    @TruffleBoundary
    public String toString(Object[] value) {
    	StringBuilder b = new StringBuilder("[");
    	String sep = "";
    	for (int i = 0; i < value.length; i++) {
    		b.append(sep);
    		sep = ", ";
			b.append(execute(value[i]));
		}
        return b.toString();
    }

    @Fallback
    @TruffleBoundary
    public String println(Object value) {
        return value.toString();
    }

}

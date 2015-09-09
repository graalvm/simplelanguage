package com.oracle.truffle.sl.builtins;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.source.NullSourceSection;

@NodeInfo(shortName = "enableTracing")
public abstract class SLEnableTracingBuiltin extends SLBuiltinNode {

	private static boolean tracingEnabled;
	 
	
    public SLEnableTracingBuiltin() {
        super(new NullSourceSection("SL builtin", "setTracingEnabled"));
    }

    @Specialization
    public Object setTracingEnabled() {
		tracingEnabled = true;
		System.out.println("Tracing enabled!");
        return null;
    }
    
    public static boolean isTracingEnabled() {
		return tracingEnabled;
	}
    
}

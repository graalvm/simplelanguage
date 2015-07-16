package com.oracle.truffle.sl.builtins;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.source.NullSourceSection;

@NodeInfo(shortName = "setTracingEnabled")
public abstract class SLSetTracingBuiltin extends SLBuiltinNode {

	private static boolean tracingEnabled;
	private static Assumption unchangedAssumption = Truffle.getRuntime().createAssumption();
	 
    public SLSetTracingBuiltin() {
        super(new NullSourceSection("SL builtin", "setTracingEnabled"));
    }

    @Specialization
    public Object setTracingEnabled(boolean enabled) {
    	if (tracingEnabled != enabled) {
    		unchangedAssumption.invalidate();
    		tracingEnabled = enabled;
    		unchangedAssumption = Truffle.getRuntime().createAssumption();
    	}
        return null;
    }

    public static boolean isTracingEnabled() {
		return tracingEnabled;
	}
   
}

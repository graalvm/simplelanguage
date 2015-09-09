package com.oracle.truffle.sl.builtins;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.source.NullSourceSection;

@NodeInfo(shortName = "list")
public abstract class SLListBuiltin extends SLBuiltinNode {

    public SLListBuiltin() {
        super(new NullSourceSection("SL builtin", "list"));
    }

    @Specialization
    public long nanoTime() {
        return System.nanoTime();
    }
}

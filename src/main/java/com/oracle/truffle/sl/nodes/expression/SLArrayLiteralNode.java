package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.sl.nodes.SLExpressionNode;

public class SLArrayLiteralNode extends SLExpressionNode {

	@Children private final SLExpressionNode[] expressions;
	
	private SLArrayLiteralNode(SourceSection src, SLExpressionNode[] expressions) {
		super(src);
		this.expressions = expressions;
	}
	
	public static SLArrayLiteralNode create(SourceSection section, SLExpressionNode[] expressions) {
		return new SLArrayLiteralNode(section, expressions);
	}

	@Override
	@ExplodeLoop
	public Object executeGeneric(VirtualFrame frame) {
		Object[] array = new Object[expressions.length];
		for (int i = 0; i < expressions.length; i++) {
			array[i] = expressions[i].executeGeneric(frame);
		}
		return array;
	}
	
}

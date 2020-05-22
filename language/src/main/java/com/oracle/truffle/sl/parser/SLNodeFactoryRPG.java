package com.oracle.truffle.sl.parser;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.sl.SLLanguage;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.nodes.SLRootNode;
import com.oracle.truffle.sl.nodes.SLStatementNode;
import com.oracle.truffle.sl.nodes.controlflow.*;
import com.oracle.truffle.sl.nodes.expression.*;
import com.oracle.truffle.sl.nodes.local.SLReadArgumentNode;
import com.oracle.truffle.sl.nodes.local.SLReadLocalVariableNodeGen;
import com.oracle.truffle.sl.nodes.local.SLWriteLocalVariableNodeGen;
import com.oracle.truffle.sl.nodes.util.SLUnboxNodeGen;
import foundation.rpg.Match;
import foundation.rpg.StartSymbol;
import foundation.rpg.common.precedence.*;
import foundation.rpg.common.rules.*;
import foundation.rpg.common.symbols.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.oracle.truffle.api.frame.FrameSlotKind.Illegal;
import static foundation.rpg.common.Patterns.*;
import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.concat;

public class SLNodeFactoryRPG implements ListRules {

    private final Source source;
    private final SLLanguage language;
    private FrameDescriptor frameDescriptor = new FrameDescriptor();
    private LexicalScope lexicalScope = new LexicalScope(null);

    public SLNodeFactoryRPG(Source source, SLLanguage language) {
        this.source = source;
        this.language = language;
    }

    @StartSymbol
    SLLanguage is(@List1 List<SLRootNode> l) {
        return language;
    }

    SLBlockNode is(LCurl o, @List1 List<SLStatementNode> l, RCurl c) {
        return new SLBlockNode(l.toArray(new SLStatementNode[]{}));
    }

    SLStatementNode is(While w, LPar o, SLExpressionNode e, RPar r, SLStatementNode s) {
        return new SLWhileNode(e, s);
    }

    SLStatementNode is(If i, LPar o, SLExpressionNode e, RPar r, SLStatementNode s) {
        return new SLIfNode(e, s, null);
    }
/*
    SLStatementNode is(If i, LPar o, SLExpressionNode e, RPar r, SLStatementNode t, Else k, SLStatementNode f) {
        return new SLIfNode(e, t, f);
    }
*/
    SLStatementNode is(Return r, SLExpressionNode e, Semicolon s) {
        return new SLReturnNode(e);
    }

    SLStatementNode is(Break b, Semicolon s) {
        return new SLBreakNode();
    }

    SLStatementNode is(Continue b, Semicolon s) {
        return new SLContinueNode();
    }

    SLStatementNode is(SLExpressionNode e, Semicolon s) {
        return e;
    }

    @Atomic SLExpressionNode is(Identifier i) {
        return SLReadLocalVariableNodeGen.create(null);
    }

    @Atomic SLExpressionNode is(@Match(DOUBLE_QUOTED_STRING) String s) {
        return new SLStringLiteralNode(s);
    }

    @Atomic SLExpressionNode is(@Match(INTEGER) BigInteger i) {
        return new SLBigIntegerLiteralNode(i);
    }

    @Atomic SLExpressionNode is(LPar l, SLExpressionNode e, RPar r) {
        return new SLParenExpressionNode(e);
    }

    @Member SLExpressionNode isAt(@Atomic SLExpressionNode e) { return e; }

    @Member SLExpressionNode is(@Member SLExpressionNode a, Dot d, Identifier i) {
        return SLReadPropertyNodeGen.create(a, new SLStringLiteralNode(i.toString()));
    }

    @Member SLExpressionNode is(@Member SLExpressionNode o, LBr l, SLExpressionNode e, RBr r) {
        throw new UnsupportedOperationException("index access");
    }

    @Member SLExpressionNode is(@Member SLExpressionNode o, LPar l, @List3 List<SLExpressionNode> a, RPar r) {
        throw new UnsupportedOperationException("method call");
    }

    SLRootNode is(Function f, Identifier i, LPar o, @List3 List<Identifier> p, RPar c, SLBlockNode b) {
        SLStatementNode[] statements = concat(
                range(0, p.size()).mapToObj(par -> setVariable(new SLStringLiteralNode(i.toString()), new SLReadArgumentNode(par), par)),
                b.getStatements().stream()
        ).toArray(SLStatementNode[]::new);
        return new SLRootNode(language, frameDescriptor, new SLFunctionBodyNode(new SLBlockNode(statements)), source.createSection(f.description().getStartPos()), i.toString());
    }


    SLExpressionNode is(@LogicalOr SLExpressionNode e) {
        return e;
    }

    private SLExpressionNode unboxed(SLExpressionNode e) {
        return SLUnboxNodeGen.create(e);
    }

    @LogicalOr SLExpressionNode is(@LogicalOr SLExpressionNode l, PipePipe o, @LogicalAnd SLExpressionNode r) {
        return new SLLogicalOrNode(unboxed(l), unboxed(r));
    }

    @LogicalAnd SLExpressionNode is(@LogicalAnd SLExpressionNode l, AmpAmp o, @Relational SLExpressionNode r) {
        return new SLLogicalAndNode(unboxed(l), unboxed(r));
    }

    @Relational SLExpressionNode is(@Relational SLExpressionNode l, Lt o, @Additive SLExpressionNode r) {
        return SLLessThanNodeGen.create(unboxed(l), unboxed(r));
    }

    @Relational SLExpressionNode is(@Relational SLExpressionNode l, LtEqual o, @Additive SLExpressionNode r) {
        return SLLessOrEqualNodeGen.create(unboxed(l), unboxed(r));
    }

    @Relational SLExpressionNode is(@Relational SLExpressionNode l, Gt o, @Additive SLExpressionNode r) {
        return SLLogicalNotNodeGen.create(SLLessOrEqualNodeGen.create(unboxed(l), unboxed(r)));
    }

    @Relational SLExpressionNode is(@Relational SLExpressionNode l, GtEqual o, @Additive SLExpressionNode r) {
        return SLLogicalNotNodeGen.create(SLLessThanNodeGen.create(unboxed(l), unboxed(r)));
    }

    @Relational SLExpressionNode is(@Relational SLExpressionNode l, EqualEqual o, @Additive SLExpressionNode r) {
        return SLEqualNodeGen.create(unboxed(l), unboxed(r));
    }

    @Relational SLExpressionNode is(@Relational SLExpressionNode l, ExclEqual o, @Additive SLExpressionNode r) {
        return SLLogicalNotNodeGen.create(SLEqualNodeGen.create(unboxed(l), unboxed(r)));
    }

    @Additive SLExpressionNode is(@Additive SLExpressionNode l, Plus o, @Multiplicative SLExpressionNode r) {
        return SLAddNodeGen.create(unboxed(l), unboxed(r));
    }

    @Additive SLExpressionNode is(@Additive SLExpressionNode l, Minus o, @Multiplicative SLExpressionNode r) {
        return SLSubNodeGen.create(unboxed(l), unboxed(r));
    }

    @Multiplicative SLExpressionNode is(@Multiplicative SLExpressionNode l, Times o, @Member SLExpressionNode r) {
        return SLAddNodeGen.create(unboxed(l), unboxed(r));
    }

    @Multiplicative SLExpressionNode is(@Multiplicative SLExpressionNode l, Div o, @Member SLExpressionNode r) {
        return SLSubNodeGen.create(unboxed(l), unboxed(r));
    }




    private SLExpressionNode setVariable(SLExpressionNode nameNode, SLExpressionNode valueNode, Integer argumentIndex) {
        String name = ((SLStringLiteralNode) nameNode).executeGeneric(null);
        FrameSlot frameSlot = frameDescriptor.findOrAddFrameSlot(name, argumentIndex, Illegal);
        lexicalScope.locals.put(name, frameSlot);
        final SLExpressionNode result = SLWriteLocalVariableNodeGen.create(valueNode, frameSlot);
        result.addExpressionTag();
        return result;
    }

    /**
     * Local variable names that are visible in the current block. Variables are not visible outside
     * of their defining block, to prevent the usage of undefined variables. Because of that, we can
     * decide during parsing if a name references a local variable or is a function name.
     */
    static class LexicalScope {
        protected final SLNodeFactory.LexicalScope outer;
        protected final Map<String, FrameSlot> locals;

        LexicalScope(SLNodeFactory.LexicalScope outer) {
            this.outer = outer;
            this.locals = new HashMap<>();
            if (outer != null) {
                locals.putAll(outer.locals);
            }
        }
    }

}

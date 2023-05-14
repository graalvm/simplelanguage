// Generated from SimpleLanguage.g4 by ANTLR 4.9.2

// DO NOT MODIFY - generated from SimpleLanguage.g4 using "mx create-sl-parser"
package com.oracle.truffle.sl.parser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.sl.SLLanguage;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.nodes.SLStatementNode;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		WS=32, COMMENT=33, LINE_COMMENT=34, IDENTIFIER=35, STRING_LITERAL=36, 
		NUMERIC_LITERAL=37;
	public static final int
		RULE_simplelanguage = 0, RULE_function = 1, RULE_block = 2, RULE_statement = 3, 
		RULE_for_statement = 4, RULE_while_statement = 5, RULE_if_statement = 6, 
		RULE_return_statement = 7, RULE_expression = 8, RULE_logic_term = 9, RULE_logic_factor = 10, 
		RULE_arithmetic = 11, RULE_term = 12, RULE_factor = 13, RULE_member_expression = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"simplelanguage", "function", "block", "statement", "for_statement", 
			"while_statement", "if_statement", "return_statement", "expression", 
			"logic_term", "logic_factor", "arithmetic", "term", "factor", "member_expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function'", "'('", "','", "')'", "'{'", "'}'", "'break'", "';'", 
			"'continue'", "'debugger'", "'for'", "'while'", "'if'", "'else'", "'return'", 
			"'||'", "'&&'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'+'", 
			"'-'", "'*'", "'/'", "'='", "'.'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
			"IDENTIFIER", "STRING_LITERAL", "NUMERIC_LITERAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimpleLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private SLNodeFactory factory;
	private Source source;

	private static final class BailoutErrorListener extends BaseErrorListener {
	    private final Source source;
	    BailoutErrorListener(Source source) {
	        this.source = source;
	    }
	    @Override
	    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
	        throwParseError(source, line, charPositionInLine, (Token) offendingSymbol, msg);
	    }
	}

	public void SemErr(Token token, String message) {
	    assert token != null;
	    throwParseError(source, token.getLine(), token.getCharPositionInLine(), token, message);
	}

	private static void throwParseError(Source source, int line, int charPositionInLine, Token token, String message) {
	    int col = charPositionInLine + 1;
	    String location = "-- line " + line + " col " + col + ": ";
	    int length = token == null ? 1 : Math.max(token.getStopIndex() - token.getStartIndex(), 0);
	    throw new SLParseError(source, line, col, length, String.format("Error(s) parsing script:%n" + location + message));
	}

	public static Map<TruffleString, RootCallTarget> parseSL(SLLanguage language, Source source) {
	    SimpleLanguageLexer lexer = new SimpleLanguageLexer(CharStreams.fromString(source.getCharacters().toString()));
	    SimpleLanguageParser parser = new SimpleLanguageParser(new CommonTokenStream(lexer));
	    lexer.removeErrorListeners();
	    parser.removeErrorListeners();
	    BailoutErrorListener listener = new BailoutErrorListener(source);
	    lexer.addErrorListener(listener);
	    parser.addErrorListener(listener);
	    parser.factory = new SLNodeFactory(language, source);
	    parser.source = source;
	    parser.simplelanguage();
	    return parser.factory.getAllFunctions();
	}

	public SimpleLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SimplelanguageContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(SimpleLanguageParser.EOF, 0); }
		public SimplelanguageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simplelanguage; }
	}

	public final SimplelanguageContext simplelanguage() throws RecognitionException {
		SimplelanguageContext _localctx = new SimplelanguageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_simplelanguage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			function();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(31);
				function();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public Token s;
		public BlockContext body;
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleLanguageParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleLanguageParser.IDENTIFIER, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__0);
			setState(40);
			((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(41);
			((FunctionContext)_localctx).s = match(T__1);
			 factory.startFunction(((FunctionContext)_localctx).IDENTIFIER, ((FunctionContext)_localctx).s); 
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(43);
				((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 factory.addFormalParameter(((FunctionContext)_localctx).IDENTIFIER); 
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(45);
					match(T__2);
					setState(46);
					((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					 factory.addFormalParameter(((FunctionContext)_localctx).IDENTIFIER); 
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(55);
			match(T__3);
			setState(56);
			((FunctionContext)_localctx).body = block(false, null);
			 factory.finishFunction(((FunctionContext)_localctx).body.result); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public boolean inLoop;
		public SLStatementNode step;
		public SLStatementNode result;
		public Token s;
		public StatementContext statement;
		public Token e;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BlockContext(ParserRuleContext parent, int invokingState, boolean inLoop, SLStatementNode step) {
			super(parent, invokingState);
			this.inLoop = inLoop;
			this.step = step;
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block(boolean inLoop,SLStatementNode step) throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState(), inLoop, step);
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 factory.startBlock();
			                                                  List<SLStatementNode> body = new ArrayList<>(); 
			setState(60);
			((BlockContext)_localctx).s = match(T__4);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				{
				setState(61);
				((BlockContext)_localctx).statement = statement(inLoop);
				 body.add(((BlockContext)_localctx).statement.result); 
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			((BlockContext)_localctx).e = match(T__5);
			 if (step != null) {
			                                                    body.add(step);
			                                                  }
			                                                  ((BlockContext)_localctx).result =  factory.finishBlock(body, ((BlockContext)_localctx).s.getStartIndex(), ((BlockContext)_localctx).e.getStopIndex() - ((BlockContext)_localctx).s.getStartIndex() + 1, true); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public boolean inLoop;
		public SLStatementNode result;
		public While_statementContext while_statement;
		public For_statementContext for_statement;
		public Token b;
		public Token c;
		public If_statementContext if_statement;
		public Return_statementContext return_statement;
		public ExpressionContext expression;
		public Token d;
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StatementContext(ParserRuleContext parent, int invokingState, boolean inLoop) {
			super(parent, invokingState);
			this.inLoop = inLoop;
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement(boolean inLoop) throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState(), inLoop);
		enterRule(_localctx, 6, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(72);
				((StatementContext)_localctx).while_statement = while_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).while_statement.result; 
				}
				break;
			case T__10:
				{
				setState(75);
				((StatementContext)_localctx).for_statement = for_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).for_statement.result;  
				}
				break;
			case T__6:
				{
				setState(78);
				((StatementContext)_localctx).b = match(T__6);
				 if (inLoop) { ((StatementContext)_localctx).result =  factory.createBreak(((StatementContext)_localctx).b); } else { SemErr(((StatementContext)_localctx).b, "break used outside of loop"); } 
				setState(80);
				match(T__7);
				}
				break;
			case T__8:
				{
				setState(81);
				((StatementContext)_localctx).c = match(T__8);
				 if (inLoop) { ((StatementContext)_localctx).result =  factory.createContinue(((StatementContext)_localctx).c); } else { SemErr(((StatementContext)_localctx).c, "continue used outside of loop"); } 
				setState(83);
				match(T__7);
				}
				break;
			case T__12:
				{
				setState(84);
				((StatementContext)_localctx).if_statement = if_statement(inLoop);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).if_statement.result; 
				}
				break;
			case T__14:
				{
				setState(87);
				((StatementContext)_localctx).return_statement = return_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).return_statement.result; 
				}
				break;
			case T__1:
			case IDENTIFIER:
			case STRING_LITERAL:
			case NUMERIC_LITERAL:
				{
				setState(90);
				((StatementContext)_localctx).expression = expression();
				setState(91);
				match(T__7);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).expression.result; 
				}
				break;
			case T__9:
				{
				setState(94);
				((StatementContext)_localctx).d = match(T__9);
				 ((StatementContext)_localctx).result =  factory.createDebugger(((StatementContext)_localctx).d); 
				setState(96);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_statementContext extends ParserRuleContext {
		public SLStatementNode result;
		public Token f;
		public Token o;
		public ExpressionContext initialization;
		public ExpressionContext condition;
		public ExpressionContext step;
		public Token c;
		public BlockContext body;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			((For_statementContext)_localctx).f = match(T__10);
			 SLStatementNode assignmentNode = null;
			                                                  SLStatementNode stepNode = null; 
			setState(101);
			((For_statementContext)_localctx).o = match(T__1);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(102);
				((For_statementContext)_localctx).initialization = expression();
				 assignmentNode = ((For_statementContext)_localctx).initialization.result; 
				}
			}

			setState(107);
			match(T__7);
			setState(108);
			((For_statementContext)_localctx).condition = expression();
			setState(109);
			match(T__7);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(110);
				((For_statementContext)_localctx).step = expression();
				 stepNode = ((For_statementContext)_localctx).step.result; 
				}
			}

			setState(115);
			((For_statementContext)_localctx).c = match(T__3);
			setState(116);
			((For_statementContext)_localctx).body = block(true, stepNode);
			 SLStatementNode loopNode = factory.createWhile(((For_statementContext)_localctx).f, ((For_statementContext)_localctx).condition.result, ((For_statementContext)_localctx).body.result);
			                                                  if (assignmentNode != null) {
			                                                    List<SLStatementNode> forNode = new ArrayList<>();
			                                                    forNode.add(assignmentNode);
			                                                    forNode.add(loopNode);
			                                                    ((For_statementContext)_localctx).result =  factory.finishBlock(forNode, ((For_statementContext)_localctx).o.getStartIndex(), ((For_statementContext)_localctx).body.result.getSourceEndIndex() - ((For_statementContext)_localctx).o.getStartIndex() + 1, false);
			                                                  } else {
			                                                    ((For_statementContext)_localctx).result =  loopNode;
			                                                  }
			                                                 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_statementContext extends ParserRuleContext {
		public SLStatementNode result;
		public Token w;
		public ExpressionContext condition;
		public BlockContext body;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((While_statementContext)_localctx).w = match(T__11);
			setState(120);
			match(T__1);
			setState(121);
			((While_statementContext)_localctx).condition = expression();
			setState(122);
			match(T__3);
			setState(123);
			((While_statementContext)_localctx).body = block(true, null);
			 ((While_statementContext)_localctx).result =  factory.createWhile(((While_statementContext)_localctx).w, ((While_statementContext)_localctx).condition.result, ((While_statementContext)_localctx).body.result); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statementContext extends ParserRuleContext {
		public boolean inLoop;
		public SLStatementNode result;
		public Token i;
		public ExpressionContext condition;
		public BlockContext then;
		public BlockContext block;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public If_statementContext(ParserRuleContext parent, int invokingState, boolean inLoop) {
			super(parent, invokingState);
			this.inLoop = inLoop;
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	}

	public final If_statementContext if_statement(boolean inLoop) throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState(), inLoop);
		enterRule(_localctx, 12, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			((If_statementContext)_localctx).i = match(T__12);
			setState(127);
			match(T__1);
			setState(128);
			((If_statementContext)_localctx).condition = expression();
			setState(129);
			match(T__3);
			setState(130);
			((If_statementContext)_localctx).then = ((If_statementContext)_localctx).block = block(inLoop, null);
			 SLStatementNode elsePart = null; 
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(132);
				match(T__13);
				setState(133);
				((If_statementContext)_localctx).block = block(inLoop, null);
				 elsePart = ((If_statementContext)_localctx).block.result; 
				}
			}

			 ((If_statementContext)_localctx).result =  factory.createIf(((If_statementContext)_localctx).i, ((If_statementContext)_localctx).condition.result, ((If_statementContext)_localctx).then.result, elsePart); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_statementContext extends ParserRuleContext {
		public SLStatementNode result;
		public Token r;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			((Return_statementContext)_localctx).r = match(T__14);
			 SLExpressionNode value = null; 
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				setState(142);
				((Return_statementContext)_localctx).expression = expression();
				 value = ((Return_statementContext)_localctx).expression.result; 
				}
			}

			 ((Return_statementContext)_localctx).result =  factory.createReturn(((Return_statementContext)_localctx).r, value); 
			setState(148);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public SLExpressionNode result;
		public Logic_termContext logic_term;
		public Token op;
		public List<Logic_termContext> logic_term() {
			return getRuleContexts(Logic_termContext.class);
		}
		public Logic_termContext logic_term(int i) {
			return getRuleContext(Logic_termContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			((ExpressionContext)_localctx).logic_term = logic_term();
			 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).logic_term.result; 
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(152);
					((ExpressionContext)_localctx).op = match(T__15);
					setState(153);
					((ExpressionContext)_localctx).logic_term = logic_term();
					 ((ExpressionContext)_localctx).result =  factory.createBinary(((ExpressionContext)_localctx).op, _localctx.result, ((ExpressionContext)_localctx).logic_term.result); 
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logic_termContext extends ParserRuleContext {
		public SLExpressionNode result;
		public Logic_factorContext logic_factor;
		public Token op;
		public List<Logic_factorContext> logic_factor() {
			return getRuleContexts(Logic_factorContext.class);
		}
		public Logic_factorContext logic_factor(int i) {
			return getRuleContext(Logic_factorContext.class,i);
		}
		public Logic_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_term; }
	}

	public final Logic_termContext logic_term() throws RecognitionException {
		Logic_termContext _localctx = new Logic_termContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_logic_term);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			((Logic_termContext)_localctx).logic_factor = logic_factor();
			 ((Logic_termContext)_localctx).result =  ((Logic_termContext)_localctx).logic_factor.result; 
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(163);
					((Logic_termContext)_localctx).op = match(T__16);
					setState(164);
					((Logic_termContext)_localctx).logic_factor = logic_factor();
					 ((Logic_termContext)_localctx).result =  factory.createBinary(((Logic_termContext)_localctx).op, _localctx.result, ((Logic_termContext)_localctx).logic_factor.result); 
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logic_factorContext extends ParserRuleContext {
		public SLExpressionNode result;
		public ArithmeticContext arithmetic;
		public Token op;
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public Logic_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_factor; }
	}

	public final Logic_factorContext logic_factor() throws RecognitionException {
		Logic_factorContext _localctx = new Logic_factorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_logic_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			((Logic_factorContext)_localctx).arithmetic = arithmetic();
			 ((Logic_factorContext)_localctx).result =  ((Logic_factorContext)_localctx).arithmetic.result; 
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(174);
				((Logic_factorContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
					((Logic_factorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(175);
				((Logic_factorContext)_localctx).arithmetic = arithmetic();
				 ((Logic_factorContext)_localctx).result =  factory.createBinary(((Logic_factorContext)_localctx).op, _localctx.result, ((Logic_factorContext)_localctx).arithmetic.result); 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticContext extends ParserRuleContext {
		public SLExpressionNode result;
		public TermContext term;
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ArithmeticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic; }
	}

	public final ArithmeticContext arithmetic() throws RecognitionException {
		ArithmeticContext _localctx = new ArithmeticContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arithmetic);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			((ArithmeticContext)_localctx).term = term();
			 ((ArithmeticContext)_localctx).result =  ((ArithmeticContext)_localctx).term.result; 
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(182);
					((ArithmeticContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__23 || _la==T__24) ) {
						((ArithmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(183);
					((ArithmeticContext)_localctx).term = term();
					 ((ArithmeticContext)_localctx).result =  factory.createBinary(((ArithmeticContext)_localctx).op, _localctx.result, ((ArithmeticContext)_localctx).term.result); 
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public SLExpressionNode result;
		public FactorContext factor;
		public Token op;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_term);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			((TermContext)_localctx).factor = factor();
			 ((TermContext)_localctx).result =  ((TermContext)_localctx).factor.result; 
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(193);
					((TermContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__25 || _la==T__26) ) {
						((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(194);
					((TermContext)_localctx).factor = factor();
					 ((TermContext)_localctx).result =  factory.createBinary(((TermContext)_localctx).op, _localctx.result, ((TermContext)_localctx).factor.result); 
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public SLExpressionNode result;
		public Token IDENTIFIER;
		public Member_expressionContext member_expression;
		public Token STRING_LITERAL;
		public Token NUMERIC_LITERAL;
		public Token s;
		public ExpressionContext expr;
		public Token e;
		public TerminalNode IDENTIFIER() { return getToken(SimpleLanguageParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SimpleLanguageParser.STRING_LITERAL, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(SimpleLanguageParser.NUMERIC_LITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Member_expressionContext member_expression() {
			return getRuleContext(Member_expressionContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(202);
				((FactorContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 SLExpressionNode assignmentName = factory.createStringLiteral(((FactorContext)_localctx).IDENTIFIER, false); 
				setState(208);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(204);
					((FactorContext)_localctx).member_expression = member_expression(null, null, assignmentName);
					 ((FactorContext)_localctx).result =  ((FactorContext)_localctx).member_expression.result; 
					}
					break;
				case 2:
					{
					 ((FactorContext)_localctx).result =  factory.createRead(assignmentName); 
					}
					break;
				}
				}
				break;
			case STRING_LITERAL:
				{
				setState(210);
				((FactorContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				 ((FactorContext)_localctx).result =  factory.createStringLiteral(((FactorContext)_localctx).STRING_LITERAL, true); 
				}
				break;
			case NUMERIC_LITERAL:
				{
				setState(212);
				((FactorContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
				 ((FactorContext)_localctx).result =  factory.createNumericLiteral(((FactorContext)_localctx).NUMERIC_LITERAL); 
				}
				break;
			case T__1:
				{
				setState(214);
				((FactorContext)_localctx).s = match(T__1);
				setState(215);
				((FactorContext)_localctx).expr = expression();
				setState(216);
				((FactorContext)_localctx).e = match(T__3);
				 ((FactorContext)_localctx).result =  factory.createParenExpression(((FactorContext)_localctx).expr.result, ((FactorContext)_localctx).s.getStartIndex(), ((FactorContext)_localctx).e.getStopIndex() - ((FactorContext)_localctx).s.getStartIndex() + 1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_expressionContext extends ParserRuleContext {
		public SLExpressionNode r;
		public SLExpressionNode assignmentReceiver;
		public SLExpressionNode assignmentName;
		public SLExpressionNode result;
		public ExpressionContext expression;
		public Token e;
		public Token IDENTIFIER;
		public Member_expressionContext member_expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(SimpleLanguageParser.IDENTIFIER, 0); }
		public Member_expressionContext member_expression() {
			return getRuleContext(Member_expressionContext.class,0);
		}
		public Member_expressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Member_expressionContext(ParserRuleContext parent, int invokingState, SLExpressionNode r, SLExpressionNode assignmentReceiver, SLExpressionNode assignmentName) {
			super(parent, invokingState);
			this.r = r;
			this.assignmentReceiver = assignmentReceiver;
			this.assignmentName = assignmentName;
		}
		@Override public int getRuleIndex() { return RULE_member_expression; }
	}

	public final Member_expressionContext member_expression(SLExpressionNode r,SLExpressionNode assignmentReceiver,SLExpressionNode assignmentName) throws RecognitionException {
		Member_expressionContext _localctx = new Member_expressionContext(_ctx, getState(), r, assignmentReceiver, assignmentName);
		enterRule(_localctx, 28, RULE_member_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 SLExpressionNode receiver = r;
			                                                  SLExpressionNode nestedAssignmentName = null; 
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(222);
				match(T__1);
				 List<SLExpressionNode> parameters = new ArrayList<>();
				                                                  if (receiver == null) {
				                                                      receiver = factory.createRead(assignmentName);
				                                                  } 
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << IDENTIFIER) | (1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL))) != 0)) {
					{
					setState(224);
					((Member_expressionContext)_localctx).expression = expression();
					 parameters.add(((Member_expressionContext)_localctx).expression.result); 
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(226);
						match(T__2);
						setState(227);
						((Member_expressionContext)_localctx).expression = expression();
						 parameters.add(((Member_expressionContext)_localctx).expression.result); 
						}
						}
						setState(234);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(237);
				((Member_expressionContext)_localctx).e = match(T__3);
				 ((Member_expressionContext)_localctx).result =  factory.createCall(receiver, parameters, ((Member_expressionContext)_localctx).e); 
				}
				break;
			case T__27:
				{
				setState(239);
				match(T__27);
				setState(240);
				((Member_expressionContext)_localctx).expression = expression();
				 if (assignmentName == null) {
				                                                      SemErr((((Member_expressionContext)_localctx).expression!=null?(((Member_expressionContext)_localctx).expression.start):null), "invalid assignment target");
				                                                  } else if (assignmentReceiver == null) {
				                                                      ((Member_expressionContext)_localctx).result =  factory.createAssignment(assignmentName, ((Member_expressionContext)_localctx).expression.result);
				                                                  } else {
				                                                      ((Member_expressionContext)_localctx).result =  factory.createWriteProperty(assignmentReceiver, assignmentName, ((Member_expressionContext)_localctx).expression.result);
				                                                  } 
				}
				break;
			case T__28:
				{
				setState(243);
				match(T__28);
				 if (receiver == null) {
				                                                       receiver = factory.createRead(assignmentName);
				                                                  } 
				setState(245);
				((Member_expressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 nestedAssignmentName = factory.createStringLiteral(((Member_expressionContext)_localctx).IDENTIFIER, false);
				                                                  ((Member_expressionContext)_localctx).result =  factory.createReadProperty(receiver, nestedAssignmentName); 
				}
				break;
			case T__29:
				{
				setState(247);
				match(T__29);
				 if (receiver == null) {
				                                                      receiver = factory.createRead(assignmentName);
				                                                  } 
				setState(249);
				((Member_expressionContext)_localctx).expression = expression();
				 nestedAssignmentName = ((Member_expressionContext)_localctx).expression.result;
				                                                  ((Member_expressionContext)_localctx).result =  factory.createReadProperty(receiver, nestedAssignmentName); 
				setState(251);
				match(T__30);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(255);
				((Member_expressionContext)_localctx).member_expression = member_expression(_localctx.result, receiver, nestedAssignmentName);
				 ((Member_expressionContext)_localctx).result =  ((Member_expressionContext)_localctx).member_expression.result; 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0107\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f\2"+
		"\16\2&\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\63\n\3\f\3"+
		"\16\3\66\13\3\5\38\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4C\n\4\f"+
		"\4\16\4F\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5d\n\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6l\n\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6t\n\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\5\b\u008b\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u0094\n\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u009f\n\n\f\n\16\n\u00a2\13\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\7\13\u00aa\n\13\f\13\16\13\u00ad\13\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\5\f\u00b5\n\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00bd\n\r\f"+
		"\r\16\r\u00c0\13\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00c8\n\16\f\16"+
		"\16\16\u00cb\13\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d3\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00de\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00e9\n\20\f\20\16\20\u00ec\13\20"+
		"\5\20\u00ee\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0100\n\20\3\20\3\20\3\20\5\20\u0105\n"+
		"\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\5\3\2\24\31\3"+
		"\2\32\33\3\2\34\35\2\u0115\2 \3\2\2\2\4)\3\2\2\2\6=\3\2\2\2\bc\3\2\2\2"+
		"\ne\3\2\2\2\fy\3\2\2\2\16\u0080\3\2\2\2\20\u008e\3\2\2\2\22\u0098\3\2"+
		"\2\2\24\u00a3\3\2\2\2\26\u00ae\3\2\2\2\30\u00b6\3\2\2\2\32\u00c1\3\2\2"+
		"\2\34\u00dd\3\2\2\2\36\u00df\3\2\2\2 $\5\4\3\2!#\5\4\3\2\"!\3\2\2\2#&"+
		"\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'(\7\2\2\3(\3\3\2\2"+
		"\2)*\7\3\2\2*+\7%\2\2+,\7\4\2\2,\67\b\3\1\2-.\7%\2\2.\64\b\3\1\2/\60\7"+
		"\5\2\2\60\61\7%\2\2\61\63\b\3\1\2\62/\3\2\2\2\63\66\3\2\2\2\64\62\3\2"+
		"\2\2\64\65\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\67-\3\2\2\2\678\3\2\2\28"+
		"9\3\2\2\29:\7\6\2\2:;\5\6\4\2;<\b\3\1\2<\5\3\2\2\2=>\b\4\1\2>D\7\7\2\2"+
		"?@\5\b\5\2@A\b\4\1\2AC\3\2\2\2B?\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2"+
		"EG\3\2\2\2FD\3\2\2\2GH\7\b\2\2HI\b\4\1\2I\7\3\2\2\2JK\5\f\7\2KL\b\5\1"+
		"\2Ld\3\2\2\2MN\5\n\6\2NO\b\5\1\2Od\3\2\2\2PQ\7\t\2\2QR\b\5\1\2Rd\7\n\2"+
		"\2ST\7\13\2\2TU\b\5\1\2Ud\7\n\2\2VW\5\16\b\2WX\b\5\1\2Xd\3\2\2\2YZ\5\20"+
		"\t\2Z[\b\5\1\2[d\3\2\2\2\\]\5\22\n\2]^\7\n\2\2^_\b\5\1\2_d\3\2\2\2`a\7"+
		"\f\2\2ab\b\5\1\2bd\7\n\2\2cJ\3\2\2\2cM\3\2\2\2cP\3\2\2\2cS\3\2\2\2cV\3"+
		"\2\2\2cY\3\2\2\2c\\\3\2\2\2c`\3\2\2\2d\t\3\2\2\2ef\7\r\2\2fg\b\6\1\2g"+
		"k\7\4\2\2hi\5\22\n\2ij\b\6\1\2jl\3\2\2\2kh\3\2\2\2kl\3\2\2\2lm\3\2\2\2"+
		"mn\7\n\2\2no\5\22\n\2os\7\n\2\2pq\5\22\n\2qr\b\6\1\2rt\3\2\2\2sp\3\2\2"+
		"\2st\3\2\2\2tu\3\2\2\2uv\7\6\2\2vw\5\6\4\2wx\b\6\1\2x\13\3\2\2\2yz\7\16"+
		"\2\2z{\7\4\2\2{|\5\22\n\2|}\7\6\2\2}~\5\6\4\2~\177\b\7\1\2\177\r\3\2\2"+
		"\2\u0080\u0081\7\17\2\2\u0081\u0082\7\4\2\2\u0082\u0083\5\22\n\2\u0083"+
		"\u0084\7\6\2\2\u0084\u0085\5\6\4\2\u0085\u008a\b\b\1\2\u0086\u0087\7\20"+
		"\2\2\u0087\u0088\5\6\4\2\u0088\u0089\b\b\1\2\u0089\u008b\3\2\2\2\u008a"+
		"\u0086\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\b\b"+
		"\1\2\u008d\17\3\2\2\2\u008e\u008f\7\21\2\2\u008f\u0093\b\t\1\2\u0090\u0091"+
		"\5\22\n\2\u0091\u0092\b\t\1\2\u0092\u0094\3\2\2\2\u0093\u0090\3\2\2\2"+
		"\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\b\t\1\2\u0096\u0097"+
		"\7\n\2\2\u0097\21\3\2\2\2\u0098\u0099\5\24\13\2\u0099\u00a0\b\n\1\2\u009a"+
		"\u009b\7\22\2\2\u009b\u009c\5\24\13\2\u009c\u009d\b\n\1\2\u009d\u009f"+
		"\3\2\2\2\u009e\u009a\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\23\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\5\26\f"+
		"\2\u00a4\u00ab\b\13\1\2\u00a5\u00a6\7\23\2\2\u00a6\u00a7\5\26\f\2\u00a7"+
		"\u00a8\b\13\1\2\u00a8\u00aa\3\2\2\2\u00a9\u00a5\3\2\2\2\u00aa\u00ad\3"+
		"\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\25\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00af\5\30\r\2\u00af\u00b4\b\f\1\2\u00b0\u00b1\t"+
		"\2\2\2\u00b1\u00b2\5\30\r\2\u00b2\u00b3\b\f\1\2\u00b3\u00b5\3\2\2\2\u00b4"+
		"\u00b0\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\27\3\2\2\2\u00b6\u00b7\5\32\16"+
		"\2\u00b7\u00be\b\r\1\2\u00b8\u00b9\t\3\2\2\u00b9\u00ba\5\32\16\2\u00ba"+
		"\u00bb\b\r\1\2\u00bb\u00bd\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd\u00c0\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\31\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c1\u00c2\5\34\17\2\u00c2\u00c9\b\16\1\2\u00c3\u00c4\t\4\2"+
		"\2\u00c4\u00c5\5\34\17\2\u00c5\u00c6\b\16\1\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00c3\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\33\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7%\2\2\u00cd\u00d2"+
		"\b\17\1\2\u00ce\u00cf\5\36\20\2\u00cf\u00d0\b\17\1\2\u00d0\u00d3\3\2\2"+
		"\2\u00d1\u00d3\b\17\1\2\u00d2\u00ce\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"\u00de\3\2\2\2\u00d4\u00d5\7&\2\2\u00d5\u00de\b\17\1\2\u00d6\u00d7\7\'"+
		"\2\2\u00d7\u00de\b\17\1\2\u00d8\u00d9\7\4\2\2\u00d9\u00da\5\22\n\2\u00da"+
		"\u00db\7\6\2\2\u00db\u00dc\b\17\1\2\u00dc\u00de\3\2\2\2\u00dd\u00cc\3"+
		"\2\2\2\u00dd\u00d4\3\2\2\2\u00dd\u00d6\3\2\2\2\u00dd\u00d8\3\2\2\2\u00de"+
		"\35\3\2\2\2\u00df\u00ff\b\20\1\2\u00e0\u00e1\7\4\2\2\u00e1\u00ed\b\20"+
		"\1\2\u00e2\u00e3\5\22\n\2\u00e3\u00ea\b\20\1\2\u00e4\u00e5\7\5\2\2\u00e5"+
		"\u00e6\5\22\n\2\u00e6\u00e7\b\20\1\2\u00e7\u00e9\3\2\2\2\u00e8\u00e4\3"+
		"\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00e2\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\7\6\2\2\u00f0\u0100\b\20\1\2\u00f1"+
		"\u00f2\7\36\2\2\u00f2\u00f3\5\22\n\2\u00f3\u00f4\b\20\1\2\u00f4\u0100"+
		"\3\2\2\2\u00f5\u00f6\7\37\2\2\u00f6\u00f7\b\20\1\2\u00f7\u00f8\7%\2\2"+
		"\u00f8\u0100\b\20\1\2\u00f9\u00fa\7 \2\2\u00fa\u00fb\b\20\1\2\u00fb\u00fc"+
		"\5\22\n\2\u00fc\u00fd\b\20\1\2\u00fd\u00fe\7!\2\2\u00fe\u0100\3\2\2\2"+
		"\u00ff\u00e0\3\2\2\2\u00ff\u00f1\3\2\2\2\u00ff\u00f5\3\2\2\2\u00ff\u00f9"+
		"\3\2\2\2\u0100\u0104\3\2\2\2\u0101\u0102\5\36\20\2\u0102\u0103\b\20\1"+
		"\2\u0103\u0105\3\2\2\2\u0104\u0101\3\2\2\2\u0104\u0105\3\2\2\2\u0105\37"+
		"\3\2\2\2\26$\64\67Dcks\u008a\u0093\u00a0\u00ab\u00b4\u00be\u00c9\u00d2"+
		"\u00dd\u00ea\u00ed\u00ff\u0104";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
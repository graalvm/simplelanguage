// Generated from language/src/main/java/com/oracle/truffle/tcl/parser/Tcl.g4 by ANTLR 4.7.1
package com.oracle.truffle.tcl.parser;

// DO NOT MODIFY - generated from SimpleLanguage.g4 using "mx create-sl-parser"

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TclLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, IDENTIFIER=48, VALUE_INTEGER=49, VALUE_DOUBLE=50, 
		VALUE_STRING=51, WS=52, COMMENT=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "IDENTIFIER", "VALUE_INTEGER", 
		"VALUE_DOUBLE", "VALUE_STRING", "WS", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'proc'", "'{'", "'}'", "';'", "'puts'", "'gets'", "'stdin'", "'set'", 
		"'['", "']'", "'array'", "'size'", "'exists'", "'$'", "'('", "')'", "'break'", 
		"'continue'", "'return'", "'expr'", "'if'", "'then'", "'elseif'", "'else'", 
		"'switch'", "'case'", "'default'", "'for'", "'incr'", "'while'", "'||'", 
		"'&&'", "'**'", "'eq'", "'=='", "'ne'", "'!='", "'>'", "'<'", "'>='", 
		"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"IDENTIFIER", "VALUE_INTEGER", "VALUE_DOUBLE", "VALUE_STRING", "WS", "COMMENT"
	};
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


	public TclLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tcl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u0158\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		"!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3("+
		"\3)\3)\3)\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\7"+
		"\61\u0128\n\61\f\61\16\61\u012b\13\61\3\62\5\62\u012e\n\62\3\62\6\62\u0131"+
		"\n\62\r\62\16\62\u0132\3\63\6\63\u0136\n\63\r\63\16\63\u0137\3\63\3\63"+
		"\6\63\u013c\n\63\r\63\16\63\u013d\3\64\3\64\7\64\u0142\n\64\f\64\16\64"+
		"\u0145\13\64\3\64\3\64\3\65\6\65\u014a\n\65\r\65\16\65\u014b\3\65\3\65"+
		"\3\66\3\66\7\66\u0152\n\66\f\66\16\66\u0155\13\66\3\66\3\66\2\2\67\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67\3\2\b\5"+
		"\2C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2\f\f\17\17$$\5\2\13\f\17\17\"\"\4"+
		"\2\f\f\17\17\2\u015f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2"+
		"\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2"+
		"\2k\3\2\2\2\3m\3\2\2\2\5r\3\2\2\2\7t\3\2\2\2\tv\3\2\2\2\13x\3\2\2\2\r"+
		"}\3\2\2\2\17\u0082\3\2\2\2\21\u0088\3\2\2\2\23\u008c\3\2\2\2\25\u008e"+
		"\3\2\2\2\27\u0090\3\2\2\2\31\u0096\3\2\2\2\33\u009b\3\2\2\2\35\u00a2\3"+
		"\2\2\2\37\u00a4\3\2\2\2!\u00a6\3\2\2\2#\u00a8\3\2\2\2%\u00ae\3\2\2\2\'"+
		"\u00b7\3\2\2\2)\u00be\3\2\2\2+\u00c3\3\2\2\2-\u00c6\3\2\2\2/\u00cb\3\2"+
		"\2\2\61\u00d2\3\2\2\2\63\u00d7\3\2\2\2\65\u00de\3\2\2\2\67\u00e3\3\2\2"+
		"\29\u00eb\3\2\2\2;\u00ef\3\2\2\2=\u00f4\3\2\2\2?\u00fa\3\2\2\2A\u00fd"+
		"\3\2\2\2C\u0100\3\2\2\2E\u0103\3\2\2\2G\u0106\3\2\2\2I\u0109\3\2\2\2K"+
		"\u010c\3\2\2\2M\u010f\3\2\2\2O\u0111\3\2\2\2Q\u0113\3\2\2\2S\u0116\3\2"+
		"\2\2U\u0119\3\2\2\2W\u011b\3\2\2\2Y\u011d\3\2\2\2[\u011f\3\2\2\2]\u0121"+
		"\3\2\2\2_\u0123\3\2\2\2a\u0125\3\2\2\2c\u012d\3\2\2\2e\u0135\3\2\2\2g"+
		"\u013f\3\2\2\2i\u0149\3\2\2\2k\u014f\3\2\2\2mn\7r\2\2no\7t\2\2op\7q\2"+
		"\2pq\7e\2\2q\4\3\2\2\2rs\7}\2\2s\6\3\2\2\2tu\7\177\2\2u\b\3\2\2\2vw\7"+
		"=\2\2w\n\3\2\2\2xy\7r\2\2yz\7w\2\2z{\7v\2\2{|\7u\2\2|\f\3\2\2\2}~\7i\2"+
		"\2~\177\7g\2\2\177\u0080\7v\2\2\u0080\u0081\7u\2\2\u0081\16\3\2\2\2\u0082"+
		"\u0083\7u\2\2\u0083\u0084\7v\2\2\u0084\u0085\7f\2\2\u0085\u0086\7k\2\2"+
		"\u0086\u0087\7p\2\2\u0087\20\3\2\2\2\u0088\u0089\7u\2\2\u0089\u008a\7"+
		"g\2\2\u008a\u008b\7v\2\2\u008b\22\3\2\2\2\u008c\u008d\7]\2\2\u008d\24"+
		"\3\2\2\2\u008e\u008f\7_\2\2\u008f\26\3\2\2\2\u0090\u0091\7c\2\2\u0091"+
		"\u0092\7t\2\2\u0092\u0093\7t\2\2\u0093\u0094\7c\2\2\u0094\u0095\7{\2\2"+
		"\u0095\30\3\2\2\2\u0096\u0097\7u\2\2\u0097\u0098\7k\2\2\u0098\u0099\7"+
		"|\2\2\u0099\u009a\7g\2\2\u009a\32\3\2\2\2\u009b\u009c\7g\2\2\u009c\u009d"+
		"\7z\2\2\u009d\u009e\7k\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7v\2\2\u00a0"+
		"\u00a1\7u\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7&\2\2\u00a3\36\3\2\2\2\u00a4"+
		"\u00a5\7*\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7+\2\2\u00a7\"\3\2\2\2\u00a8"+
		"\u00a9\7d\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7c\2\2"+
		"\u00ac\u00ad\7m\2\2\u00ad$\3\2\2\2\u00ae\u00af\7e\2\2\u00af\u00b0\7q\2"+
		"\2\u00b0\u00b1\7p\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4"+
		"\7p\2\2\u00b4\u00b5\7w\2\2\u00b5\u00b6\7g\2\2\u00b6&\3\2\2\2\u00b7\u00b8"+
		"\7t\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb\7w\2\2\u00bb"+
		"\u00bc\7t\2\2\u00bc\u00bd\7p\2\2\u00bd(\3\2\2\2\u00be\u00bf\7g\2\2\u00bf"+
		"\u00c0\7z\2\2\u00c0\u00c1\7r\2\2\u00c1\u00c2\7t\2\2\u00c2*\3\2\2\2\u00c3"+
		"\u00c4\7k\2\2\u00c4\u00c5\7h\2\2\u00c5,\3\2\2\2\u00c6\u00c7\7v\2\2\u00c7"+
		"\u00c8\7j\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7p\2\2\u00ca.\3\2\2\2\u00cb"+
		"\u00cc\7g\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7u\2\2\u00ce\u00cf\7g\2\2"+
		"\u00cf\u00d0\7k\2\2\u00d0\u00d1\7h\2\2\u00d1\60\3\2\2\2\u00d2\u00d3\7"+
		"g\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5\7u\2\2\u00d5\u00d6\7g\2\2\u00d6\62"+
		"\3\2\2\2\u00d7\u00d8\7u\2\2\u00d8\u00d9\7y\2\2\u00d9\u00da\7k\2\2\u00da"+
		"\u00db\7v\2\2\u00db\u00dc\7e\2\2\u00dc\u00dd\7j\2\2\u00dd\64\3\2\2\2\u00de"+
		"\u00df\7e\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7g\2\2"+
		"\u00e2\66\3\2\2\2\u00e3\u00e4\7f\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\7"+
		"h\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7w\2\2\u00e8\u00e9\7n\2\2\u00e9\u00ea"+
		"\7v\2\2\u00ea8\3\2\2\2\u00eb\u00ec\7h\2\2\u00ec\u00ed\7q\2\2\u00ed\u00ee"+
		"\7t\2\2\u00ee:\3\2\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2"+
		"\7e\2\2\u00f2\u00f3\7t\2\2\u00f3<\3\2\2\2\u00f4\u00f5\7y\2\2\u00f5\u00f6"+
		"\7j\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7g\2\2\u00f9"+
		">\3\2\2\2\u00fa\u00fb\7~\2\2\u00fb\u00fc\7~\2\2\u00fc@\3\2\2\2\u00fd\u00fe"+
		"\7(\2\2\u00fe\u00ff\7(\2\2\u00ffB\3\2\2\2\u0100\u0101\7,\2\2\u0101\u0102"+
		"\7,\2\2\u0102D\3\2\2\2\u0103\u0104\7g\2\2\u0104\u0105\7s\2\2\u0105F\3"+
		"\2\2\2\u0106\u0107\7?\2\2\u0107\u0108\7?\2\2\u0108H\3\2\2\2\u0109\u010a"+
		"\7p\2\2\u010a\u010b\7g\2\2\u010bJ\3\2\2\2\u010c\u010d\7#\2\2\u010d\u010e"+
		"\7?\2\2\u010eL\3\2\2\2\u010f\u0110\7@\2\2\u0110N\3\2\2\2\u0111\u0112\7"+
		">\2\2\u0112P\3\2\2\2\u0113\u0114\7@\2\2\u0114\u0115\7?\2\2\u0115R\3\2"+
		"\2\2\u0116\u0117\7>\2\2\u0117\u0118\7?\2\2\u0118T\3\2\2\2\u0119\u011a"+
		"\7-\2\2\u011aV\3\2\2\2\u011b\u011c\7/\2\2\u011cX\3\2\2\2\u011d\u011e\7"+
		",\2\2\u011eZ\3\2\2\2\u011f\u0120\7\61\2\2\u0120\\\3\2\2\2\u0121\u0122"+
		"\7\'\2\2\u0122^\3\2\2\2\u0123\u0124\7#\2\2\u0124`\3\2\2\2\u0125\u0129"+
		"\t\2\2\2\u0126\u0128\t\3\2\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012ab\3\2\2\2\u012b\u0129\3\2\2\2"+
		"\u012c\u012e\7/\2\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130"+
		"\3\2\2\2\u012f\u0131\t\4\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133d\3\2\2\2\u0134\u0136\t\4\2\2"+
		"\u0135\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138"+
		"\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\7\60\2\2\u013a\u013c\t\4\2\2"+
		"\u013b\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e"+
		"\3\2\2\2\u013ef\3\2\2\2\u013f\u0143\7$\2\2\u0140\u0142\n\5\2\2\u0141\u0140"+
		"\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u0146\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0147\7$\2\2\u0147h\3\2\2\2\u0148"+
		"\u014a\t\6\2\2\u0149\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0149\3\2"+
		"\2\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\b\65\2\2\u014e"+
		"j\3\2\2\2\u014f\u0153\7%\2\2\u0150\u0152\n\7\2\2\u0151\u0150\3\2\2\2\u0152"+
		"\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0156\3\2"+
		"\2\2\u0155\u0153\3\2\2\2\u0156\u0157\b\66\2\2\u0157l\3\2\2\2\13\2\u0129"+
		"\u012d\u0132\u0137\u013d\u0143\u014b\u0153\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
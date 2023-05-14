// Generated from SimpleLanguage.g4 by ANTLR 4.9.2

// DO NOT MODIFY - generated from SimpleLanguage.g4 using "mx create-sl-parser"
package com.oracle.truffle.sl.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, WS=34, COMMENT=35, LINE_COMMENT=36, IDENTIFIER=37, 
		STRING_LITERAL=38, NUMERIC_LITERAL=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"WS", "COMMENT", "LINE_COMMENT", "LETTER", "NON_ZERO_DIGIT", "DIGIT", 
			"HEX_DIGIT", "OCT_DIGIT", "BINARY_DIGIT", "TAB", "STRING_CHAR", "IDENTIFIER", 
			"STRING_LITERAL", "NUMERIC_LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function'", "'('", "','", "')'", "'{'", "'}'", "'break'", "';'", 
			"'continue'", "'debugger'", "'for'", "'pfor'", "'='", "':'", "'while'", 
			"'if'", "'else'", "'return'", "'||'", "'&&'", "'<'", "'<='", "'>'", "'>='", 
			"'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'.'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "WS", "COMMENT", 
			"LINE_COMMENT", "IDENTIFIER", "STRING_LITERAL", "NUMERIC_LITERAL"
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


	public SimpleLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLanguage.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u0121\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\6#\u00d6"+
		"\n#\r#\16#\u00d7\3#\3#\3$\3$\3$\3$\7$\u00e0\n$\f$\16$\u00e3\13$\3$\3$"+
		"\3$\3$\3$\3%\3%\3%\3%\7%\u00ee\n%\f%\16%\u00f1\13%\3%\3%\3&\5&\u00f6\n"+
		"&\3\'\3\'\3(\3(\3)\5)\u00fd\n)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\7.\u010a"+
		"\n.\f.\16.\u010d\13.\3/\3/\7/\u0111\n/\f/\16/\u0114\13/\3/\3/\3\60\3\60"+
		"\3\60\7\60\u011b\n\60\f\60\16\60\u011e\13\60\5\60\u0120\n\60\3\u00e1\2"+
		"\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\2M\2O\2Q\2S\2U\2W\2Y\2[\'](_)\3\2\n\5\2\13\f\16\17"+
		"\"\"\4\2\f\f\17\17\6\2&&C\\aac|\3\2\63;\3\2\62;\5\2\62;CHch\3\2\629\6"+
		"\2\f\f\17\17$$^^\2\u0120\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3"+
		"a\3\2\2\2\5j\3\2\2\2\7l\3\2\2\2\tn\3\2\2\2\13p\3\2\2\2\rr\3\2\2\2\17t"+
		"\3\2\2\2\21z\3\2\2\2\23|\3\2\2\2\25\u0085\3\2\2\2\27\u008e\3\2\2\2\31"+
		"\u0092\3\2\2\2\33\u0097\3\2\2\2\35\u0099\3\2\2\2\37\u009b\3\2\2\2!\u00a1"+
		"\3\2\2\2#\u00a4\3\2\2\2%\u00a9\3\2\2\2\'\u00b0\3\2\2\2)\u00b3\3\2\2\2"+
		"+\u00b6\3\2\2\2-\u00b8\3\2\2\2/\u00bb\3\2\2\2\61\u00bd\3\2\2\2\63\u00c0"+
		"\3\2\2\2\65\u00c3\3\2\2\2\67\u00c6\3\2\2\29\u00c8\3\2\2\2;\u00ca\3\2\2"+
		"\2=\u00cc\3\2\2\2?\u00ce\3\2\2\2A\u00d0\3\2\2\2C\u00d2\3\2\2\2E\u00d5"+
		"\3\2\2\2G\u00db\3\2\2\2I\u00e9\3\2\2\2K\u00f5\3\2\2\2M\u00f7\3\2\2\2O"+
		"\u00f9\3\2\2\2Q\u00fc\3\2\2\2S\u00fe\3\2\2\2U\u0100\3\2\2\2W\u0102\3\2"+
		"\2\2Y\u0104\3\2\2\2[\u0106\3\2\2\2]\u010e\3\2\2\2_\u011f\3\2\2\2ab\7h"+
		"\2\2bc\7w\2\2cd\7p\2\2de\7e\2\2ef\7v\2\2fg\7k\2\2gh\7q\2\2hi\7p\2\2i\4"+
		"\3\2\2\2jk\7*\2\2k\6\3\2\2\2lm\7.\2\2m\b\3\2\2\2no\7+\2\2o\n\3\2\2\2p"+
		"q\7}\2\2q\f\3\2\2\2rs\7\177\2\2s\16\3\2\2\2tu\7d\2\2uv\7t\2\2vw\7g\2\2"+
		"wx\7c\2\2xy\7m\2\2y\20\3\2\2\2z{\7=\2\2{\22\3\2\2\2|}\7e\2\2}~\7q\2\2"+
		"~\177\7p\2\2\177\u0080\7v\2\2\u0080\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082"+
		"\u0083\7w\2\2\u0083\u0084\7g\2\2\u0084\24\3\2\2\2\u0085\u0086\7f\2\2\u0086"+
		"\u0087\7g\2\2\u0087\u0088\7d\2\2\u0088\u0089\7w\2\2\u0089\u008a\7i\2\2"+
		"\u008a\u008b\7i\2\2\u008b\u008c\7g\2\2\u008c\u008d\7t\2\2\u008d\26\3\2"+
		"\2\2\u008e\u008f\7h\2\2\u008f\u0090\7q\2\2\u0090\u0091\7t\2\2\u0091\30"+
		"\3\2\2\2\u0092\u0093\7r\2\2\u0093\u0094\7h\2\2\u0094\u0095\7q\2\2\u0095"+
		"\u0096\7t\2\2\u0096\32\3\2\2\2\u0097\u0098\7?\2\2\u0098\34\3\2\2\2\u0099"+
		"\u009a\7<\2\2\u009a\36\3\2\2\2\u009b\u009c\7y\2\2\u009c\u009d\7j\2\2\u009d"+
		"\u009e\7k\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7g\2\2\u00a0 \3\2\2\2\u00a1"+
		"\u00a2\7k\2\2\u00a2\u00a3\7h\2\2\u00a3\"\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5"+
		"\u00a6\7n\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7g\2\2\u00a8$\3\2\2\2\u00a9"+
		"\u00aa\7t\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7w\2\2"+
		"\u00ad\u00ae\7t\2\2\u00ae\u00af\7p\2\2\u00af&\3\2\2\2\u00b0\u00b1\7~\2"+
		"\2\u00b1\u00b2\7~\2\2\u00b2(\3\2\2\2\u00b3\u00b4\7(\2\2\u00b4\u00b5\7"+
		"(\2\2\u00b5*\3\2\2\2\u00b6\u00b7\7>\2\2\u00b7,\3\2\2\2\u00b8\u00b9\7>"+
		"\2\2\u00b9\u00ba\7?\2\2\u00ba.\3\2\2\2\u00bb\u00bc\7@\2\2\u00bc\60\3\2"+
		"\2\2\u00bd\u00be\7@\2\2\u00be\u00bf\7?\2\2\u00bf\62\3\2\2\2\u00c0\u00c1"+
		"\7?\2\2\u00c1\u00c2\7?\2\2\u00c2\64\3\2\2\2\u00c3\u00c4\7#\2\2\u00c4\u00c5"+
		"\7?\2\2\u00c5\66\3\2\2\2\u00c6\u00c7\7-\2\2\u00c78\3\2\2\2\u00c8\u00c9"+
		"\7/\2\2\u00c9:\3\2\2\2\u00ca\u00cb\7,\2\2\u00cb<\3\2\2\2\u00cc\u00cd\7"+
		"\61\2\2\u00cd>\3\2\2\2\u00ce\u00cf\7\60\2\2\u00cf@\3\2\2\2\u00d0\u00d1"+
		"\7]\2\2\u00d1B\3\2\2\2\u00d2\u00d3\7_\2\2\u00d3D\3\2\2\2\u00d4\u00d6\t"+
		"\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\b#\2\2\u00daF\3\2\2\2\u00db"+
		"\u00dc\7\61\2\2\u00dc\u00dd\7,\2\2\u00dd\u00e1\3\2\2\2\u00de\u00e0\13"+
		"\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7,"+
		"\2\2\u00e5\u00e6\7\61\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\b$\2\2\u00e8"+
		"H\3\2\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00eb\7\61\2\2\u00eb\u00ef\3\2\2"+
		"\2\u00ec\u00ee\n\3\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed"+
		"\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2"+
		"\u00f3\b%\2\2\u00f3J\3\2\2\2\u00f4\u00f6\t\4\2\2\u00f5\u00f4\3\2\2\2\u00f6"+
		"L\3\2\2\2\u00f7\u00f8\t\5\2\2\u00f8N\3\2\2\2\u00f9\u00fa\t\6\2\2\u00fa"+
		"P\3\2\2\2\u00fb\u00fd\t\7\2\2\u00fc\u00fb\3\2\2\2\u00fdR\3\2\2\2\u00fe"+
		"\u00ff\t\b\2\2\u00ffT\3\2\2\2\u0100\u0101\4\62\63\2\u0101V\3\2\2\2\u0102"+
		"\u0103\7\13\2\2\u0103X\3\2\2\2\u0104\u0105\n\t\2\2\u0105Z\3\2\2\2\u0106"+
		"\u010b\5K&\2\u0107\u010a\5K&\2\u0108\u010a\5O(\2\u0109\u0107\3\2\2\2\u0109"+
		"\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2"+
		"\2\2\u010c\\\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0112\7$\2\2\u010f\u0111"+
		"\5Y-\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\7$"+
		"\2\2\u0116^\3\2\2\2\u0117\u0120\7\62\2\2\u0118\u011c\5M\'\2\u0119\u011b"+
		"\5O(\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0117\3\2"+
		"\2\2\u011f\u0118\3\2\2\2\u0120`\3\2\2\2\r\2\u00d7\u00e1\u00ef\u00f5\u00fc"+
		"\u0109\u010b\u0112\u011c\u011f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
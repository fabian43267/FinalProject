// Generated from MyGrammar.g4 by ANTLR 4.4
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, IF=2, ELSE=3, WHILE=4, FOR=5, FORK=6, JOIN=7, COMMA=8, SC=9, QUOTE=10, 
		SQUOTE=11, ASSIGN=12, LBRACE=13, RBRACE=14, LPARENT=15, RPARENT=16, LSQBRAC=17, 
		RSQBRAC=18, EXP=19, NEG=20, MULT=21, ADD=22, TYPE=23, BOOL=24, ID=25, 
		NUM=26, CHAR=27, COMP=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'"
	};
	public static final String[] ruleNames = {
		"T__0", "IF", "ELSE", "WHILE", "FOR", "FORK", "JOIN", "COMMA", "SC", "QUOTE", 
		"SQUOTE", "ASSIGN", "LBRACE", "RBRACE", "LPARENT", "RPARENT", "LSQBRAC", 
		"RSQBRAC", "EXP", "NEG", "MULT", "ADD", "TYPE", "TYPE_INT", "TYPE_BOOL", 
		"TYPE_CHAR", "BOOL", "ID", "NUM", "CHAR", "LETTER", "DIGIT", "COMP", "EQ", 
		"NE", "GE", "GT", "LE", "LT", "WS"
	};


	public MyGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00e3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\5\30\u0093"+
		"\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00ac\n\34\3\35"+
		"\3\35\3\35\7\35\u00b1\n\35\f\35\16\35\u00b4\13\35\3\36\3\36\3\36\7\36"+
		"\u00b9\n\36\f\36\16\36\u00bc\13\36\5\36\u00be\n\36\3\37\3\37\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00ce\n\"\3#\3#\3#\3$\3$\3$\3"+
		"%\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\2\63\2\65\2\67\329\33;\34=\35?\2A\2C\36E\2G\2I\2K"+
		"\2M\2O\2Q\37\3\2\7\3\2\63;\3\2))\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\u00e3"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2C\3\2\2\2\2Q\3\2\2\2"+
		"\3S\3\2\2\2\5U\3\2\2\2\7X\3\2\2\2\t]\3\2\2\2\13c\3\2\2\2\rg\3\2\2\2\17"+
		"l\3\2\2\2\21q\3\2\2\2\23s\3\2\2\2\25u\3\2\2\2\27w\3\2\2\2\31y\3\2\2\2"+
		"\33{\3\2\2\2\35}\3\2\2\2\37\177\3\2\2\2!\u0081\3\2\2\2#\u0083\3\2\2\2"+
		"%\u0085\3\2\2\2\'\u0087\3\2\2\2)\u0089\3\2\2\2+\u008b\3\2\2\2-\u008d\3"+
		"\2\2\2/\u0092\3\2\2\2\61\u0094\3\2\2\2\63\u0098\3\2\2\2\65\u009d\3\2\2"+
		"\2\67\u00ab\3\2\2\29\u00ad\3\2\2\2;\u00bd\3\2\2\2=\u00bf\3\2\2\2?\u00c3"+
		"\3\2\2\2A\u00c5\3\2\2\2C\u00cd\3\2\2\2E\u00cf\3\2\2\2G\u00d2\3\2\2\2I"+
		"\u00d5\3\2\2\2K\u00d8\3\2\2\2M\u00da\3\2\2\2O\u00dd\3\2\2\2Q\u00df\3\2"+
		"\2\2ST\7%\2\2T\4\3\2\2\2UV\7k\2\2VW\7h\2\2W\6\3\2\2\2XY\7g\2\2YZ\7n\2"+
		"\2Z[\7u\2\2[\\\7g\2\2\\\b\3\2\2\2]^\7y\2\2^_\7j\2\2_`\7k\2\2`a\7n\2\2"+
		"ab\7g\2\2b\n\3\2\2\2cd\7h\2\2de\7q\2\2ef\7t\2\2f\f\3\2\2\2gh\7h\2\2hi"+
		"\7q\2\2ij\7t\2\2jk\7m\2\2k\16\3\2\2\2lm\7l\2\2mn\7q\2\2no\7k\2\2op\7p"+
		"\2\2p\20\3\2\2\2qr\7.\2\2r\22\3\2\2\2st\7=\2\2t\24\3\2\2\2uv\7$\2\2v\26"+
		"\3\2\2\2wx\7)\2\2x\30\3\2\2\2yz\7?\2\2z\32\3\2\2\2{|\7}\2\2|\34\3\2\2"+
		"\2}~\7\177\2\2~\36\3\2\2\2\177\u0080\7*\2\2\u0080 \3\2\2\2\u0081\u0082"+
		"\7+\2\2\u0082\"\3\2\2\2\u0083\u0084\7]\2\2\u0084$\3\2\2\2\u0085\u0086"+
		"\7_\2\2\u0086&\3\2\2\2\u0087\u0088\7`\2\2\u0088(\3\2\2\2\u0089\u008a\7"+
		"/\2\2\u008a*\3\2\2\2\u008b\u008c\7,\2\2\u008c,\3\2\2\2\u008d\u008e\7-"+
		"\2\2\u008e.\3\2\2\2\u008f\u0093\5\61\31\2\u0090\u0093\5\63\32\2\u0091"+
		"\u0093\5\65\33\2\u0092\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3"+
		"\2\2\2\u0093\60\3\2\2\2\u0094\u0095\7k\2\2\u0095\u0096\7p\2\2\u0096\u0097"+
		"\7v\2\2\u0097\62\3\2\2\2\u0098\u0099\7d\2\2\u0099\u009a\7q\2\2\u009a\u009b"+
		"\7q\2\2\u009b\u009c\7n\2\2\u009c\64\3\2\2\2\u009d\u009e\7e\2\2\u009e\u009f"+
		"\7j\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7t\2\2\u00a1\66\3\2\2\2\u00a2\u00a3"+
		"\7v\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7w\2\2\u00a5\u00ac\7g\2\2\u00a6"+
		"\u00a7\7h\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7u\2\2"+
		"\u00aa\u00ac\7g\2\2\u00ab\u00a2\3\2\2\2\u00ab\u00a6\3\2\2\2\u00ac8\3\2"+
		"\2\2\u00ad\u00b2\5? \2\u00ae\u00b1\5? \2\u00af\u00b1\5A!\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3:\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00be\7\62\2\2"+
		"\u00b6\u00ba\t\2\2\2\u00b7\u00b9\5A!\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bd\u00b5\3\2\2\2\u00bd\u00b6\3\2\2\2\u00be<\3\2\2\2"+
		"\u00bf\u00c0\5\27\f\2\u00c0\u00c1\n\3\2\2\u00c1\u00c2\5\27\f\2\u00c2>"+
		"\3\2\2\2\u00c3\u00c4\t\4\2\2\u00c4@\3\2\2\2\u00c5\u00c6\t\5\2\2\u00c6"+
		"B\3\2\2\2\u00c7\u00ce\5E#\2\u00c8\u00ce\5G$\2\u00c9\u00ce\5I%\2\u00ca"+
		"\u00ce\5K&\2\u00cb\u00ce\5M\'\2\u00cc\u00ce\5O(\2\u00cd\u00c7\3\2\2\2"+
		"\u00cd\u00c8\3\2\2\2\u00cd\u00c9\3\2\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ceD\3\2\2\2\u00cf\u00d0\7?\2\2\u00d0\u00d1"+
		"\7?\2\2\u00d1F\3\2\2\2\u00d2\u00d3\7#\2\2\u00d3\u00d4\7?\2\2\u00d4H\3"+
		"\2\2\2\u00d5\u00d6\7@\2\2\u00d6\u00d7\7?\2\2\u00d7J\3\2\2\2\u00d8\u00d9"+
		"\7@\2\2\u00d9L\3\2\2\2\u00da\u00db\7>\2\2\u00db\u00dc\7?\2\2\u00dcN\3"+
		"\2\2\2\u00dd\u00de\7>\2\2\u00deP\3\2\2\2\u00df\u00e0\t\6\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00e2\b)\2\2\u00e2R\3\2\2\2\n\2\u0092\u00ab\u00b0\u00b2"+
		"\u00ba\u00bd\u00cd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
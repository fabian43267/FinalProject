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
		T__0=1, IF=2, ELSE=3, WHILE=4, FOR=5, FORK=6, JOIN=7, GLOBAL=8, COMMA=9, 
		SC=10, QUOTE=11, SQUOTE=12, ASSIGN=13, LBRACE=14, RBRACE=15, LPARENT=16, 
		RPARENT=17, LSQBRAC=18, RSQBRAC=19, EXP=20, NEG=21, MULT=22, ADD=23, TYPE=24, 
		BOOL=25, ID=26, NUM=27, CHAR=28, COMP=29, WS=30;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'"
	};
	public static final String[] ruleNames = {
		"T__0", "IF", "ELSE", "WHILE", "FOR", "FORK", "JOIN", "GLOBAL", "COMMA", 
		"SC", "QUOTE", "SQUOTE", "ASSIGN", "LBRACE", "RBRACE", "LPARENT", "RPARENT", 
		"LSQBRAC", "RSQBRAC", "EXP", "NEG", "MULT", "ADD", "TYPE", "TYPE_INT", 
		"TYPE_BOOL", "TYPE_CHAR", "BOOL", "ID", "NUM", "CHAR", "LETTER", "DIGIT", 
		"COMP", "EQ", "NE", "GE", "GT", "LE", "LT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u00ec\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\31\5\31\u009c\n\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u00b5\n\35\3\36\3\36\3\36\7\36\u00ba\n\36\f\36\16\36\u00bd"+
		"\13\36\3\37\3\37\3\37\7\37\u00c2\n\37\f\37\16\37\u00c5\13\37\5\37\u00c7"+
		"\n\37\3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3#\3#\5#\u00d7\n#\3$\3$\3"+
		"$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3*\3*\2\2+\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\2\67\29\33;\34=\35?\36A\2"+
		"C\2E\37G\2I\2K\2M\2O\2Q\2S \3\2\7\3\2\63;\3\2))\4\2C\\c|\3\2\62;\5\2\13"+
		"\f\17\17\"\"\u00ec\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2E\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5W\3\2\2\2\7Z\3\2\2\2\t_\3\2\2\2"+
		"\13e\3\2\2\2\ri\3\2\2\2\17n\3\2\2\2\21s\3\2\2\2\23z\3\2\2\2\25|\3\2\2"+
		"\2\27~\3\2\2\2\31\u0080\3\2\2\2\33\u0082\3\2\2\2\35\u0084\3\2\2\2\37\u0086"+
		"\3\2\2\2!\u0088\3\2\2\2#\u008a\3\2\2\2%\u008c\3\2\2\2\'\u008e\3\2\2\2"+
		")\u0090\3\2\2\2+\u0092\3\2\2\2-\u0094\3\2\2\2/\u0096\3\2\2\2\61\u009b"+
		"\3\2\2\2\63\u009d\3\2\2\2\65\u00a1\3\2\2\2\67\u00a6\3\2\2\29\u00b4\3\2"+
		"\2\2;\u00b6\3\2\2\2=\u00c6\3\2\2\2?\u00c8\3\2\2\2A\u00cc\3\2\2\2C\u00ce"+
		"\3\2\2\2E\u00d6\3\2\2\2G\u00d8\3\2\2\2I\u00db\3\2\2\2K\u00de\3\2\2\2M"+
		"\u00e1\3\2\2\2O\u00e3\3\2\2\2Q\u00e6\3\2\2\2S\u00e8\3\2\2\2UV\7%\2\2V"+
		"\4\3\2\2\2WX\7k\2\2XY\7h\2\2Y\6\3\2\2\2Z[\7g\2\2[\\\7n\2\2\\]\7u\2\2]"+
		"^\7g\2\2^\b\3\2\2\2_`\7y\2\2`a\7j\2\2ab\7k\2\2bc\7n\2\2cd\7g\2\2d\n\3"+
		"\2\2\2ef\7h\2\2fg\7q\2\2gh\7t\2\2h\f\3\2\2\2ij\7h\2\2jk\7q\2\2kl\7t\2"+
		"\2lm\7m\2\2m\16\3\2\2\2no\7l\2\2op\7q\2\2pq\7k\2\2qr\7p\2\2r\20\3\2\2"+
		"\2st\7i\2\2tu\7n\2\2uv\7q\2\2vw\7d\2\2wx\7c\2\2xy\7n\2\2y\22\3\2\2\2z"+
		"{\7.\2\2{\24\3\2\2\2|}\7=\2\2}\26\3\2\2\2~\177\7$\2\2\177\30\3\2\2\2\u0080"+
		"\u0081\7)\2\2\u0081\32\3\2\2\2\u0082\u0083\7?\2\2\u0083\34\3\2\2\2\u0084"+
		"\u0085\7}\2\2\u0085\36\3\2\2\2\u0086\u0087\7\177\2\2\u0087 \3\2\2\2\u0088"+
		"\u0089\7*\2\2\u0089\"\3\2\2\2\u008a\u008b\7+\2\2\u008b$\3\2\2\2\u008c"+
		"\u008d\7]\2\2\u008d&\3\2\2\2\u008e\u008f\7_\2\2\u008f(\3\2\2\2\u0090\u0091"+
		"\7`\2\2\u0091*\3\2\2\2\u0092\u0093\7/\2\2\u0093,\3\2\2\2\u0094\u0095\7"+
		",\2\2\u0095.\3\2\2\2\u0096\u0097\7-\2\2\u0097\60\3\2\2\2\u0098\u009c\5"+
		"\63\32\2\u0099\u009c\5\65\33\2\u009a\u009c\5\67\34\2\u009b\u0098\3\2\2"+
		"\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\62\3\2\2\2\u009d\u009e"+
		"\7k\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7v\2\2\u00a0\64\3\2\2\2\u00a1\u00a2"+
		"\7d\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7n\2\2\u00a5"+
		"\66\3\2\2\2\u00a6\u00a7\7e\2\2\u00a7\u00a8\7j\2\2\u00a8\u00a9\7c\2\2\u00a9"+
		"\u00aa\7t\2\2\u00aa8\3\2\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7t\2\2\u00ad"+
		"\u00ae\7w\2\2\u00ae\u00b5\7g\2\2\u00af\u00b0\7h\2\2\u00b0\u00b1\7c\2\2"+
		"\u00b1\u00b2\7n\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b5\7g\2\2\u00b4\u00ab"+
		"\3\2\2\2\u00b4\u00af\3\2\2\2\u00b5:\3\2\2\2\u00b6\u00bb\5A!\2\u00b7\u00ba"+
		"\5A!\2\u00b8\u00ba\5C\"\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc<\3\2\2\2"+
		"\u00bd\u00bb\3\2\2\2\u00be\u00c7\7\62\2\2\u00bf\u00c3\t\2\2\2\u00c0\u00c2"+
		"\5C\"\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00be\3\2"+
		"\2\2\u00c6\u00bf\3\2\2\2\u00c7>\3\2\2\2\u00c8\u00c9\5\31\r\2\u00c9\u00ca"+
		"\n\3\2\2\u00ca\u00cb\5\31\r\2\u00cb@\3\2\2\2\u00cc\u00cd\t\4\2\2\u00cd"+
		"B\3\2\2\2\u00ce\u00cf\t\5\2\2\u00cfD\3\2\2\2\u00d0\u00d7\5G$\2\u00d1\u00d7"+
		"\5I%\2\u00d2\u00d7\5K&\2\u00d3\u00d7\5M\'\2\u00d4\u00d7\5O(\2\u00d5\u00d7"+
		"\5Q)\2\u00d6\u00d0\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d6"+
		"\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7F\3\2\2\2"+
		"\u00d8\u00d9\7?\2\2\u00d9\u00da\7?\2\2\u00daH\3\2\2\2\u00db\u00dc\7#\2"+
		"\2\u00dc\u00dd\7?\2\2\u00ddJ\3\2\2\2\u00de\u00df\7@\2\2\u00df\u00e0\7"+
		"?\2\2\u00e0L\3\2\2\2\u00e1\u00e2\7@\2\2\u00e2N\3\2\2\2\u00e3\u00e4\7>"+
		"\2\2\u00e4\u00e5\7?\2\2\u00e5P\3\2\2\2\u00e6\u00e7\7>\2\2\u00e7R\3\2\2"+
		"\2\u00e8\u00e9\t\6\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\b*\2\2\u00ebT\3"+
		"\2\2\2\n\2\u009b\u00b4\u00b9\u00bb\u00c3\u00c6\u00d6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
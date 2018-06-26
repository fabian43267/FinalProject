// Generated from MyGrammar.g4 by ANTLR 4.4
package Grammar;
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
		IF=1, ELSE=2, WHILE=3, FOR=4, COMMA=5, SC=6, QUOTE=7, SQUOTE=8, ASSIGN=9, 
		LBRACE=10, RBRACE=11, LPARENT=12, RPARENT=13, LSQBRAC=14, RSQBRAC=15, 
		EXP=16, NEG=17, MULT=18, ADD=19, TYPE=20, BOOL=21, ID=22, NUM=23, CHAR=24, 
		COMP=25, WS=26;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'"
	};
	public static final String[] ruleNames = {
		"IF", "ELSE", "WHILE", "FOR", "COMMA", "SC", "QUOTE", "SQUOTE", "ASSIGN", 
		"LBRACE", "RBRACE", "LPARENT", "RPARENT", "LSQBRAC", "RSQBRAC", "EXP", 
		"NEG", "MULT", "ADD", "TYPE", "TYPE_INT", "TYPE_BOOL", "TYPE_CHAR", "BOOL", 
		"ID", "NUM", "CHAR", "LETTER", "DIGIT", "COMP", "EQ", "NE", "GE", "GT", 
		"LE", "LT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00d1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\5\25\u0081\n\25"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u009a\n\31\3\32\3\32"+
		"\3\32\7\32\u009f\n\32\f\32\16\32\u00a2\13\32\3\33\3\33\3\33\7\33\u00a7"+
		"\n\33\f\33\16\33\u00aa\13\33\5\33\u00ac\n\33\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00bc\n\37\3 \3 \3"+
		" \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3&\2\2\'\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\2-\2/\2\61\27\63\30\65\31\67\329\2;\2=\33?\2A\2C\2"+
		"E\2G\2I\2K\34\3\2\7\3\2\63;\3\2))\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\""+
		"\u00d1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\2=\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5P\3\2\2"+
		"\2\7U\3\2\2\2\t[\3\2\2\2\13_\3\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21e\3\2\2"+
		"\2\23g\3\2\2\2\25i\3\2\2\2\27k\3\2\2\2\31m\3\2\2\2\33o\3\2\2\2\35q\3\2"+
		"\2\2\37s\3\2\2\2!u\3\2\2\2#w\3\2\2\2%y\3\2\2\2\'{\3\2\2\2)\u0080\3\2\2"+
		"\2+\u0082\3\2\2\2-\u0086\3\2\2\2/\u008b\3\2\2\2\61\u0099\3\2\2\2\63\u009b"+
		"\3\2\2\2\65\u00ab\3\2\2\2\67\u00ad\3\2\2\29\u00b1\3\2\2\2;\u00b3\3\2\2"+
		"\2=\u00bb\3\2\2\2?\u00bd\3\2\2\2A\u00c0\3\2\2\2C\u00c3\3\2\2\2E\u00c6"+
		"\3\2\2\2G\u00c8\3\2\2\2I\u00cb\3\2\2\2K\u00cd\3\2\2\2MN\7k\2\2NO\7h\2"+
		"\2O\4\3\2\2\2PQ\7g\2\2QR\7n\2\2RS\7u\2\2ST\7g\2\2T\6\3\2\2\2UV\7y\2\2"+
		"VW\7j\2\2WX\7k\2\2XY\7n\2\2YZ\7g\2\2Z\b\3\2\2\2[\\\7h\2\2\\]\7q\2\2]^"+
		"\7t\2\2^\n\3\2\2\2_`\7.\2\2`\f\3\2\2\2ab\7=\2\2b\16\3\2\2\2cd\7$\2\2d"+
		"\20\3\2\2\2ef\7)\2\2f\22\3\2\2\2gh\7?\2\2h\24\3\2\2\2ij\7}\2\2j\26\3\2"+
		"\2\2kl\7\177\2\2l\30\3\2\2\2mn\7*\2\2n\32\3\2\2\2op\7+\2\2p\34\3\2\2\2"+
		"qr\7]\2\2r\36\3\2\2\2st\7_\2\2t \3\2\2\2uv\7`\2\2v\"\3\2\2\2wx\7/\2\2"+
		"x$\3\2\2\2yz\7,\2\2z&\3\2\2\2{|\7-\2\2|(\3\2\2\2}\u0081\5+\26\2~\u0081"+
		"\5-\27\2\177\u0081\5/\30\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080\177\3\2"+
		"\2\2\u0081*\3\2\2\2\u0082\u0083\7k\2\2\u0083\u0084\7p\2\2\u0084\u0085"+
		"\7v\2\2\u0085,\3\2\2\2\u0086\u0087\7d\2\2\u0087\u0088\7q\2\2\u0088\u0089"+
		"\7q\2\2\u0089\u008a\7n\2\2\u008a.\3\2\2\2\u008b\u008c\7e\2\2\u008c\u008d"+
		"\7j\2\2\u008d\u008e\7c\2\2\u008e\u008f\7t\2\2\u008f\60\3\2\2\2\u0090\u0091"+
		"\7v\2\2\u0091\u0092\7t\2\2\u0092\u0093\7w\2\2\u0093\u009a\7g\2\2\u0094"+
		"\u0095\7h\2\2\u0095\u0096\7c\2\2\u0096\u0097\7n\2\2\u0097\u0098\7u\2\2"+
		"\u0098\u009a\7g\2\2\u0099\u0090\3\2\2\2\u0099\u0094\3\2\2\2\u009a\62\3"+
		"\2\2\2\u009b\u00a0\59\35\2\u009c\u009f\59\35\2\u009d\u009f\5;\36\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\64\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00ac"+
		"\7\62\2\2\u00a4\u00a8\t\2\2\2\u00a5\u00a7\5;\36\2\u00a6\u00a5\3\2\2\2"+
		"\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00a3\3\2\2\2\u00ab\u00a4\3\2\2\2\u00ac"+
		"\66\3\2\2\2\u00ad\u00ae\5\21\t\2\u00ae\u00af\n\3\2\2\u00af\u00b0\5\21"+
		"\t\2\u00b08\3\2\2\2\u00b1\u00b2\t\4\2\2\u00b2:\3\2\2\2\u00b3\u00b4\t\5"+
		"\2\2\u00b4<\3\2\2\2\u00b5\u00bc\5? \2\u00b6\u00bc\5A!\2\u00b7\u00bc\5"+
		"C\"\2\u00b8\u00bc\5E#\2\u00b9\u00bc\5G$\2\u00ba\u00bc\5I%\2\u00bb\u00b5"+
		"\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc>\3\2\2\2\u00bd\u00be\7?\2\2\u00be"+
		"\u00bf\7?\2\2\u00bf@\3\2\2\2\u00c0\u00c1\7#\2\2\u00c1\u00c2\7?\2\2\u00c2"+
		"B\3\2\2\2\u00c3\u00c4\7@\2\2\u00c4\u00c5\7?\2\2\u00c5D\3\2\2\2\u00c6\u00c7"+
		"\7@\2\2\u00c7F\3\2\2\2\u00c8\u00c9\7>\2\2\u00c9\u00ca\7?\2\2\u00caH\3"+
		"\2\2\2\u00cb\u00cc\7>\2\2\u00ccJ\3\2\2\2\u00cd\u00ce\t\6\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00d0\b&\2\2\u00d0L\3\2\2\2\n\2\u0080\u0099\u009e\u00a0"+
		"\u00a8\u00ab\u00bb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
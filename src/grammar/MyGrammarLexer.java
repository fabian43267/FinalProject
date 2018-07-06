// Generated from /Users/ducu97/IntelliJProjects/FinalProject/src/grammar/MyGrammar.g4 by ANTLR 4.7
package grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, IF=2, ELSE=3, WHILE=4, FOR=5, FORK=6, JOIN=7, GLOBAL=8, PRINT=9, 
		COMMA=10, SC=11, QUOTE=12, SQUOTE=13, ASSIGN=14, LBRACE=15, RBRACE=16, 
		LPARENT=17, RPARENT=18, LSQBRAC=19, RSQBRAC=20, EXP=21, NEG=22, MULT=23, 
		ADD=24, DIV=25, AND=26, OR=27, TYPE=28, BOOL=29, ID=30, NUM=31, CHAR=32, 
		COMP=33, WS=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "IF", "ELSE", "WHILE", "FOR", "FORK", "JOIN", "GLOBAL", "PRINT", 
		"COMMA", "SC", "QUOTE", "SQUOTE", "ASSIGN", "LBRACE", "RBRACE", "LPARENT", 
		"RPARENT", "LSQBRAC", "RSQBRAC", "EXP", "NEG", "MULT", "ADD", "DIV", "AND", 
		"OR", "TYPE", "TYPE_INT", "TYPE_BOOL", "TYPE_CHAR", "BOOL", "ID", "NUM", 
		"CHAR", "LETTER", "DIGIT", "COMP", "EQ", "NE", "GE", "GT", "LE", "LT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'#'", "'if'", "'else'", "'while'", "'for'", "'fork'", "'join'", 
		"'global'", "'print'", "','", "';'", "'\"'", "'''", "'='", "'{'", "'}'", 
		"'('", "')'", "'['", "']'", "'^'", "'-'", "'*'", "'+'", "'/'", "'&&'", 
		"'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "IF", "ELSE", "WHILE", "FOR", "FORK", "JOIN", "GLOBAL", "PRINT", 
		"COMMA", "SC", "QUOTE", "SQUOTE", "ASSIGN", "LBRACE", "RBRACE", "LPARENT", 
		"RPARENT", "LSQBRAC", "RSQBRAC", "EXP", "NEG", "MULT", "ADD", "DIV", "AND", 
		"OR", "TYPE", "BOOL", "ID", "NUM", "CHAR", "COMP", "WS"
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


	public MyGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u0102\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\5\35\u00b2\n\35\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\5!\u00cb\n!\3\"\3\"\3\"\7\"\u00d0\n\"\f\"\16\"\u00d3\13\"\3#\3#\3"+
		"#\7#\u00d8\n#\f#\16#\u00db\13#\5#\u00dd\n#\3$\3$\3$\3$\3%\3%\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\5\'\u00ed\n\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3"+
		",\3,\3,\3-\3-\3.\3.\3.\3.\2\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\2=\2?\2A\37C E!G\"I\2K\2M#O\2Q\2S\2U\2W\2Y"+
		"\2[$\3\2\7\3\2\63;\3\2))\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u0102\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2M\3\2\2\2\2[\3\2\2\2\3]\3\2\2\2"+
		"\5_\3\2\2\2\7b\3\2\2\2\tg\3\2\2\2\13m\3\2\2\2\rq\3\2\2\2\17v\3\2\2\2\21"+
		"{\3\2\2\2\23\u0082\3\2\2\2\25\u0088\3\2\2\2\27\u008a\3\2\2\2\31\u008c"+
		"\3\2\2\2\33\u008e\3\2\2\2\35\u0090\3\2\2\2\37\u0092\3\2\2\2!\u0094\3\2"+
		"\2\2#\u0096\3\2\2\2%\u0098\3\2\2\2\'\u009a\3\2\2\2)\u009c\3\2\2\2+\u009e"+
		"\3\2\2\2-\u00a0\3\2\2\2/\u00a2\3\2\2\2\61\u00a4\3\2\2\2\63\u00a6\3\2\2"+
		"\2\65\u00a8\3\2\2\2\67\u00ab\3\2\2\29\u00b1\3\2\2\2;\u00b3\3\2\2\2=\u00b7"+
		"\3\2\2\2?\u00bc\3\2\2\2A\u00ca\3\2\2\2C\u00cc\3\2\2\2E\u00dc\3\2\2\2G"+
		"\u00de\3\2\2\2I\u00e2\3\2\2\2K\u00e4\3\2\2\2M\u00ec\3\2\2\2O\u00ee\3\2"+
		"\2\2Q\u00f1\3\2\2\2S\u00f4\3\2\2\2U\u00f7\3\2\2\2W\u00f9\3\2\2\2Y\u00fc"+
		"\3\2\2\2[\u00fe\3\2\2\2]^\7%\2\2^\4\3\2\2\2_`\7k\2\2`a\7h\2\2a\6\3\2\2"+
		"\2bc\7g\2\2cd\7n\2\2de\7u\2\2ef\7g\2\2f\b\3\2\2\2gh\7y\2\2hi\7j\2\2ij"+
		"\7k\2\2jk\7n\2\2kl\7g\2\2l\n\3\2\2\2mn\7h\2\2no\7q\2\2op\7t\2\2p\f\3\2"+
		"\2\2qr\7h\2\2rs\7q\2\2st\7t\2\2tu\7m\2\2u\16\3\2\2\2vw\7l\2\2wx\7q\2\2"+
		"xy\7k\2\2yz\7p\2\2z\20\3\2\2\2{|\7i\2\2|}\7n\2\2}~\7q\2\2~\177\7d\2\2"+
		"\177\u0080\7c\2\2\u0080\u0081\7n\2\2\u0081\22\3\2\2\2\u0082\u0083\7r\2"+
		"\2\u0083\u0084\7t\2\2\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087"+
		"\7v\2\2\u0087\24\3\2\2\2\u0088\u0089\7.\2\2\u0089\26\3\2\2\2\u008a\u008b"+
		"\7=\2\2\u008b\30\3\2\2\2\u008c\u008d\7$\2\2\u008d\32\3\2\2\2\u008e\u008f"+
		"\7)\2\2\u008f\34\3\2\2\2\u0090\u0091\7?\2\2\u0091\36\3\2\2\2\u0092\u0093"+
		"\7}\2\2\u0093 \3\2\2\2\u0094\u0095\7\177\2\2\u0095\"\3\2\2\2\u0096\u0097"+
		"\7*\2\2\u0097$\3\2\2\2\u0098\u0099\7+\2\2\u0099&\3\2\2\2\u009a\u009b\7"+
		"]\2\2\u009b(\3\2\2\2\u009c\u009d\7_\2\2\u009d*\3\2\2\2\u009e\u009f\7`"+
		"\2\2\u009f,\3\2\2\2\u00a0\u00a1\7/\2\2\u00a1.\3\2\2\2\u00a2\u00a3\7,\2"+
		"\2\u00a3\60\3\2\2\2\u00a4\u00a5\7-\2\2\u00a5\62\3\2\2\2\u00a6\u00a7\7"+
		"\61\2\2\u00a7\64\3\2\2\2\u00a8\u00a9\7(\2\2\u00a9\u00aa\7(\2\2\u00aa\66"+
		"\3\2\2\2\u00ab\u00ac\7~\2\2\u00ac\u00ad\7~\2\2\u00ad8\3\2\2\2\u00ae\u00b2"+
		"\5;\36\2\u00af\u00b2\5=\37\2\u00b0\u00b2\5? \2\u00b1\u00ae\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2:\3\2\2\2\u00b3\u00b4\7k\2\2\u00b4"+
		"\u00b5\7p\2\2\u00b5\u00b6\7v\2\2\u00b6<\3\2\2\2\u00b7\u00b8\7d\2\2\u00b8"+
		"\u00b9\7q\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7n\2\2\u00bb>\3\2\2\2\u00bc"+
		"\u00bd\7e\2\2\u00bd\u00be\7j\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7t\2\2"+
		"\u00c0@\3\2\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7w\2"+
		"\2\u00c4\u00cb\7g\2\2\u00c5\u00c6\7h\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8"+
		"\7n\2\2\u00c8\u00c9\7u\2\2\u00c9\u00cb\7g\2\2\u00ca\u00c1\3\2\2\2\u00ca"+
		"\u00c5\3\2\2\2\u00cbB\3\2\2\2\u00cc\u00d1\5I%\2\u00cd\u00d0\5I%\2\u00ce"+
		"\u00d0\5K&\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2"+
		"\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2D\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d4\u00dd\7\62\2\2\u00d5\u00d9\t\2\2\2\u00d6\u00d8\5K&\2\u00d7"+
		"\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2"+
		"\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00d4\3\2\2\2\u00dc"+
		"\u00d5\3\2\2\2\u00ddF\3\2\2\2\u00de\u00df\5\33\16\2\u00df\u00e0\n\3\2"+
		"\2\u00e0\u00e1\5\33\16\2\u00e1H\3\2\2\2\u00e2\u00e3\t\4\2\2\u00e3J\3\2"+
		"\2\2\u00e4\u00e5\t\5\2\2\u00e5L\3\2\2\2\u00e6\u00ed\5O(\2\u00e7\u00ed"+
		"\5Q)\2\u00e8\u00ed\5S*\2\u00e9\u00ed\5U+\2\u00ea\u00ed\5W,\2\u00eb\u00ed"+
		"\5Y-\2\u00ec\u00e6\3\2\2\2\u00ec\u00e7\3\2\2\2\u00ec\u00e8\3\2\2\2\u00ec"+
		"\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00edN\3\2\2\2"+
		"\u00ee\u00ef\7?\2\2\u00ef\u00f0\7?\2\2\u00f0P\3\2\2\2\u00f1\u00f2\7#\2"+
		"\2\u00f2\u00f3\7?\2\2\u00f3R\3\2\2\2\u00f4\u00f5\7@\2\2\u00f5\u00f6\7"+
		"?\2\2\u00f6T\3\2\2\2\u00f7\u00f8\7@\2\2\u00f8V\3\2\2\2\u00f9\u00fa\7>"+
		"\2\2\u00fa\u00fb\7?\2\2\u00fbX\3\2\2\2\u00fc\u00fd\7>\2\2\u00fdZ\3\2\2"+
		"\2\u00fe\u00ff\t\6\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\b.\2\2\u0101\\"+
		"\3\2\2\2\n\2\u00b1\u00ca\u00cf\u00d1\u00d9\u00dc\u00ec\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from MyGrammar.g4 by ANTLR 4.4
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, WHILE=3, FOR=4, COMMA=5, SC=6, QUOTE=7, SQUOTE=8, ASSIGN=9, 
		LBRACE=10, RBRACE=11, LPARENT=12, RPARENT=13, LSQBRAC=14, RSQBRAC=15, 
		EXP=16, NEG=17, MULT=18, ADD=19, TYPE=20, BOOL=21, ID=22, NUM=23, CHAR=24, 
		COMP=25, WS=26;
	public static final String[] tokenNames = {
		"<INVALID>", "'if'", "'else'", "'while'", "'for'", "','", "';'", "'\"'", 
		"'''", "'='", "'{'", "'}'", "'('", "')'", "'['", "']'", "'^'", "'-'", 
		"'*'", "'+'", "TYPE", "BOOL", "ID", "NUM", "CHAR", "COMP", "WS"
	};
	public static final int
		RULE_program = 0, RULE_assignment = 1, RULE_statement = 2, RULE_comp = 3, 
		RULE_expr = 4, RULE_term = 5, RULE_expo = 6, RULE_factor = 7;
	public static final String[] ruleNames = {
		"program", "assignment", "statement", "comp", "expr", "term", "expo", 
		"factor"
	};

	@Override
	public String getGrammarFileName() { return "MyGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16); statement();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << LPARENT) | (1L << NEG) | (1L << TYPE) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0) );
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

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclAssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MyGrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MyGrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(MyGrammarParser.TYPE, 0); }
		public DeclAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterDeclAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitDeclAssign(this);
		}
	}
	public static class ArrayDeclAssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MyGrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MyGrammarParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode RSQBRAC() { return getToken(MyGrammarParser.RSQBRAC, 0); }
		public TerminalNode TYPE() { return getToken(MyGrammarParser.TYPE, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MyGrammarParser.COMMA); }
		public TerminalNode LSQBRAC() { return getToken(MyGrammarParser.LSQBRAC, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(MyGrammarParser.COMMA, i);
		}
		public ArrayDeclAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterArrayDeclAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitArrayDeclAssign(this);
		}
	}
	public static class ArrayAssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MyGrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MyGrammarParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode RSQBRAC() { return getToken(MyGrammarParser.RSQBRAC, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LSQBRAC() { return getToken(MyGrammarParser.LSQBRAC, 0); }
		public ArrayAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitArrayAssign(this);
		}
	}
	public static class VarAssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MyGrammarParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MyGrammarParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterVarAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitVarAssign(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_assignment);
		int _la;
		try {
			setState(49);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new DeclAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21); match(TYPE);
				setState(22); match(ID);
				setState(23); match(ASSIGN);
				setState(24); expr(0);
				}
				break;
			case 2:
				_localctx = new VarAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25); match(ID);
				setState(26); match(ASSIGN);
				setState(27); expr(0);
				}
				break;
			case 3:
				_localctx = new ArrayDeclAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(28); match(TYPE);
				setState(29); match(ID);
				setState(30); match(ASSIGN);
				setState(31); match(LSQBRAC);
				setState(32); expr(0);
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(33); match(COMMA);
					setState(34); expr(0);
					}
					}
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(40); match(RSQBRAC);
				}
				break;
			case 4:
				_localctx = new ArrayAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(42); match(ID);
				setState(43); match(LSQBRAC);
				setState(44); expr(0);
				setState(45); match(RSQBRAC);
				setState(46); match(ASSIGN);
				setState(47); expr(0);
				}
				break;
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
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatementContext {
		public TerminalNode RBRACE(int i) {
			return getToken(MyGrammarParser.RBRACE, i);
		}
		public TerminalNode ELSE() { return getToken(MyGrammarParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(MyGrammarParser.IF, 0); }
		public TerminalNode LPARENT() { return getToken(MyGrammarParser.LPARENT, 0); }
		public List<TerminalNode> RBRACE() { return getTokens(MyGrammarParser.RBRACE); }
		public List<TerminalNode> LBRACE() { return getTokens(MyGrammarParser.LBRACE); }
		public TerminalNode RPARENT() { return getToken(MyGrammarParser.RPARENT, 0); }
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public TerminalNode LBRACE(int i) {
			return getToken(MyGrammarParser.LBRACE, i);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public IfStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitIfStat(this);
		}
	}
	public static class ExprStatContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitExprStat(this);
		}
	}
	public static class ForStatContext extends StatementContext {
		public TerminalNode LPARENT() { return getToken(MyGrammarParser.LPARENT, 0); }
		public TerminalNode RBRACE() { return getToken(MyGrammarParser.RBRACE, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(MyGrammarParser.LBRACE, 0); }
		public TerminalNode FOR() { return getToken(MyGrammarParser.FOR, 0); }
		public TerminalNode SC(int i) {
			return getToken(MyGrammarParser.SC, i);
		}
		public TerminalNode RPARENT() { return getToken(MyGrammarParser.RPARENT, 0); }
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public List<TerminalNode> SC() { return getTokens(MyGrammarParser.SC); }
		public ForStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitForStat(this);
		}
	}
	public static class WhileStatContext extends StatementContext {
		public TerminalNode LPARENT() { return getToken(MyGrammarParser.LPARENT, 0); }
		public TerminalNode RBRACE() { return getToken(MyGrammarParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(MyGrammarParser.LBRACE, 0); }
		public TerminalNode RPARENT() { return getToken(MyGrammarParser.RPARENT, 0); }
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode WHILE() { return getToken(MyGrammarParser.WHILE, 0); }
		public WhileStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitWhileStat(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(102);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51); match(IF);
				setState(52); match(LPARENT);
				setState(53); comp();
				setState(54); match(RPARENT);
				setState(55); match(LBRACE);
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(56); statement();
					}
					}
					setState(59); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << LPARENT) | (1L << NEG) | (1L << TYPE) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0) );
				setState(69);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(61); match(RBRACE);
					setState(62); match(ELSE);
					setState(63); match(LBRACE);
					setState(65); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(64); statement();
						}
						}
						setState(67); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << LPARENT) | (1L << NEG) | (1L << TYPE) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0) );
					}
					break;
				}
				setState(71); match(RBRACE);
				}
				break;
			case WHILE:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73); match(WHILE);
				setState(74); match(LPARENT);
				setState(75); comp();
				setState(76); match(RPARENT);
				setState(77); match(LBRACE);
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(78); statement();
					}
					}
					setState(81); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << LPARENT) | (1L << NEG) | (1L << TYPE) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0) );
				setState(83); match(RBRACE);
				}
				break;
			case FOR:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85); match(FOR);
				setState(86); match(LPARENT);
				setState(87); assignment();
				setState(88); match(SC);
				setState(89); comp();
				setState(90); match(SC);
				setState(91); expr(0);
				setState(92); match(RPARENT);
				setState(93); match(LBRACE);
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(94); statement();
					}
					}
					setState(97); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << LPARENT) | (1L << NEG) | (1L << TYPE) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0) );
				setState(99); match(RBRACE);
				}
				break;
			case LPARENT:
			case NEG:
			case TYPE:
			case BOOL:
			case ID:
			case NUM:
			case CHAR:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(101); expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CompContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMP() { return getToken(MyGrammarParser.COMP, 0); }
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitComp(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); expr(0);
			setState(105); match(COMP);
			setState(106); expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode ADD() { return getToken(MyGrammarParser.ADD, 0); }
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitAddExpr(this);
		}
	}
	public static class TermExprContext extends ExprContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterTermExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitTermExpr(this);
		}
	}
	public static class NegExprContext extends ExprContext {
		public TerminalNode NEG() { return getToken(MyGrammarParser.NEG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public NegExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterNegExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitNegExpr(this);
		}
	}
	public static class AssignExprContext extends ExprContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitAssignExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new TermExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(109); term();
				}
				break;
			case 2:
				{
				_localctx = new AssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110); assignment();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(119);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(114); match(ADD);
						setState(115); term();
						}
						break;
					case 2:
						{
						_localctx = new NegExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(117); match(NEG);
						setState(118); term();
						}
						break;
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultTermContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MULT() { return getToken(MyGrammarParser.MULT, 0); }
		public ExpoContext expo() {
			return getRuleContext(ExpoContext.class,0);
		}
		public MultTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterMultTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitMultTerm(this);
		}
	}
	public static class NegTermContext extends TermContext {
		public TerminalNode NEG() { return getToken(MyGrammarParser.NEG, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public NegTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterNegTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitNegTerm(this);
		}
	}
	public static class ExpoTermContext extends TermContext {
		public ExpoContext expo() {
			return getRuleContext(ExpoContext.class,0);
		}
		public ExpoTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterExpoTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitExpoTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_term);
		try {
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new MultTermContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124); expo();
				setState(125); match(MULT);
				setState(126); term();
				}
				break;
			case 2:
				_localctx = new NegTermContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128); match(NEG);
				setState(129); term();
				}
				break;
			case 3:
				_localctx = new ExpoTermContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(130); expo();
				}
				break;
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

	public static class ExpoContext extends ParserRuleContext {
		public ExpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expo; }
	 
		public ExpoContext() { }
		public void copyFrom(ExpoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FactorExpoContext extends ExpoContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public FactorExpoContext(ExpoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterFactorExpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitFactorExpo(this);
		}
	}
	public static class ExpExpoContext extends ExpoContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode EXP() { return getToken(MyGrammarParser.EXP, 0); }
		public ExpoContext expo() {
			return getRuleContext(ExpoContext.class,0);
		}
		public ExpExpoContext(ExpoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterExpExpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitExpExpo(this);
		}
	}

	public final ExpoContext expo() throws RecognitionException {
		ExpoContext _localctx = new ExpoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expo);
		try {
			setState(138);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new ExpExpoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(133); factor();
				setState(134); match(EXP);
				setState(135); expo();
				}
				break;
			case 2:
				_localctx = new FactorExpoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137); factor();
				}
				break;
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
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CharFactorContext extends FactorContext {
		public TerminalNode CHAR() { return getToken(MyGrammarParser.CHAR, 0); }
		public CharFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterCharFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitCharFactor(this);
		}
	}
	public static class ParFactorContext extends FactorContext {
		public TerminalNode LPARENT() { return getToken(MyGrammarParser.LPARENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPARENT() { return getToken(MyGrammarParser.RPARENT, 0); }
		public ParFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterParFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitParFactor(this);
		}
	}
	public static class NumFactorContext extends FactorContext {
		public TerminalNode NUM() { return getToken(MyGrammarParser.NUM, 0); }
		public NumFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterNumFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitNumFactor(this);
		}
	}
	public static class VarFactorContext extends FactorContext {
		public TerminalNode ID() { return getToken(MyGrammarParser.ID, 0); }
		public VarFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterVarFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitVarFactor(this);
		}
	}
	public static class ArrayFactorContext extends FactorContext {
		public TerminalNode ID() { return getToken(MyGrammarParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSQBRAC() { return getToken(MyGrammarParser.RSQBRAC, 0); }
		public TerminalNode LSQBRAC() { return getToken(MyGrammarParser.LSQBRAC, 0); }
		public ArrayFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterArrayFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitArrayFactor(this);
		}
	}
	public static class BoolFactorContext extends FactorContext {
		public TerminalNode BOOL() { return getToken(MyGrammarParser.BOOL, 0); }
		public BoolFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterBoolFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitBoolFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_factor);
		try {
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new NumFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(140); match(NUM);
				}
				break;
			case 2:
				_localctx = new BoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(141); match(BOOL);
				}
				break;
			case 3:
				_localctx = new VarFactorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(142); match(ID);
				}
				break;
			case 4:
				_localctx = new ArrayFactorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143); match(ID);
				setState(144); match(LSQBRAC);
				setState(145); expr(0);
				setState(146); match(RSQBRAC);
				}
				break;
			case 5:
				_localctx = new CharFactorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(148); match(CHAR);
				}
				break;
			case 6:
				_localctx = new ParFactorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(149); match(LPARENT);
				setState(150); expr(0);
				setState(151); match(RPARENT);
				}
				break;
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 4);
		case 1: return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u009e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\24\n"+
		"\2\r\2\16\2\25\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3&\n\3\f\3\16\3)\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\64\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\6\4<\n\4\r\4\16\4=\3\4\3\4\3\4\3\4\6\4D\n\4"+
		"\r\4\16\4E\5\4H\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4R\n\4\r\4\16\4"+
		"S\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4b\n\4\r\4\16\4c\3"+
		"\4\3\4\3\4\5\4i\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6r\n\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6z\n\6\f\6\16\6}\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0086"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\5\b\u008d\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\t\u009c\n\t\3\t\2\3\n\n\2\4\6\b\n\f\16\20\2\2\u00ad"+
		"\2\23\3\2\2\2\4\63\3\2\2\2\6h\3\2\2\2\bj\3\2\2\2\nq\3\2\2\2\f\u0085\3"+
		"\2\2\2\16\u008c\3\2\2\2\20\u009b\3\2\2\2\22\24\5\6\4\2\23\22\3\2\2\2\24"+
		"\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2\27\30\7\26\2\2\30"+
		"\31\7\30\2\2\31\32\7\13\2\2\32\64\5\n\6\2\33\34\7\30\2\2\34\35\7\13\2"+
		"\2\35\64\5\n\6\2\36\37\7\26\2\2\37 \7\30\2\2 !\7\13\2\2!\"\7\20\2\2\""+
		"\'\5\n\6\2#$\7\7\2\2$&\5\n\6\2%#\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2"+
		"\2(*\3\2\2\2)\'\3\2\2\2*+\7\21\2\2+\64\3\2\2\2,-\7\30\2\2-.\7\20\2\2."+
		"/\5\n\6\2/\60\7\21\2\2\60\61\7\13\2\2\61\62\5\n\6\2\62\64\3\2\2\2\63\27"+
		"\3\2\2\2\63\33\3\2\2\2\63\36\3\2\2\2\63,\3\2\2\2\64\5\3\2\2\2\65\66\7"+
		"\3\2\2\66\67\7\16\2\2\678\5\b\5\289\7\17\2\29;\7\f\2\2:<\5\6\4\2;:\3\2"+
		"\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>G\3\2\2\2?@\7\r\2\2@A\7\4\2\2AC\7\f"+
		"\2\2BD\5\6\4\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2G?\3\2"+
		"\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\r\2\2Ji\3\2\2\2KL\7\5\2\2LM\7\16\2\2MN\5"+
		"\b\5\2NO\7\17\2\2OQ\7\f\2\2PR\5\6\4\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST"+
		"\3\2\2\2TU\3\2\2\2UV\7\r\2\2Vi\3\2\2\2WX\7\6\2\2XY\7\16\2\2YZ\5\4\3\2"+
		"Z[\7\b\2\2[\\\5\b\5\2\\]\7\b\2\2]^\5\n\6\2^_\7\17\2\2_a\7\f\2\2`b\5\6"+
		"\4\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\r\2\2fi\3\2"+
		"\2\2gi\5\n\6\2h\65\3\2\2\2hK\3\2\2\2hW\3\2\2\2hg\3\2\2\2i\7\3\2\2\2jk"+
		"\5\n\6\2kl\7\33\2\2lm\5\n\6\2m\t\3\2\2\2no\b\6\1\2or\5\f\7\2pr\5\4\3\2"+
		"qn\3\2\2\2qp\3\2\2\2r{\3\2\2\2st\f\6\2\2tu\7\25\2\2uz\5\f\7\2vw\f\5\2"+
		"\2wx\7\23\2\2xz\5\f\7\2ys\3\2\2\2yv\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2"+
		"\2\2|\13\3\2\2\2}{\3\2\2\2~\177\5\16\b\2\177\u0080\7\24\2\2\u0080\u0081"+
		"\5\f\7\2\u0081\u0086\3\2\2\2\u0082\u0083\7\23\2\2\u0083\u0086\5\f\7\2"+
		"\u0084\u0086\5\16\b\2\u0085~\3\2\2\2\u0085\u0082\3\2\2\2\u0085\u0084\3"+
		"\2\2\2\u0086\r\3\2\2\2\u0087\u0088\5\20\t\2\u0088\u0089\7\22\2\2\u0089"+
		"\u008a\5\16\b\2\u008a\u008d\3\2\2\2\u008b\u008d\5\20\t\2\u008c\u0087\3"+
		"\2\2\2\u008c\u008b\3\2\2\2\u008d\17\3\2\2\2\u008e\u009c\7\31\2\2\u008f"+
		"\u009c\7\27\2\2\u0090\u009c\7\30\2\2\u0091\u0092\7\30\2\2\u0092\u0093"+
		"\7\20\2\2\u0093\u0094\5\n\6\2\u0094\u0095\7\21\2\2\u0095\u009c\3\2\2\2"+
		"\u0096\u009c\7\32\2\2\u0097\u0098\7\16\2\2\u0098\u0099\5\n\6\2\u0099\u009a"+
		"\7\17\2\2\u009a\u009c\3\2\2\2\u009b\u008e\3\2\2\2\u009b\u008f\3\2\2\2"+
		"\u009b\u0090\3\2\2\2\u009b\u0091\3\2\2\2\u009b\u0096\3\2\2\2\u009b\u0097"+
		"\3\2\2\2\u009c\21\3\2\2\2\21\25\'\63=EGSchqy{\u0085\u008c\u009b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
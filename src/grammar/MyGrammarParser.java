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
		T__0=1, IF=2, ELSE=3, WHILE=4, FOR=5, FORK=6, JOIN=7, GLOBAL=8, COMMA=9, 
		SC=10, QUOTE=11, SQUOTE=12, ASSIGN=13, LBRACE=14, RBRACE=15, LPARENT=16, 
		RPARENT=17, LSQBRAC=18, RSQBRAC=19, EXP=20, NEG=21, MULT=22, ADD=23, TYPE=24, 
		BOOL=25, ID=26, NUM=27, CHAR=28, COMP=29, WS=30;
	public static final String[] tokenNames = {
		"<INVALID>", "'#'", "'if'", "'else'", "'while'", "'for'", "'fork'", "'join'", 
		"'global'", "','", "';'", "'\"'", "'''", "'='", "'{'", "'}'", "'('", "')'", 
		"'['", "']'", "'^'", "'-'", "'*'", "'+'", "TYPE", "BOOL", "ID", "NUM", 
		"CHAR", "COMP", "WS"
	};
	public static final int
		RULE_program = 0, RULE_assignment = 1, RULE_statement = 2, RULE_block = 3, 
		RULE_comment = 4, RULE_comp = 5, RULE_expr = 6, RULE_term = 7, RULE_expo = 8, 
		RULE_factor = 9;
	public static final String[] ruleNames = {
		"program", "assignment", "statement", "block", "comment", "comp", "expr", 
		"term", "expo", "factor"
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
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20); statement();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FORK) | (1L << JOIN) | (1L << GLOBAL) | (1L << LPARENT) | (1L << NEG) | (1L << TYPE) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0) );
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
		public TerminalNode GLOBAL() { return getToken(MyGrammarParser.GLOBAL, 0); }
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
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new DeclAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				_la = _input.LA(1);
				if (_la==GLOBAL) {
					{
					setState(25); match(GLOBAL);
					}
				}

				setState(28); match(TYPE);
				setState(29); match(ID);
				setState(30); match(ASSIGN);
				setState(31); expr(0);
				}
				break;
			case 2:
				_localctx = new VarAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(32); match(ID);
				setState(33); match(ASSIGN);
				setState(34); expr(0);
				}
				break;
			case 3:
				_localctx = new ArrayDeclAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(35); match(TYPE);
				setState(36); match(ID);
				setState(37); match(ASSIGN);
				setState(38); match(LSQBRAC);
				setState(39); expr(0);
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(40); match(COMMA);
					setState(41); expr(0);
					}
					}
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(47); match(RSQBRAC);
				}
				break;
			case 4:
				_localctx = new ArrayAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(49); match(ID);
				setState(50); match(LSQBRAC);
				setState(51); expr(0);
				setState(52); match(RSQBRAC);
				setState(53); match(ASSIGN);
				setState(54); expr(0);
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
		public TerminalNode ELSE() { return getToken(MyGrammarParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(MyGrammarParser.IF, 0); }
		public TerminalNode LPARENT() { return getToken(MyGrammarParser.LPARENT, 0); }
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode RPARENT() { return getToken(MyGrammarParser.RPARENT, 0); }
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
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
	public static class CommentStatContext extends StatementContext {
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public CommentStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterCommentStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitCommentStat(this);
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
	public static class ForkStatContext extends StatementContext {
		public TerminalNode FORK() { return getToken(MyGrammarParser.FORK, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForkStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterForkStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitForkStat(this);
		}
	}
	public static class JoinStatContext extends StatementContext {
		public TerminalNode JOIN() { return getToken(MyGrammarParser.JOIN, 0); }
		public JoinStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterJoinStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitJoinStat(this);
		}
	}
	public static class ForStatContext extends StatementContext {
		public TerminalNode LPARENT() { return getToken(MyGrammarParser.LPARENT, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FOR() { return getToken(MyGrammarParser.FOR, 0); }
		public TerminalNode SC(int i) {
			return getToken(MyGrammarParser.SC, i);
		}
		public TerminalNode RPARENT() { return getToken(MyGrammarParser.RPARENT, 0); }
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		public TerminalNode RPARENT() { return getToken(MyGrammarParser.RPARENT, 0); }
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(MyGrammarParser.WHILE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
			setState(88);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58); match(IF);
				setState(59); match(LPARENT);
				setState(60); comp();
				setState(61); match(RPARENT);
				setState(62); block();
				setState(65);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(63); match(ELSE);
					setState(64); block();
					}
				}

				}
				break;
			case WHILE:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67); match(WHILE);
				setState(68); match(LPARENT);
				setState(69); comp();
				setState(70); match(RPARENT);
				setState(71); block();
				}
				break;
			case FOR:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(73); match(FOR);
				setState(74); match(LPARENT);
				setState(75); assignment();
				setState(76); match(SC);
				setState(77); comp();
				setState(78); match(SC);
				setState(79); expr(0);
				setState(80); match(RPARENT);
				setState(81); block();
				}
				break;
			case FORK:
				_localctx = new ForkStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(83); match(FORK);
				setState(84); block();
				}
				break;
			case JOIN:
				_localctx = new JoinStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(85); match(JOIN);
				}
				break;
			case GLOBAL:
			case LPARENT:
			case NEG:
			case TYPE:
			case BOOL:
			case ID:
			case NUM:
			case CHAR:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(86); expr(0);
				}
				break;
			case T__0:
				_localctx = new CommentStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(87); comment();
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode RBRACE() { return getToken(MyGrammarParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(MyGrammarParser.LBRACE, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(LBRACE);
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(91); statement();
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << FORK) | (1L << JOIN) | (1L << GLOBAL) | (1L << LPARENT) | (1L << NEG) | (1L << TYPE) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << CHAR))) != 0) );
			setState(96); match(RBRACE);
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

	public static class CommentContext extends ParserRuleContext {
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitComment(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(T__0);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << ELSE) | (1L << WHILE) | (1L << FOR) | (1L << FORK) | (1L << JOIN) | (1L << GLOBAL) | (1L << COMMA) | (1L << SC) | (1L << QUOTE) | (1L << SQUOTE) | (1L << ASSIGN) | (1L << LBRACE) | (1L << RBRACE) | (1L << LPARENT) | (1L << RPARENT) | (1L << LSQBRAC) | (1L << RSQBRAC) | (1L << EXP) | (1L << NEG) | (1L << MULT) | (1L << ADD) | (1L << TYPE) | (1L << BOOL) | (1L << ID) | (1L << NUM) | (1L << CHAR) | (1L << COMP) | (1L << WS))) != 0)) {
				{
				{
				setState(99);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==T__0) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105); match(T__0);
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
		enterRule(_localctx, 10, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); expr(0);
			setState(108); match(COMP);
			setState(109); expr(0);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new TermExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(112); term();
				}
				break;
			case 2:
				{
				_localctx = new AssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113); assignment();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(122);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(116);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(117); match(ADD);
						setState(118); term();
						}
						break;
					case 2:
						{
						_localctx = new NegExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(119);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(120); match(NEG);
						setState(121); term();
						}
						break;
					}
					} 
				}
				setState(126);
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
		enterRule(_localctx, 14, RULE_term);
		try {
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new MultTermContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127); expo();
				setState(128); match(MULT);
				setState(129); term();
				}
				break;
			case 2:
				_localctx = new NegTermContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131); match(NEG);
				setState(132); term();
				}
				break;
			case 3:
				_localctx = new ExpoTermContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(133); expo();
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
		enterRule(_localctx, 16, RULE_expo);
		try {
			setState(141);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new ExpExpoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136); factor();
				setState(137); match(EXP);
				setState(138); expo();
				}
				break;
			case 2:
				_localctx = new FactorExpoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(140); factor();
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
		enterRule(_localctx, 18, RULE_factor);
		try {
			setState(156);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new NumFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(143); match(NUM);
				}
				break;
			case 2:
				_localctx = new BoolFactorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144); match(BOOL);
				}
				break;
			case 3:
				_localctx = new VarFactorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(145); match(ID);
				}
				break;
			case 4:
				_localctx = new ArrayFactorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(146); match(ID);
				setState(147); match(LSQBRAC);
				setState(148); expr(0);
				setState(149); match(RSQBRAC);
				}
				break;
			case 5:
				_localctx = new CharFactorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(151); match(CHAR);
				}
				break;
			case 6:
				_localctx = new ParFactorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(152); match(LPARENT);
				setState(153); expr(0);
				setState(154); match(RPARENT);
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
		case 6: return expr_sempred((ExprContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 \u00a1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\6\2\30\n\2\r\2\16\2\31\3\3\5\3\35\n\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4D\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4[\n\4\3\5\3\5\6\5_\n\5\r\5\16\5`\3\5\3\5\3\6\3\6\7\6"+
		"g\n\6\f\6\16\6j\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bu\n\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\7\b}\n\b\f\b\16\b\u0080\13\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\t\u0089\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u0090\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009f\n\13\3\13"+
		"\2\3\16\f\2\4\6\b\n\f\16\20\22\24\2\3\3\2\3\3\u00b0\2\27\3\2\2\2\4:\3"+
		"\2\2\2\6Z\3\2\2\2\b\\\3\2\2\2\nd\3\2\2\2\fm\3\2\2\2\16t\3\2\2\2\20\u0088"+
		"\3\2\2\2\22\u008f\3\2\2\2\24\u009e\3\2\2\2\26\30\5\6\4\2\27\26\3\2\2\2"+
		"\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33\35\7\n\2\2"+
		"\34\33\3\2\2\2\34\35\3\2\2\2\35\36\3\2\2\2\36\37\7\32\2\2\37 \7\34\2\2"+
		" !\7\17\2\2!;\5\16\b\2\"#\7\34\2\2#$\7\17\2\2$;\5\16\b\2%&\7\32\2\2&\'"+
		"\7\34\2\2\'(\7\17\2\2()\7\24\2\2).\5\16\b\2*+\7\13\2\2+-\5\16\b\2,*\3"+
		"\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\7"+
		"\25\2\2\62;\3\2\2\2\63\64\7\34\2\2\64\65\7\24\2\2\65\66\5\16\b\2\66\67"+
		"\7\25\2\2\678\7\17\2\289\5\16\b\29;\3\2\2\2:\34\3\2\2\2:\"\3\2\2\2:%\3"+
		"\2\2\2:\63\3\2\2\2;\5\3\2\2\2<=\7\4\2\2=>\7\22\2\2>?\5\f\7\2?@\7\23\2"+
		"\2@C\5\b\5\2AB\7\5\2\2BD\5\b\5\2CA\3\2\2\2CD\3\2\2\2D[\3\2\2\2EF\7\6\2"+
		"\2FG\7\22\2\2GH\5\f\7\2HI\7\23\2\2IJ\5\b\5\2J[\3\2\2\2KL\7\7\2\2LM\7\22"+
		"\2\2MN\5\4\3\2NO\7\f\2\2OP\5\f\7\2PQ\7\f\2\2QR\5\16\b\2RS\7\23\2\2ST\5"+
		"\b\5\2T[\3\2\2\2UV\7\b\2\2V[\5\b\5\2W[\7\t\2\2X[\5\16\b\2Y[\5\n\6\2Z<"+
		"\3\2\2\2ZE\3\2\2\2ZK\3\2\2\2ZU\3\2\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2["+
		"\7\3\2\2\2\\^\7\20\2\2]_\5\6\4\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2"+
		"\2ab\3\2\2\2bc\7\21\2\2c\t\3\2\2\2dh\7\3\2\2eg\n\2\2\2fe\3\2\2\2gj\3\2"+
		"\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7\3\2\2l\13\3\2\2\2mn\5"+
		"\16\b\2no\7\37\2\2op\5\16\b\2p\r\3\2\2\2qr\b\b\1\2ru\5\20\t\2su\5\4\3"+
		"\2tq\3\2\2\2ts\3\2\2\2u~\3\2\2\2vw\f\6\2\2wx\7\31\2\2x}\5\20\t\2yz\f\5"+
		"\2\2z{\7\27\2\2{}\5\20\t\2|v\3\2\2\2|y\3\2\2\2}\u0080\3\2\2\2~|\3\2\2"+
		"\2~\177\3\2\2\2\177\17\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\5\22\n\2\u0082"+
		"\u0083\7\30\2\2\u0083\u0084\5\20\t\2\u0084\u0089\3\2\2\2\u0085\u0086\7"+
		"\27\2\2\u0086\u0089\5\20\t\2\u0087\u0089\5\22\n\2\u0088\u0081\3\2\2\2"+
		"\u0088\u0085\3\2\2\2\u0088\u0087\3\2\2\2\u0089\21\3\2\2\2\u008a\u008b"+
		"\5\24\13\2\u008b\u008c\7\26\2\2\u008c\u008d\5\22\n\2\u008d\u0090\3\2\2"+
		"\2\u008e\u0090\5\24\13\2\u008f\u008a\3\2\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\23\3\2\2\2\u0091\u009f\7\35\2\2\u0092\u009f\7\33\2\2\u0093\u009f\7\34"+
		"\2\2\u0094\u0095\7\34\2\2\u0095\u0096\7\24\2\2\u0096\u0097\5\16\b\2\u0097"+
		"\u0098\7\25\2\2\u0098\u009f\3\2\2\2\u0099\u009f\7\36\2\2\u009a\u009b\7"+
		"\22\2\2\u009b\u009c\5\16\b\2\u009c\u009d\7\23\2\2\u009d\u009f\3\2\2\2"+
		"\u009e\u0091\3\2\2\2\u009e\u0092\3\2\2\2\u009e\u0093\3\2\2\2\u009e\u0094"+
		"\3\2\2\2\u009e\u0099\3\2\2\2\u009e\u009a\3\2\2\2\u009f\25\3\2\2\2\20\31"+
		"\34.:CZ`ht|~\u0088\u008f\u009e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
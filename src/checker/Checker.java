package checker;

import java.util.ArrayList;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import grammar.MyGrammarBaseListener;
import grammar.MyGrammarParser.AddExprContext;
import grammar.MyGrammarParser.ArrayAssignContext;
import grammar.MyGrammarParser.ArrayDeclAssignContext;
import grammar.MyGrammarParser.ArrayFactorContext;
import grammar.MyGrammarParser.BoolFactorContext;
import grammar.MyGrammarParser.CharFactorContext;
import grammar.MyGrammarParser.CompContext;
import grammar.MyGrammarParser.DeclAssignContext;
import grammar.MyGrammarParser.ExpExpoContext;
import grammar.MyGrammarParser.ExpoTermContext;
import grammar.MyGrammarParser.ExprContext;
import grammar.MyGrammarParser.FactorExpoContext;
import grammar.MyGrammarParser.MultTermContext;
import grammar.MyGrammarParser.NegExprContext;
import grammar.MyGrammarParser.NegTermContext;
import grammar.MyGrammarParser.NumFactorContext;
import grammar.MyGrammarParser.ParFactorContext;
import grammar.MyGrammarParser.TermExprContext;
import grammar.MyGrammarParser.VarAssignContext;
import grammar.MyGrammarParser.VarFactorContext;

public class Checker extends MyGrammarBaseListener {
	private ParseTreeProperty<Type> types;
	private Scope scope;
	private ArrayList<String> errors;

	public Checker() {
		types = new ParseTreeProperty<>();
		scope = new Scope();
		errors = new ArrayList<>();
	}

	// --------------------------------------------------------------
	// -------------------- factor rules ----------------------------
	// --------------------------------------------------------------

	@Override
	public void exitNumFactor(NumFactorContext ctx) {
		types.put(ctx, Type.INT);
	}

	@Override
	public void exitBoolFactor(BoolFactorContext ctx) {
		types.put(ctx, Type.BOOL);
	}

	@Override
	public void exitCharFactor(CharFactorContext ctx) {
		types.put(ctx, Type.CHAR);
	}

	@Override
	public void exitVarFactor(VarFactorContext ctx) {
		if (scope.isDefined(ctx.ID().getText())) {
			types.put(ctx, scope.getType(ctx.ID().getText()));
		} else {
			Token t = ctx.ID().getSymbol();
			errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Variable "
					+ ctx.ID().getText() + " not defined");
		}
	}

	@Override
	public void exitArrayFactor(ArrayFactorContext ctx) {
		if (!scope.isDefined(ctx.ID().getText())) {
			Token t = ctx.ID().getSymbol();
			errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Variable "
					+ ctx.ID().getText() + " not defined");
		} else {
			Type t1 = scope.getType(ctx.ID().getText());
			Type t2 = types.get(ctx.expr());
			
			if (t2 == Type.INT) {
				types.put(ctx, t1);
			} else {
				Token t = ctx.ID().getSymbol();
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Index has to be a number");
			}
		}
	}

	@Override
	public void exitParFactor(ParFactorContext ctx) {
		if (types.get(ctx.expr()) != null) {
			types.put(ctx, types.get(ctx.expr()));
		}
	}

	// --------------------------------------------------------------
	// -------------------- expo rules ------------------------------
	// --------------------------------------------------------------

	@Override
	public void exitFactorExpo(FactorExpoContext ctx) {
		if (types.get(ctx.factor()) != null) {
			types.put(ctx, types.get(ctx.factor()));
		}
	}

	@Override
	public void exitExpExpo(ExpExpoContext ctx) {
		Type t1 = types.get(ctx.factor());
		Type t2 = types.get(ctx.expo());
		
		if (t1 != null && t2 != null) {
			if (t1 == Type.INT && t2 == Type.INT) {
				types.put(ctx, Type.INT);
			} else {
				Token t = ctx.EXP().getSymbol();
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Both arguments of '^' have to be integers");
			}
		}
	}

	// --------------------------------------------------------------
	// -------------------- term rules ------------------------------
	// --------------------------------------------------------------

	@Override
	public void exitMultTerm(MultTermContext ctx) {
		Type t1 = types.get(ctx.expo());
		Type t2 = types.get(ctx.term());
		if (t1 != null && t2 != null) {
			if (t1 != Type.INT && t2 != Type.INT) {
				Token token = ctx.MULT().getSymbol();
				errors.add("Line " + token.getLine() + ", Position " + token.getCharPositionInLine()
						+ ": Can only multiply integers");
			} else {
				types.put(ctx, Type.INT);
			}
		}
	}

	@Override
	public void exitNegTerm(NegTermContext ctx) {
		Type t = types.get(ctx.term());
		if (t != null) {
			if (t != Type.BOOL && t != Type.INT) {
				Token token = ctx.NEG().getSymbol();
				errors.add("Line " + token.getLine() + ", Position " + token.getCharPositionInLine()
						+ ": Can only negate boolean or integer values");
			} else {
				types.put(ctx, t);
			}
		}
	}

	@Override
	public void exitExpoTerm(ExpoTermContext ctx) {
		if (types.get(ctx.expo()) != null) {
			types.put(ctx, types.get(ctx.expo()));
		}
	}

	// --------------------------------------------------------------
	// -------------------- expr rules ------------------------------
	// --------------------------------------------------------------

	@Override
	public void exitAddExpr(AddExprContext ctx) {
		Type t1 = types.get(ctx.expr());
		Type t2 = types.get(ctx.term());
		if (t1 != null && t2 != null) {
			if (t1 != Type.INT && t2 != Type.INT) {
				Token token = ctx.ADD().getSymbol();
				errors.add("Line " + token.getLine() + ", Position " + token.getCharPositionInLine()
						+ ": Can only add two integers");
			} else {
				types.put(ctx, Type.INT);
			}
		}
	}

	@Override
	public void exitNegExpr(NegExprContext ctx) {
		Type t1 = types.get(ctx.expr());
		Type t2 = types.get(ctx.term());
		if (t1 != null && t2 != null) {
			if (t1 != Type.INT && t2 != Type.INT) {
				Token token = ctx.NEG().getSymbol();
				errors.add("Line " + token.getLine() + ", Position " + token.getCharPositionInLine()
						+ ": Can only subtract two integers");
			} else {
				types.put(ctx, Type.INT);
			}
		}
	}

	@Override
	public void exitTermExpr(TermExprContext ctx) {
		if (types.get(ctx.term()) != null) {
			types.put(ctx, types.get(ctx.term()));
		}
	}

	// --------------------------------------------------------------
	// -------------------- comp rule -------------------------------
	// --------------------------------------------------------------

	@Override
	public void exitComp(CompContext ctx) {
		Type t1 = types.get(ctx.getChild(0));
		Type t2 = types.get(ctx.getChild(2));
		if (t1 != null && t2 != null) {
			if (t1 == t2) {
				types.put(ctx, Type.BOOL);
			} else {
				Token token = ctx.COMP().getSymbol();
				errors.add("Line " + token.getLine() + ", Position " + token.getCharPositionInLine()
						+ ": Can only compare two variables of the same type");
			}
		}
	}

	// --------------------------------------------------------------
	// -------------------- assign rules ----------------------------
	// --------------------------------------------------------------

	private Type parseType(String s) {
		if (s.equals("int")) {
			return Type.INT;
		} else if (s.equals("char")) {
			return Type.CHAR;
		} else if (s.equals("bool")) {
			return Type.BOOL;
		} else {
			return null;
		}
	}

	public void exitDeclAssign(DeclAssignContext ctx) {
		Type t1 = parseType(ctx.TYPE().getText());
		Type t2 = types.get(ctx.expr());

		if (t1 != null && t2 != null) {
			if (t1 != t2) {
				Token t = ctx.TYPE().getSymbol();
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine()
						+ ": Left and right hand side of the assignment have to be of the same type");
			} else {
				scope.addVariable(ctx.ID().getText(), t1);
			}
		}
	}

	public void exitVarAssign(VarAssignContext ctx) {
		if (scope.isDefined(ctx.ID().getText())) {
			Type t1 = scope.getType(ctx.ID().getText());
			Type t2 = types.get(ctx.expr());

			if (t1 != t2) {
				Token t = ctx.ID().getSymbol();
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine()
						+ ": Left and right hand side of the assignment have to be of the same type");
			}
		} else {
			Token t = ctx.ID().getSymbol();
			errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Variable "
					+ ctx.ID().getText() + " not defined");
		}
	}

	public void exitArrayAssign(ArrayAssignContext ctx) {
		Token t = ctx.ID().getSymbol();
		
		if (scope.isDefined(ctx.ID().getText())) {
			Type t1 = scope.getType(ctx.ID().getText());
			Type t2 = types.get(ctx.expr(0));
			Type t3 = types.get(ctx.expr(1));
			
			if (t2 != Type.INT) {
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Index has to be an integer");
			} else if (t1 != t3) {
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Array type and assignment are not of the same type");
			}
		} else {
			errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Variable " + ctx.ID().getText() + " not defined");
		}
	}
	
	public void exitArrayDeclAssign(ArrayDeclAssignContext ctx) {
		Type type = parseType(ctx.TYPE().getText());
		
		for (ExprContext expr : ctx.expr()) {
			Type typeExpr = types.get(expr);
			if (typeExpr == null) {
				return;
			}
			if (typeExpr != type) {
				Token t = ctx.ID().getSymbol();
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Elements assigned to the array should be of the same type as the array");
				return;
			}
		}
		
		scope.addVariable(ctx.ID().getText(), type);
	}
	
	// --------------------------------------------------------------
	// -------------------- statement rule --------------------------
	// --------------------------------------------------------------

	// TODO entering and closing scopes, maybe when entering and exiting statements?
	
}
package checker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import grammar.*;
import grammar.MyGrammarParser.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Checker extends MyGrammarBaseListener {
	private ParseTreeProperty<Type> types;
	private Scope<Type> scope, globalScope;
	private ArrayList<String> errors;

	public Checker() {
		types = new ParseTreeProperty<>();
		scope = new Scope<>();
		globalScope = new Scope<>();
		errors = new ArrayList<>();
	}

	public static ArrayList<String> checkProgram(String file) {
		Checker checker = new Checker();

		try {
			ParseTree tree = parse(file);
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(checker, tree);
		} catch (IOException e) {
			System.out.println("Error: File could not be read");
		}

		return checker.getErrors();
	}

	public ArrayList<String> getErrors() {
		return errors;
	}

	public static ParseTree parse(String file) throws IOException {
		Lexer lexer = new MyGrammarLexer(CharStreams.fromPath(new File(file).toPath()));
		lexer.removeErrorListeners();
		TokenStream tokens = new CommonTokenStream(lexer);
		MyGrammarParser parser = new MyGrammarParser(tokens);
		ParseTree result = parser.program();
		return result;
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
			types.put(ctx, scope.getData(ctx.ID().getText()));
		} else if (globalScope.isDefined(ctx.ID().getText())) {
			types.put(ctx, globalScope.getData(ctx.ID().getText()));
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
			Type t1 = scope.getData(ctx.ID().getText());
			Type t2 = types.get(ctx.expr());

			if (t2 == Type.INT) {
				types.put(ctx, t1);
			} else {
				Token t = ctx.ID().getSymbol();
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine()
						+ ": Index has to be a number");
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
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine()
						+ ": Both arguments of '^' have to be integers");
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
	public void exitDivTerm(DivTermContext ctx) {
		Type t1 = types.get(ctx.expo());
		Type t2 = types.get(ctx.term());
		if (t1 != null && t2 != null) {
			if (t1 != Type.INT && t2 != Type.INT) {
				Token token = ctx.DIV().getSymbol();
				errors.add("Line " + token.getLine() + ", Position " + token.getCharPositionInLine()
						+ ": Can only divide integers");
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
		Type t1 = types.get(ctx.expr(0));
		Type t2 = types.get(ctx.expr(1));

		boolean allCompsBool = true;
		for (CompContext c : ctx.comp()) {
			if (types.get(c) != null) {
				allCompsBool = allCompsBool && types.get(c) == Type.BOOL;
			}
		}

		if (t1 != null && t2 != null) {
			if (t1 == t2 && allCompsBool) {
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
		Type t2;
		if (ctx.expr() == null) {
			t2 = types.get(ctx.comp());
		} else {
			t2 = types.get(ctx.expr());
		}

		if (t1 != null && t2 != null) {
			if (t1 != t2) {
				Token t = ctx.TYPE().getSymbol();
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine()
						+ ": Left and right hand side of the assignment have to be of the same type");
			} else if (scope.isInCurrentScope(ctx.ID().getText())) {
				Token t = ctx.ID().getSymbol();
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine()
						+ ": Variable has already been declared in the same scope");
			} else if (globalScope.isDefined(ctx.ID().getText())) {
				Token t = ctx.ID().getSymbol();
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine()
						+ ": Variable has already been defined as global");
			} else {
				if (ctx.GLOBAL() == null) {
					scope.addVariable(ctx.ID().getText(), t1);
				} else {
					globalScope.addVariable(ctx.ID().getText(), t1);
				}
			}
		}
	}

	public void exitVarAssign(VarAssignContext ctx) {
		if (scope.isDefined(ctx.ID().getText()) || globalScope.isDefined(ctx.ID().getText())) {
			Type t1;
			if (scope.isDefined(ctx.ID().getText())) {
				t1 = scope.getData(ctx.ID().getText());
			} else {
				t1 = globalScope.getData(ctx.ID().getText());
			}
			Type t2;
			if (ctx.expr() == null) {
				t2 = types.get(ctx.comp());
			} else {
				t2 = types.get(ctx.expr());
			}

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
			Type t1 = scope.getData(ctx.ID().getText());
			Type t2 = types.get(ctx.expr(0));
			Type t3;
			if (ctx.expr(1) == null) {
				t3 = types.get(ctx.comp());
			} else {
				t3 = types.get(ctx.expr(1));
			}

			if (t2 != Type.INT) {
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine()
						+ ": Index has to be an integer");
			} else if (t1 != t3) {
				errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine()
						+ ": Array type and assignment are not of the same type");
			}
		} else {
			errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Variable "
					+ ctx.ID().getText() + " not defined");
		}
	}

	public void exitArrayDeclAssign(ArrayDeclAssignContext ctx) {
		Type t1 = parseType(ctx.TYPE().getText());

		for (ParseTree elem : ctx.children) {
			if (elem instanceof ExprContext || elem instanceof CompContext) {
				Type t2 = types.get(elem);
				if (t2 == null) {
					return;
				}
				if (t1 != t2) {
					Token t = ctx.ID().getSymbol();
					errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine()
							+ ": Elements assigned to the array should be of the same type as the array");
					return;
				}
			}
		}

		scope.addVariable(ctx.ID().getText(), t1);
	}

	// --------------------------------------------------------------
	// -------------------- statement rules -------------------------
	// --------------------------------------------------------------

	public void enterBlock(BlockContext ctx) {
		scope.openScope();
	}

	public void exitBlock(BlockContext ctx) {
		scope.closeScope();
	}

	public void exitPrintStat(PrintStatContext ctx) {
		if (!scope.isDefined(ctx.ID().getText()) && !globalScope.isDefined(ctx.ID().getText())) {
			Token t = ctx.ID().getSymbol();
			errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Variable not defined");
		}
	}

	public void exitPrintStatArray(PrintStatArrayContext ctx) {
		if (!scope.isDefined(ctx.ID().getText()) && !globalScope.isDefined(ctx.ID().getText())) {
			Token t = ctx.ID().getSymbol();
			errors.add("Line " + t.getLine() + ", Position " + t.getCharPositionInLine() + ": Variable not defined");
		}
	}
}
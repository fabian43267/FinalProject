package generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import checker.Scope;
import grammar.MyGrammarBaseListener;
import grammar.MyGrammarParser;
import grammar.MyGrammarParser.AddExprContext;
import grammar.MyGrammarParser.ArrayFactorContext;
import grammar.MyGrammarParser.AssignExprContext;
import grammar.MyGrammarParser.BlockContext;
import grammar.MyGrammarParser.BoolFactorContext;
import grammar.MyGrammarParser.CharFactorContext;
import grammar.MyGrammarParser.CompContext;
import grammar.MyGrammarParser.DeclAssignContext;
import grammar.MyGrammarParser.ExpExpoContext;
import grammar.MyGrammarParser.ExpoTermContext;
import grammar.MyGrammarParser.ExprStatContext;
import grammar.MyGrammarParser.FactorExpoContext;
import grammar.MyGrammarParser.ForStatContext;
import grammar.MyGrammarParser.ForkStatContext;
import grammar.MyGrammarParser.IfStatContext;
import grammar.MyGrammarParser.JoinStatContext;
import grammar.MyGrammarParser.MultTermContext;
import grammar.MyGrammarParser.NegExprContext;
import grammar.MyGrammarParser.NegTermContext;
import grammar.MyGrammarParser.NumFactorContext;
import grammar.MyGrammarParser.ParFactorContext;
import grammar.MyGrammarParser.ProgramContext;
import grammar.MyGrammarParser.StatementContext;
import grammar.MyGrammarParser.TermExprContext;
import grammar.MyGrammarParser.VarAssignContext;
import grammar.MyGrammarParser.VarFactorContext;
import grammar.MyGrammarParser.WhileStatContext;

public class MyGenerator extends MyGrammarBaseListener {

	private ParseTreeProperty<ArrayList<String>> commands;
	private HashMap<ParseTree, ArrayList<String>> forks;
	private ArrayList<String> cmdsList;
	private HashMap<String, Integer> variables; // variable name and address
	private int addrTop;
	private Scope scope;
	private File file;

	public MyGenerator() {
		commands = new ParseTreeProperty<>();
		variables = new HashMap<>();
		addrTop = 0;
		scope = new Scope();
		forks = new HashMap<>();
	}

	@Override
	public void enterProgram(MyGrammarParser.ProgramContext ctx) {
	}

	@Override
	public void exitDeclAssign(DeclAssignContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		variables.put(ctx.ID().getText(), addrTop); // add the variable to the map
		cmds.addAll(commands.get(ctx.expr()));
		cmds.add("Pop regA");

		cmds.add("Store regA (DirAddr " + addrTop + ")");
		addrTop += 1; // increment the address to make room for the next variable
		commands.put(ctx, cmds);
	}

	@Override
	public void exitVarAssign(VarAssignContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.expr()));
		cmds.add("Pop regA");
		cmds.add("Store regA (DirAddr " + variables.get(ctx.ID().getText()) + ")");
		commands.put(ctx, cmds);
	}

	// ------------------------------------------
	// ------------- Program --------------------
	// ------------------------------------------

	@Override
	public void exitProgram(ProgramContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		// Concatenate all statements (except forks of course) to make main block
		ArrayList<String> mainBlock = new ArrayList<>();
		for (StatementContext bla : ctx.statement()) {
			if (!forks.containsKey(bla)) {
				mainBlock.addAll(commands.get(bla));
			}
		}
		mainBlock.add("EndProg");

		// Concatenate all fork blocks with EndProg at the end and keep track of
		// offsets for jumping to the right thread
		ArrayList<String> forkBlock = new ArrayList<>();
		ArrayList<Integer> offsets = new ArrayList<>();
		for (ArrayList<String> f : forks.values()) {
			forkBlock.addAll(f);
			forkBlock.add("EndProg");
			offsets.add(forkBlock.size());
		}

		// Build jump instructions
		ArrayList<String> jumps = new ArrayList<>();
		for (int i = 0; i < offsets.size(); i++) {
			jumps.add("Load (ImmValue " + (i+1) + ") regA");
			jumps.add("Compute Equal regSprID regA regC");
			jumps.add("Branch regC (Rel " + (((offsets.size() - (i+1)) * 3) + offsets.get(i) - 2) + ")");
		}
		
		// Build program from blocks
		cmds.add("Branch regSprID (Rel " + (mainBlock.size() + 1) + ")");
		cmds.addAll(mainBlock);		
		cmds.addAll(jumps);
		cmds.addAll(forkBlock);

		commands.put(ctx, cmds);
		cmdsList = cmds;
	}

	// ------------------------------------------
	// ------------- Statement ------------------
	// ------------------------------------------

	@Override
	public void exitIfStat(IfStatContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.comp()));
		cmds.add("Load (ImmValue 0) regA");
		cmds.add("Compute Equal regA regC regC");
		cmds.add("Branch regC (Rel " + (commands.get(ctx.block(0)).size() + 2) + ")");
		cmds.addAll(commands.get(ctx.block(0)));

		if (ctx.block().size() == 2) {
			cmds.add("Jump (Rel " + (commands.get(ctx.block(1)).size() + 1) + ")");
			cmds.addAll(commands.get(ctx.block(1)));
		}

		commands.put(ctx, cmds);
	}

	@Override
	public void exitWhileStat(WhileStatContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.comp()));
		cmds.add("Load (ImmValue 0) regA");
		cmds.add("Compute Equal regA regC regC");
		cmds.add("Branch regC (Rel " + String.valueOf(commands.get(ctx.block()).size() + 2) + ")");
		cmds.addAll(commands.get(ctx.block()));
		cmds.add("Jump (Rel (-" + String.valueOf(cmds.size()) + "))");
		commands.put(ctx, cmds);
	}

	@Override
	public void exitForStat(ForStatContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.assignment()));
		cmds.addAll(commands.get(ctx.comp()));
		cmds.add("Load (ImmValue 0) regA");
		cmds.add("Compute Equal regA regC regC");
		cmds.add("Branch regC (Rel "
				+ String.valueOf(commands.get(ctx.block()).size() + commands.get(ctx.expr()).size() + 2) + ")");
		cmds.addAll(commands.get(ctx.block()));
		cmds.addAll(commands.get(ctx.expr()));
		cmds.add("Jump (Rel (-" + String.valueOf(cmds.size() - commands.get(ctx.assignment()).size()) + "))");
		commands.put(ctx, cmds);
	}

	@Override
	public void exitForkStat(ForkStatContext ctx) {
		forks.put(ctx, commands.get(ctx.block()));
	}

	@Override
	public void exitJoinStat(JoinStatContext ctx) {
		// TODO
	}

	@Override
	public void exitExprStat(ExprStatContext ctx) {
		commands.put(ctx, commands.get(ctx.expr()));
	}

	// ------------------------------------------
	// --------------- Block --------------------
	// ------------------------------------------

	@Override
	public void enterBlock(BlockContext ctx) {
		scope.openScope();
	}

	@Override
	public void exitBlock(BlockContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		for (StatementContext bla : ctx.statement()) {
			cmds.addAll(commands.get(bla));
		}
		commands.put(ctx, cmds);
		scope.closeScope();
	}

	// ------------------------------------------
	// --------------- Comp ---------------------
	// ------------------------------------------

	public void exitComp(CompContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.expr(0)));
		cmds.addAll(commands.get(ctx.expr(1)));
		cmds.add("Pop regB");
		cmds.add("Pop regA");
		String cmp = "", op = ctx.COMP().getText();
		if (op.equals("==")) {
			cmp = "Equal";
		} else if (op.equals("<=")) {
			cmp = "LtE";
		} else if (op.equals(">=")) {
			cmp = "GtE";
		} else if (op.equals("!=")) {
			cmp = "NEq";
		} else if (op.equals(">")) {
			cmp = "Gt";
		} else if (op.equals("<")) {
			cmp = "Lt";
		}
		cmds.add("Compute " + cmp + " regA regB regC");
		commands.put(ctx, cmds);
	}

	// ------------------------------------------
	// ---------------- Expr --------------------
	// ------------------------------------------

	public void exitAddExpr(AddExprContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.expr()));
		cmds.addAll(commands.get(ctx.term()));
		cmds.add("Pop regB");
		cmds.add("Pop regA");
		cmds.add("Compute Add regA regB regA");
		cmds.add("Push regA");
		commands.put(ctx, cmds);
	}

	public void exitNegExpr(NegExprContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.expr()));
		cmds.addAll(commands.get(ctx.term()));
		cmds.add("Pop regB");
		cmds.add("Pop regA");
		cmds.add("Compute Sub regA regB regA");
		cmds.add("Push regA");
		commands.put(ctx, cmds);
	}

	public void exitTermExpr(TermExprContext ctx) {
		commands.put(ctx, commands.get(ctx.term()));
	}

	public void exitAssignExpr(AssignExprContext ctx) {
		commands.put(ctx, commands.get(ctx.assignment()));
	}

	// ------------------------------------------
	// -------------- Term ----------------------
	// ------------------------------------------

	public void exitMultTerm(MultTermContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.expo()));
		cmds.addAll(commands.get(ctx.term()));
		cmds.add("Pop regB");
		cmds.add("Pop regA");
		cmds.add("Compute Mul regA regB regA");
		cmds.add("Push regA");
		commands.put(ctx, cmds);
	}

	public void exitNegTerm(NegTermContext ctx) {
		// TODO
	}

	public void exitExpoTerm(ExpoTermContext ctx) {
		commands.put(ctx, commands.get(ctx.expo()));
	}

	// ------------------------------------------
	// -------------- Expo ----------------------
	// ------------------------------------------

	public void exitExpExpo(ExpExpoContext ctx) {
		// TODO that's gonna be quite nasty...
		// maybe a loop that counts down and then multiplying or something
	}

	public void exitFactorExpo(FactorExpoContext ctx) {
		commands.put(ctx, commands.get(ctx.factor()));
	}

	// ------------------------------------------
	// ------------ Factor ---------------------
	// ------------------------------------------

	public void exitNumFactor(NumFactorContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.add("Load (ImmValue " + ctx.NUM().getText() + ") regA");
		cmds.add("Push regA");
		commands.put(ctx, cmds);
	}

	public void exitBoolFactor(BoolFactorContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.add("Load (ImmValue " + (Boolean.parseBoolean(ctx.BOOL().getText()) ? "1" : "0") + ") regA");
		cmds.add("Push regA");
		commands.put(ctx, cmds);
	}

	public void exitVarFactor(VarFactorContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.add("Load (DirAddr " + variables.get(ctx.ID().getText()) + ") regA");
		cmds.add("Push regA");
		commands.put(ctx, cmds);
	}

	public void exitArrayFactor(ArrayFactorContext ctx) {
		// TODO
	}

	public void exitCharFactor(CharFactorContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.add("Load (ImmValue " + Character.getNumericValue(ctx.CHAR().getText().toCharArray()[1]) + ") regA");
		cmds.add("Push regA");
		commands.put(ctx, cmds);
	}

	public void exitParFactor(ParFactorContext ctx) {
		commands.put(ctx, commands.get(ctx.expr()));
	}

	public void init() {
		file = new File("myProgram.hs");
		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToFile() {
		try {
			BufferedWriter wrt = new BufferedWriter(new FileWriter(file, true));
			wrt.write(buildHaskellFileContents());
			wrt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// returns the contents of the haskell file as a string, given the commands it
	// has generated before
	public String buildHaskellFileContents() {
		StringBuilder sBuilder = new StringBuilder("import Sprockell\n\nprog :: [Instruction]\nprog = [ ");
		// cmdsList = new ArrayList<>(); // to be removed when actually generated
		for (int i = 0; i < cmdsList.size() - 1; i++) {
			sBuilder.append(cmdsList.get(i)).append("\n       , ");
		}
		String s = sBuilder.toString();
		s += cmdsList.get(cmdsList.size() - 1); // to be uncommented when actually generated
		
		String tmp = "prog";
		for (int i = 0; i < forks.size(); i++) {
			tmp += ",prog";
		}
		
		s += "\n       ]\n\nmain = run [" + tmp + "]\n";
		return s;
	}

}
/*
 * , Load (DirAddr 0) regA , WriteInstr regA numberIO
 */
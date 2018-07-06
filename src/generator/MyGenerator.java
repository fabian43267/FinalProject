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
import grammar.MyGrammarParser.AddExprContext;
import grammar.MyGrammarParser.ArrayAssignContext;
import grammar.MyGrammarParser.ArrayDeclAssignContext;
import grammar.MyGrammarParser.ArrayFactorContext;
import grammar.MyGrammarParser.AssignExprContext;
import grammar.MyGrammarParser.BlockContext;
import grammar.MyGrammarParser.BoolFactorContext;
import grammar.MyGrammarParser.CharFactorContext;
import grammar.MyGrammarParser.CommentStatContext;
import grammar.MyGrammarParser.CompContext;
import grammar.MyGrammarParser.DeclAssignContext;
import grammar.MyGrammarParser.DivTermContext;
import grammar.MyGrammarParser.ExpExpoContext;
import grammar.MyGrammarParser.ExpoTermContext;
import grammar.MyGrammarParser.ExprContext;
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
import grammar.MyGrammarParser.PrintStatArrayContext;
import grammar.MyGrammarParser.PrintStatContext;
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
	private Scope<Integer> variables; // variable name and address
	private Scope<Integer> forkVariables; // variables for forking
	private Scope<Integer> globalVariables; // same as variables, just global
	private ArrayList<Integer> threadLocks;
	private ArrayList<Integer> threadLocksForks;
	private int addrTop, globalMemOffset;
	private File file;
	private int forkingLevel = 0;

	public MyGenerator() {
		commands = new ParseTreeProperty<>();
		variables = new Scope<>();
		addrTop = 0;
		globalMemOffset = 1;
		forks = new HashMap<>();
		globalVariables = new Scope<>();
		forkVariables = new Scope<>();
		threadLocks = new ArrayList<>();
		threadLocksForks = new ArrayList<>();
	}

	// ------------------------------------------
	// ------------- Program --------------------
	// ------------------------------------------

	@Override
	public void exitProgram(ProgramContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		// Concatenate all statements (except forks of course) to make main block
		// Also, set init flag when first fork occurs
		ArrayList<String> mainBlock = new ArrayList<>();

		mainBlock.add("Load (ImmValue 1) regA");
		mainBlock.add("WriteInstr regA (DirAddr 0)");

		boolean noFork = true;

		for (StatementContext bla : ctx.statement()) {
			if (!forks.containsKey(bla)) {
				mainBlock.addAll(commands.get(bla));
			} else {
				if (noFork) {
					mainBlock.add("Load (ImmValue 0) regA");
					mainBlock.add("WriteInstr regA (DirAddr 0)");
					noFork = false;
				}
			}
		}
		mainBlock.add("EndProg");

		// Concatenate all fork blocks with EndProg at the end and keep track of
		// offsets for jumping to the right thread
		ArrayList<String> forkBlock = new ArrayList<>();
		ArrayList<Integer> offsets = new ArrayList<>();
		for (ArrayList<String> f : forks.values()) {
			offsets.add(forkBlock.size());
			forkBlock.addAll(f);
			forkBlock.add("EndProg");
		}

		// Build jump instructions
		ArrayList<String> jumps = new ArrayList<>();
		for (int i = 0; i < offsets.size(); i++) {
			jumps.add("Load (ImmValue " + (i + 1) + ") regA");
			jumps.add("Compute Equal regSprID regA regC");
			jumps.add("Branch regC (Rel " + (((offsets.size() - (i + 1)) * 3) + offsets.get(i) + 1) + ")");
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
	// ----------- Assignments ------------------
	// ------------------------------------------

	@Override
	public void exitDeclAssign(DeclAssignContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		if (ctx.expr() == null) {
			cmds.addAll(commands.get(ctx.comp()));
		} else {
			cmds.addAll(commands.get(ctx.expr()));
		}
		cmds.add("Pop regA");

		if (ctx.GLOBAL() == null) {
			if (forkingLevel > 0) {
				forkVariables.addVariable(ctx.ID().getText(), addrTop);
			} else {
				variables.addVariable(ctx.ID().getText(), addrTop);
			}
			cmds.add("Store regA (DirAddr " + addrTop + ")");
			addrTop += 1;
		} else {
			globalVariables.addVariable(ctx.ID().getText(), globalMemOffset);
			cmds.add("WriteInstr regA (DirAddr " + globalMemOffset + ")");
			globalMemOffset += 1;
		}
		commands.put(ctx, cmds);
	}

	@Override
	public void exitVarAssign(VarAssignContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		if (ctx.expr() == null) {
			cmds.addAll(commands.get(ctx.comp()));
		} else {
			cmds.addAll(commands.get(ctx.expr()));
		}
		cmds.add("Pop regA");

		if (forkingLevel > 0) {
			if (forkVariables.isDefined(ctx.ID().getText())) {
				cmds.add("Store regA (DirAddr " + forkVariables.getData(ctx.ID().getText()) + ")");
			} else {
				cmds.add("WriteInstr regA (DirAddr " + globalVariables.getData(ctx.ID().getText()) + ")");
			}
		} else {
			if (variables.isDefined(ctx.ID().getText())) {
				cmds.add("Store regA (DirAddr " + variables.getData(ctx.ID().getText()) + ")");
			} else {
				cmds.add("WriteInstr regA (DirAddr " + globalVariables.getData(ctx.ID().getText()) + ")");
			}
		}
		commands.put(ctx, cmds);
	}

	public void exitArrayDeclAssign(ArrayDeclAssignContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		Scope<Integer> vars;
		if (forkingLevel > 0) {
			vars = forkVariables;
		} else {
			vars = variables;
		}

		vars.addVariable(ctx.ID().getText(), addrTop);

		for (ParseTree elem : ctx.children) {
			if (elem instanceof ExprContext || elem instanceof CompContext) {
				cmds.addAll(commands.get(elem));
				cmds.add("Pop regA");
				cmds.add("Store regA (DirAddr " + (vars.getData(ctx.ID().getText()) + addrTop) + ")");
				addrTop += 1;
			}
		}

		commands.put(ctx, cmds);
	}

	public void exitArrayAssign(ArrayAssignContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		// calculate address in memory and push on stack
		cmds.addAll(commands.get(ctx.expr(0)));
		cmds.add("Pop regA");

		if (forkingLevel > 0) {
			cmds.add("Load (ImmValue " + forkVariables.getData(ctx.ID().getText()) + ") regB");
		} else {
			cmds.add("Load (ImmValue " + variables.getData(ctx.ID().getText()) + ") regB");
		}
		cmds.add("Compute Add regA regB regA");
		cmds.add("Push regA");

		// calculate expr
		if (ctx.expr(1) == null) {
			cmds.addAll(commands.get(ctx.comp()));
		} else {
			cmds.addAll(commands.get(ctx.expr(1)));
		}

		cmds.add("Pop regA"); // pop result of expr
		cmds.add("Pop regB"); // pop address

		// store result at address
		cmds.add("Store regA (IndAddr regB)");

		commands.put(ctx, cmds);
	}

	// ------------------------------------------
	// ------------- Statement ------------------
	// ------------------------------------------

	@Override
	public void exitIfStat(IfStatContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.comp()));
		cmds.add("Pop regB");
		cmds.add("Load (ImmValue 0) regA");
		cmds.add("Compute Equal regA regB regB");
		cmds.add("Branch regB (Rel " + (commands.get(ctx.block(0)).size() + 2) + ")");
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
		cmds.add("Pop regB");
		cmds.add("Load (ImmValue 0) regA");
		cmds.add("Compute Equal regA regB regB");
		cmds.add("Branch regB (Rel " + String.valueOf(commands.get(ctx.block()).size() + 2) + ")");
		cmds.addAll(commands.get(ctx.block()));
		cmds.add("Jump (Rel (-" + String.valueOf(cmds.size()) + "))");
		commands.put(ctx, cmds);
	}

	@Override
	public void exitForStat(ForStatContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.assignment()));
		cmds.addAll(commands.get(ctx.comp()));
		cmds.add("Pop regB");
		cmds.add("Load (ImmValue 0) regA");
		cmds.add("Compute Equal regA regB regB");
		cmds.add("Branch regB (Rel "
				+ String.valueOf(commands.get(ctx.block()).size() + commands.get(ctx.expr()).size() + 2) + ")");
		cmds.addAll(commands.get(ctx.block()));
		cmds.addAll(commands.get(ctx.expr()));
		cmds.add("Jump (Rel (-" + String.valueOf(cmds.size() - commands.get(ctx.assignment()).size()) + "))");
		commands.put(ctx, cmds);
	}

	public void enterForkStat(ForkStatContext ctx) {
		forkingLevel += 1;
		forkVariables.openScope();
	}

	@Override
	public void exitForkStat(ForkStatContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		// load 1 into shared memory ( 1 = not finished execution )
		cmds.add("Load (ImmValue 1) regA");
		cmds.add("WriteInstr regA (DirAddr " + globalMemOffset + ")");

		// do nothing for two clock cycles to make sure that the initialization has been
		// set by the main thread
		cmds.add("Nop");
		cmds.add("Nop");

		// wait until initialization complete
		cmds.add("ReadInstr (DirAddr 0)");
		cmds.add("Receive regA");
		cmds.add("Branch regA (Rel (-2))");

		// actual code that thread executes
		cmds.addAll(commands.get(ctx.block()));

		// load 0 into shared memory ( 0 = finished execution )
		cmds.add("Load (ImmValue 0) regA");
		cmds.add("WriteInstr regA (DirAddr " + globalMemOffset + ")");

		// store memory address for the join and increase memory offset
		if (forkingLevel > 1) {
			threadLocksForks.add(globalMemOffset);
		} else {
			threadLocksForks.add(globalMemOffset);
		}
		globalMemOffset += 1;

		forkingLevel -= 1;
		forkVariables.closeScope();
		forks.put(ctx, cmds);
	}

	@Override
	public void exitJoinStat(JoinStatContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		ArrayList<Integer> locks;
		if (forkingLevel > 0) {
			locks = threadLocksForks;
		} else {
			locks = threadLocks;
		}

		// add loops that check whether the given threads have set their locks to 0
		// (i.e. finished their execution)
		for (int memAddr : locks) {
			cmds.add("ReadInstr (DirAddr " + memAddr + ")");
			cmds.add("Receive regA");
			cmds.add("Branch regA (Rel (-2))");
		}

		// reset list of memory addresses
		threadLocks = new ArrayList<>();

		commands.put(ctx, cmds);
	}

	@Override
	public void exitExprStat(ExprStatContext ctx) {
		commands.put(ctx, commands.get(ctx.expr()));
	}

	public void exitPrintStat(PrintStatContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		if (forkingLevel > 0) {
			if (forkVariables.isDefined(ctx.ID().getText())) {
				cmds.add("Load (DirAddr " + forkVariables.getData(ctx.ID().getText()) + ") regA");
			} else {
				cmds.add("ReadInstr (DirAddr " + globalVariables.getData(ctx.ID().getText()) + ")");
				cmds.add("Receive regA");
			}
		} else {
			if (variables.isDefined(ctx.ID().getText())) {
				cmds.add("Load (DirAddr " + variables.getData(ctx.ID().getText()) + ") regA");
			} else {
				cmds.add("ReadInstr (DirAddr " + globalVariables.getData(ctx.ID().getText()) + ")");
				cmds.add("Receive regA");
			}
		}

		cmds.add("WriteInstr regA numberIO");

		commands.put(ctx, cmds);
	}

	public void exitPrintStatArray(PrintStatArrayContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		if (forkingLevel > 0) {
			if (forkVariables.isDefined(ctx.ID().getText())) {
				// calculate address in memory
				cmds.addAll(commands.get(ctx.expr()));
				cmds.add("Pop regA");
				cmds.add("Load (ImmValue " + forkVariables.getData(ctx.ID().getText()) + ") regB");
				cmds.add("Compute Add regA regB regA");
				// load that address
				cmds.add("Load (IndAddr regA) regA");
			} else {
				cmds.add("ReadInstr (DirAddr " + globalVariables.getData(ctx.ID().getText()) + ")");
				cmds.add("Receive regA");
			}
		} else {
			if (variables.isDefined(ctx.ID().getText())) {
				// calculate address in memory
				cmds.addAll(commands.get(ctx.expr()));
				cmds.add("Pop regA");
				cmds.add("Load (ImmValue " + variables.getData(ctx.ID().getText()) + ") regB");
				cmds.add("Compute Add regA regB regA");
				// load that address
				cmds.add("Load (IndAddr regA) regA");
			} else {
				cmds.add("ReadInstr (DirAddr " + globalVariables.getData(ctx.ID().getText()) + ")");
				cmds.add("Receive regA");
			}
		}

		cmds.add("WriteInstr regA numberIO");

		commands.put(ctx, cmds);
	}

	public void exitCommentStat(CommentStatContext ctx) {
		commands.put(ctx, new ArrayList<String>());
	}

	// ------------------------------------------
	// --------------- Block --------------------
	// ------------------------------------------

	@Override
	public void enterBlock(BlockContext ctx) {
		variables.openScope();
	}

	@Override
	public void exitBlock(BlockContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		for (StatementContext bla : ctx.statement()) {
			if (!forks.containsKey(bla)) {
				cmds.addAll(commands.get(bla));
			}
		}
		commands.put(ctx, cmds);
		variables.closeScope();
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
		cmds.add("Compute " + cmp + " regA regB regA");

		int i = 3;
		for (CompContext c : ctx.comp()) {
			cmds.add("Push regA");
			cmds.addAll(commands.get(c));
			cmds.add("Pop regB");
			cmds.add("Pop regA");
			cmds.add("Compute " + (ctx.getChild(i).getText().equals("&&") ? "And" : "Or") + " regA regB regA");
			i += 2;
		}

		cmds.add("Push regA");
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

	public void exitDivTerm(DivTermContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.expo()));
		cmds.addAll(commands.get(ctx.term()));
		cmds.add("Pop regB"); // regB is the divisor
		cmds.add("Pop regA"); // regA is the dividend
		cmds.add("Load (ImmValue 0) regC"); // regC counts the iterations, so it will be the actual result
		cmds.add("Compute Lt regA regB regD"); // regD is just used for comparing and branching
		cmds.add("Branch regD (Rel 4)");
		cmds.add("Compute Sub regA regB regA");
		cmds.add("Compute Incr regC regC regC");
		cmds.add("Jump (Rel (-4))");
		cmds.add("Push regC");
		commands.put(ctx, cmds);
	}

	public void exitNegTerm(NegTermContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();
		cmds.addAll(commands.get(ctx.term()));
		cmds.add("Load (ImmValue 0) regA");
		cmds.add("Pop regB");
		cmds.add("Compute Sub regA regB regA");
		cmds.add("Push regA");
		commands.put(ctx, cmds);
	}

	public void exitExpoTerm(ExpoTermContext ctx) {
		commands.put(ctx, commands.get(ctx.expo()));
	}

	// ------------------------------------------
	// -------------- Expo ----------------------
	// ------------------------------------------

	public void exitExpExpo(ExpExpoContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		cmds.addAll(commands.get(ctx.expo()));
		cmds.addAll(commands.get(ctx.factor()));
		cmds.add("Load (ImmValue 1) regD"); // regD contains 1 for decrementing the counter
		cmds.add("Pop regB"); // regB contains factor
		cmds.add("Load (IndAddr regB) regA"); // regA contains the actual result
		cmds.add("Pop regC"); // regC contains the counter
		cmds.add("Branch regC (Rel 4)");
		cmds.add("Compute Mul regA regB regA");
		cmds.add("Compute Sub regC regD regC");
		cmds.add("Jump (Rel (-2))");
		cmds.add("Push regA");

		commands.put(ctx, cmds);
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

		if (forkingLevel > 0) {
			if (forkVariables.isDefined(ctx.ID().getText())) {
				cmds.add("Load (DirAddr " + forkVariables.getData(ctx.ID().getText()) + ") regA");
			} else {
				cmds.add("ReadInstr (DirAddr " + globalVariables.getData(ctx.ID().getText()) + ")");
				cmds.add("Receive regA");
			}
		} else {
			if (variables.isDefined(ctx.ID().getText())) {
				cmds.add("Load (DirAddr " + variables.getData(ctx.ID().getText()) + ") regA");
			} else {
				cmds.add("ReadInstr (DirAddr " + globalVariables.getData(ctx.ID().getText()) + ")");
				cmds.add("Receive regA");
			}
		}
		cmds.add("Push regA");
		commands.put(ctx, cmds);
	}

	public void exitArrayFactor(ArrayFactorContext ctx) {
		ArrayList<String> cmds = new ArrayList<>();

		// calculate address in memory
		cmds.addAll(commands.get(ctx.expr()));
		cmds.add("Pop regA");

		if (forkingLevel > 0) {
			cmds.add("Load (ImmValue " + forkVariables.getData(ctx.ID().getText()) + ") regB");
		} else {
			cmds.add("Load (ImmValue " + variables.getData(ctx.ID().getText()) + ") regB");
		}
		cmds.add("Compute Add regA regB regA");

		// load value and push to stack
		cmds.add("Load (IndAddr regA) regA");
		cmds.add("Push regA");

		commands.put(ctx, cmds);
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

	// ------------------------------------------
	// ------------ Generating Code -------------
	// ------------------------------------------

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
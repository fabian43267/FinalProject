package generator;

import checker.Checker;
import checker.Scope;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

import grammar.MyGrammarLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import grammar.MyGrammarBaseListener;
import grammar.MyGrammarParser;
import grammar.MyGrammarParser.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class MyGenerator extends MyGrammarBaseListener {

    private ParseTreeProperty<ArrayList<String>> commands;
    private ArrayList<String> cmdsList;
    private HashMap<String, Integer> variables; //variable name and address
    private int addrTop;
    private Scope scope;
    private File file;

    public MyGenerator() {
        commands = new ParseTreeProperty<>();
        variables = new HashMap<>();
        addrTop = 0;
        scope = new Scope();
    }

    @Override
    public void enterProgram(MyGrammarParser.ProgramContext ctx) { }

    @Override
    public void exitDeclAssign(DeclAssignContext ctx) {
        ArrayList<String> cmds = new ArrayList<>();
        variables.put(ctx.ID().getText(), addrTop); // add the variable to the map
        cmds.addAll(commands.get(ctx.expr()));
        cmds.add("Pop regA");

        cmds.add("Store regA (DirAddr " + addrTop + ")");
        addrTop += 1; //increment the address to make room for the next variable
        commands.put(ctx, cmds);
    }

    @Override public void exitVarAssign(VarAssignContext ctx) {
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
    	for (StatementContext bla : ctx.statement()) {
    		cmds.addAll(commands.get(bla));
    	}
    	cmds.add("EndProg");
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
    	cmds.add("Compute Equal regA");
    	cmds.add("Branch regC (Rel 2)");
    	cmds.add("Jump (Rel " + String.valueOf(commands.get(ctx.block(0))) + ")");
    	
    	
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
    	cmds.add("Branch regC (Rel " + String.valueOf(commands.get(ctx.block()).size() + commands.get(ctx.expr()).size() + 2) + ")");
    	cmds.addAll(commands.get(ctx.block()));
    	cmds.addAll(commands.get(ctx.expr()));
    	cmds.add("Jump (Rel (-" + String.valueOf(cmds.size() - commands.get(ctx.assignment()).size() - commands.get(ctx.comp()).size()) + "))");
    	commands.put(ctx, cmds);
    }

    @Override
    public void exitForkStat(ForkStatContext ctx) {
    	// TODO
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
    // ------------  Factor ---------------------
    // ------------------------------------------
    
    public void exitNumFactor(NumFactorContext ctx) {
    	ArrayList<String> cmds = new ArrayList<>();
    	cmds.add("Load (ImmValue " + ctx.NUM().getText() + ") regA");
    	cmds.add("Push regA");
    	commands.put(ctx,cmds);
    }

    public void exitBoolFactor(BoolFactorContext ctx) {
    	ArrayList<String> cmds = new ArrayList<>();
    	cmds.add("Load (ImmValue " + (Boolean.parseBoolean(ctx.BOOL().getText())?"1":"0") + ") regA");
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
            if(file.exists()) {
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

    // returns te contents of the haskell file as a string, given the commands it has generated before
    public String buildHaskellFileContents() {
        StringBuilder sBuilder = new StringBuilder("import Sprockell\n\nprog :: [Instruction]\nprog = [ ");
        //cmdsList = new ArrayList<>(); // to be removed when actually generated
        for (int i = 0; i < cmdsList.size()-1; i++) {
    		sBuilder.append(cmdsList.get(i)).append("\n       , ");
    	}
        String s = sBuilder.toString();
        s += cmdsList.get(cmdsList.size()-1); // to be uncommented wen actually generated
        s += "\n       ]\n\nmain = run [prog]\n";
    	return s;
    }

    public static void main(String[] args) {
        String dir = "/Users/ducu97/IntelliJProjects/FinalProject/src/test/sample_progs/";
        MyGenerator gen = new MyGenerator();
        Path progPath = new File(dir + args[0]).toPath();
        Lexer lexer = null;
        try {
            lexer = new MyGrammarLexer(CharStreams.fromPath(progPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lexer.removeErrorListeners();
        TokenStream tokens = new CommonTokenStream(lexer);
        MyGrammarParser parser = new MyGrammarParser(tokens);
        ParseTree tree = parser.program();

        Checker checker = new Checker();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(checker, tree);

        if (checker.getErrors().isEmpty()) {
            gen.init();
            walker.walk(gen, tree);
            gen.writeToFile();
        }
    }

}
/*
       , Load (DirAddr 0) regA
       , WriteInstr regA numberIO
*/
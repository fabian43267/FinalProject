package generator;

import checker.Scope;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

import grammar.MyGrammarBaseListener;
import grammar.MyGrammarParser;
import grammar.MyGrammarParser.*;


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
    public void enterDeclAssign(MyGrammarParser.DeclAssignContext ctx) {
        ArrayList<String> cmds = new ArrayList<>();
        variables.put(ctx.ID().getText(), addrTop); // add the variable to the map

        if (ctx.TYPE().getText().equals("bool")) {
            if (ctx.expr().getText().equals("true")) {
                cmds.add("Load (ImmValue " + 1 + ") regA");
            } else {
                cmds.add("Load (ImmValue " + 0 + ") regA");
            }
        } else if (ctx.TYPE().getText().equals("char")) {
            cmds.add("Load (ImmValue " + (int) ctx.expr().getText().charAt(1) + ") regA");
        } else {
            cmds.add("Load (ImmValue " + ctx.expr() + ") regA");
        }


        cmds.add("Store regA (DirAddr " + addrTop + ")");
        addrTop += 4; //increment the address to make room for the next variable
        commands.put(ctx, cmds);
    }

    @Override public void enterVarAssign(MyGrammarParser.VarAssignContext ctx) {
        ArrayList<String> cmds = new ArrayList<>();
        variables.put(ctx.ID().getText(), addrTop);
    }



    // returns a haskell file as a string, given the commands it has generated before
    /*
    public String buildHaskellFile() {
    	String s = "import Sprockell\nprog = [";
    	for (int i = 0; i < commands..size()-1; i++) {
    		s += commands.get(i) + ",\n";
    	}
    	s += commands.get(commands.size()-1) + "]\n\nmain = run [prog]\n";
    	return s;
    }

    */

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



    	commands.put(ctx, cmds);
    }

    @Override
    public void exitWhileStat(WhileStatContext ctx) {
    	ArrayList<String> cmds = new ArrayList<>();
    	cmds.addAll(commands.get(ctx.block()));
    	cmds.addAll(commands.get(ctx.comp()));
    	commands.put(ctx, cmds);
    }

    @Override
    public void exitForStat(ForStatContext ctx) {
    	ArrayList<String> cmds = new ArrayList<>();
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
    	// TODO add actual comparison
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
            wrt.write(buildHaskellFile());
            wrt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // returns a haskell file as a string, given the commands it has generated before
    public String buildHaskellFile() {
        StringBuilder sBuilder = new StringBuilder("import Sprockell\n\nprog :: [Instruction]\nprog = [");
        cmdsList = new ArrayList<>(); // to be removed when actually generated
        for (int i = 0; i < cmdsList.size()-1; i++) {
    		sBuilder.append(cmdsList.get(i)).append(",\n");
    	}
        String s = sBuilder.toString();
        //s += cmdsList.get(cmdsList.size()-1); // to be uncommented wen actually generated
        s += "]\n\nmain = run [prog]\n";
    	return s;
    }

    public static void main(String[] args) {
        MyGenerator gen = new MyGenerator();
        gen.init();
        gen.writeToFile();
    }

}

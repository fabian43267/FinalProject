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
import grammar.MyGrammarParser.ArrayFactorContext;
import grammar.MyGrammarParser.BoolFactorContext;
import grammar.MyGrammarParser.CharFactorContext;
import grammar.MyGrammarParser.ExpExpoContext;
import grammar.MyGrammarParser.ExpoTermContext;
import grammar.MyGrammarParser.FactorExpoContext;
import grammar.MyGrammarParser.MultTermContext;
import grammar.MyGrammarParser.NegTermContext;
import grammar.MyGrammarParser.NumFactorContext;
import grammar.MyGrammarParser.ParFactorContext;
import grammar.MyGrammarParser.ProgramContext;
import grammar.MyGrammarParser.StatementContext;
import grammar.MyGrammarParser.VarFactorContext;

public class MyGenerator extends MyGrammarBaseListener {

    private ParseTreeProperty<ArrayList<String>> commands = new ParseTreeProperty<>();
    private HashMap<String, Integer> variables = new HashMap<>(); //variable name and address
    private int addrTop = 0;
    private Scope scope = new Scope();
    private File file;

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

    public void exitProgram(ProgramContext ctx) {
    	ArrayList<String> cmds = new ArrayList<>();
    	for (StatementContext bla : ctx.statement()) {
    		cmds.addAll(commands.get(bla));
    	}
    	cmds.add("EndProg");
    	commands.put(ctx, cmds);
    }

    // ------------------------------------------
    // -------------- Term ----------------------
    // ------------------------------------------
    
    public void exitMultTerm(MultTermContext ctx) {
    	ArrayList<String> cmds = new ArrayList<>();
    	cmds.addAll(commands.get(ctx.expo()));
    	cmds.addAll(commands.get(ctx.term()));
    	cmds.add("Pop regA");
    	cmds.add("Pop regB");
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
            wrt.write("import Sprockell\n\n");
            wrt.write("prog :: [Instruction]\n");
            wrt.write("prog = [\n");
                //insert elements from command one by one with a comma in front in here
            wrt.write(", EndProg\n");
            wrt.write("]\n\n");
            wrt.write("-- hi mum\n");
            wrt.write("main = run [prog]\n");
            wrt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

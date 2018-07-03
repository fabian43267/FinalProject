package generator;

import grammar.MyGrammarBaseListener;
import grammar.MyGrammarParser;
import grammar.MyGrammarParser.BoolFactorContext;
import grammar.MyGrammarParser.FactorContext;
import grammar.MyGrammarParser.NumFactorContext;
import grammar.MyGrammarParser.ProgramContext;
import grammar.MyGrammarParser.StatementContext;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class MyGenerator extends MyGrammarBaseListener {

    private ParseTreeProperty<ArrayList<String>> commands = new ParseTreeProperty<>();
    private HashMap<String, Integer> variables = new HashMap<>();
    private int r1 = 1, r2 = 2;
    private int addrTop = 0;

    @Override
    public void enterProgram(MyGrammarParser.ProgramContext ctx) { }

    @Override
    public void enterDeclAssign(MyGrammarParser.DeclAssignContext ctx) {
        ArrayList<String> cmds = new ArrayList<>();
        variables.put(ctx.ID().getText(), addrTop); // add the variable to the map
        cmds.add("Load (ImmValue " + ctx.expr() + ") " + r1);
        cmds.add("Store " + r1 + " (DirAddr " + addrTop + ")");
        addrTop += 4; //increment the address to make room for the next variable
        commands.put(ctx, cmds);
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

}

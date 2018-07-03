package generator;

import grammar.MyGrammarBaseListener;
import grammar.MyGrammarParser;

import java.util.ArrayList;
import java.util.List;

public class MyGenerator extends MyGrammarBaseListener {

    private ArrayList commands = new ArrayList();

    @Override public void enterProgram(MyGrammarParser.ProgramContext ctx) { }
        

}

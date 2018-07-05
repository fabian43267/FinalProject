package test;

import static org.junit.Assert.*;

import grammar.MyGrammarLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class SyntaxTest {

    @Test
    public void correctSyntax() {
        assertTrue(analyzeSyntax("syntax_correct.txt").isEmpty());
    }

    @Test
    public void wrongSyntax() {
        List<String> errors = analyzeSyntax("syntax_wrong.txt");
//        for (String error : errors) {
//            System.out.println(error);
//        }
        assertTrue(!errors.isEmpty());
    }

    private List<String> analyzeSyntax(String file) {
        String dir = "/Users/ducu97/IntelliJProjects/FinalProject/src/test/sample_progs/";
        Path progPath = new File(dir + file).toPath();
        MyErrorListener err = new MyErrorListener();

        CharStream chars = null;
        try {
            chars = CharStreams.fromPath(progPath);
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file!");
        }
        Lexer lexer = new MyGrammarLexer(chars);
        lexer.removeErrorListeners();
        lexer.addErrorListener(err);
        lexer.getAllTokens();
        return err.getErrors();
    }


}

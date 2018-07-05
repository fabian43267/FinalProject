package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import checker.Checker;
import generator.MyGenerator;
import grammar.MyGrammarLexer;
import grammar.MyGrammarParser;

public class Compiler {
	
	public final static String MAC_DIR = "/Users/ducu97/IntelliJProjects/FinalProject/src/test/sample_progs/";
	public final static String ECLIPSE_DIR = "src/test/sample_progs/";

	public static void main(String[] args) {
		// generate path to file
		Path progPath;
		if (args.length > 0) {
			progPath = new File(MAC_DIR + args[0]).toPath();
		} else {
			progPath = new File(ECLIPSE_DIR + "program6.txt").toPath();
		}
		
		// create parse tree
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

		// check program for type errors
		Checker checker = new Checker();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(checker, tree);

		// generate program if no errors occurred
		MyGenerator gen = new MyGenerator();
		if (checker.getErrors().isEmpty()) {
			gen.init();
			walker.walk(gen, tree);
			gen.writeToFile();
		} else {
			System.out.println("Type checking errors occurred!");
			for (String s : checker.getErrors()) {
				System.out.println(s);
			}
		}
	}

}

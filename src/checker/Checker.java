package checker;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

import grammar.MyGrammarBaseListener;

public class Checker extends MyGrammarBaseListener {
	private ParseTreeProperty<Type> types;
	private Scope scope;
	
	public Checker() {
		types = new ParseTreeProperty<>();
		scope = new Scope();
	}
}
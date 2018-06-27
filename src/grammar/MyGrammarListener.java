// Generated from MyGrammar.g4 by ANTLR 4.4
package grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyGrammarParser}.
 */
public interface MyGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(@NotNull MyGrammarParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(@NotNull MyGrammarParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull MyGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull MyGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull MyGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull MyGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull MyGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull MyGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull MyGrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull MyGrammarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull MyGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull MyGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull MyGrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull MyGrammarParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#expo}.
	 * @param ctx the parse tree
	 */
	void enterExpo(@NotNull MyGrammarParser.ExpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#expo}.
	 * @param ctx the parse tree
	 */
	void exitExpo(@NotNull MyGrammarParser.ExpoContext ctx);
}
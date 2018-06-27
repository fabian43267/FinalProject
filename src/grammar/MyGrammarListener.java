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
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull MyGrammarParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull MyGrammarParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterCharFactor(@NotNull MyGrammarParser.CharFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitCharFactor(@NotNull MyGrammarParser.CharFactorContext ctx);
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
	 * Enter a parse tree produced by the {@code declAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterDeclAssign(@NotNull MyGrammarParser.DeclAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitDeclAssign(@NotNull MyGrammarParser.DeclAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterNumFactor(@NotNull MyGrammarParser.NumFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitNumFactor(@NotNull MyGrammarParser.NumFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayDeclAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclAssign(@NotNull MyGrammarParser.ArrayDeclAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayDeclAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclAssign(@NotNull MyGrammarParser.ArrayDeclAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssign(@NotNull MyGrammarParser.ArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssign(@NotNull MyGrammarParser.ArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(@NotNull MyGrammarParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(@NotNull MyGrammarParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTermExpr(@NotNull MyGrammarParser.TermExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTermExpr(@NotNull MyGrammarParser.TermExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterNegTerm(@NotNull MyGrammarParser.NegTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitNegTerm(@NotNull MyGrammarParser.NegTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorExpo}
	 * labeled alternative in {@link MyGrammarParser#expo}.
	 * @param ctx the parse tree
	 */
	void enterFactorExpo(@NotNull MyGrammarParser.FactorExpoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorExpo}
	 * labeled alternative in {@link MyGrammarParser#expo}.
	 * @param ctx the parse tree
	 */
	void exitFactorExpo(@NotNull MyGrammarParser.FactorExpoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expExpo}
	 * labeled alternative in {@link MyGrammarParser#expo}.
	 * @param ctx the parse tree
	 */
	void enterExpExpo(@NotNull MyGrammarParser.ExpExpoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expExpo}
	 * labeled alternative in {@link MyGrammarParser#expo}.
	 * @param ctx the parse tree
	 */
	void exitExpExpo(@NotNull MyGrammarParser.ExpExpoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterVarFactor(@NotNull MyGrammarParser.VarFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitVarFactor(@NotNull MyGrammarParser.VarFactorContext ctx);
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
	 * Enter a parse tree produced by the {@code varAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterVarAssign(@NotNull MyGrammarParser.VarAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitVarAssign(@NotNull MyGrammarParser.VarAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStat(@NotNull MyGrammarParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStat(@NotNull MyGrammarParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterParFactor(@NotNull MyGrammarParser.ParFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitParFactor(@NotNull MyGrammarParser.ParFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMultTerm(@NotNull MyGrammarParser.MultTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMultTerm(@NotNull MyGrammarParser.MultTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(@NotNull MyGrammarParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(@NotNull MyGrammarParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(@NotNull MyGrammarParser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(@NotNull MyGrammarParser.NegExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterArrayFactor(@NotNull MyGrammarParser.ArrayFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitArrayFactor(@NotNull MyGrammarParser.ArrayFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expoTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterExpoTerm(@NotNull MyGrammarParser.ExpoTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expoTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitExpoTerm(@NotNull MyGrammarParser.ExpoTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterBoolFactor(@NotNull MyGrammarParser.BoolFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitBoolFactor(@NotNull MyGrammarParser.BoolFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(@NotNull MyGrammarParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(@NotNull MyGrammarParser.WhileStatContext ctx);
}
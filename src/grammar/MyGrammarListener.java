// Generated from /Users/ducu97/IntelliJProjects/FinalProject/src/grammar/MyGrammar.g4 by ANTLR 4.7
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyGrammarParser}.
 */
public interface MyGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MyGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MyGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterDeclAssign(MyGrammarParser.DeclAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitDeclAssign(MyGrammarParser.DeclAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterVarAssign(MyGrammarParser.VarAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitVarAssign(MyGrammarParser.VarAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayDeclAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclAssign(MyGrammarParser.ArrayDeclAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayDeclAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclAssign(MyGrammarParser.ArrayDeclAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssign(MyGrammarParser.ArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssign}
	 * labeled alternative in {@link MyGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssign(MyGrammarParser.ArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MyGrammarParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MyGrammarParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(MyGrammarParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(MyGrammarParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStat(MyGrammarParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStat(MyGrammarParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forkStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForkStat(MyGrammarParser.ForkStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forkStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForkStat(MyGrammarParser.ForkStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code joinStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJoinStat(MyGrammarParser.JoinStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code joinStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJoinStat(MyGrammarParser.JoinStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(MyGrammarParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(MyGrammarParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commentStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCommentStat(MyGrammarParser.CommentStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commentStat}
	 * labeled alternative in {@link MyGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCommentStat(MyGrammarParser.CommentStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MyGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MyGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(MyGrammarParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(MyGrammarParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(MyGrammarParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(MyGrammarParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(MyGrammarParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(MyGrammarParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTermExpr(MyGrammarParser.TermExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTermExpr(MyGrammarParser.TermExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(MyGrammarParser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(MyGrammarParser.NegExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MyGrammarParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MyGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MyGrammarParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMultTerm(MyGrammarParser.MultTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMultTerm(MyGrammarParser.MultTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterNegTerm(MyGrammarParser.NegTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitNegTerm(MyGrammarParser.NegTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expoTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterExpoTerm(MyGrammarParser.ExpoTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expoTerm}
	 * labeled alternative in {@link MyGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitExpoTerm(MyGrammarParser.ExpoTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expExpo}
	 * labeled alternative in {@link MyGrammarParser#expo}.
	 * @param ctx the parse tree
	 */
	void enterExpExpo(MyGrammarParser.ExpExpoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expExpo}
	 * labeled alternative in {@link MyGrammarParser#expo}.
	 * @param ctx the parse tree
	 */
	void exitExpExpo(MyGrammarParser.ExpExpoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorExpo}
	 * labeled alternative in {@link MyGrammarParser#expo}.
	 * @param ctx the parse tree
	 */
	void enterFactorExpo(MyGrammarParser.FactorExpoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorExpo}
	 * labeled alternative in {@link MyGrammarParser#expo}.
	 * @param ctx the parse tree
	 */
	void exitFactorExpo(MyGrammarParser.FactorExpoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterNumFactor(MyGrammarParser.NumFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitNumFactor(MyGrammarParser.NumFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterBoolFactor(MyGrammarParser.BoolFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitBoolFactor(MyGrammarParser.BoolFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterVarFactor(MyGrammarParser.VarFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitVarFactor(MyGrammarParser.VarFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterArrayFactor(MyGrammarParser.ArrayFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitArrayFactor(MyGrammarParser.ArrayFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterCharFactor(MyGrammarParser.CharFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitCharFactor(MyGrammarParser.CharFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterParFactor(MyGrammarParser.ParFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parFactor}
	 * labeled alternative in {@link MyGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitParFactor(MyGrammarParser.ParFactorContext ctx);
}
// Generated from D:/Sprachkonzepte/Aufgabe2/src/main/java/de/htwg/TimeintervalParser.g4 by ANTLR 4.13.1
package de.htwg;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TimeintervalParser}.
 */
public interface TimeintervalParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TimeintervalParser#timeinterval}.
	 * @param ctx the parse tree
	 */
	void enterTimeinterval(TimeintervalParser.TimeintervalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TimeintervalParser#timeinterval}.
	 * @param ctx the parse tree
	 */
	void exitTimeinterval(TimeintervalParser.TimeintervalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TimeintervalParser#uhrzeit}.
	 * @param ctx the parse tree
	 */
	void enterUhrzeit(TimeintervalParser.UhrzeitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TimeintervalParser#uhrzeit}.
	 * @param ctx the parse tree
	 */
	void exitUhrzeit(TimeintervalParser.UhrzeitContext ctx);
}
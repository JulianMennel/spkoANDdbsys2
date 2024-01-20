// Generated from D:/Sprachkonzepte/Aufgabe2/src/main/java/de/htwg/TimeintervalParser.g4 by ANTLR 4.13.1
package de.htwg;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TimeintervalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TimeintervalParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TimeintervalParser#timeinterval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeinterval(TimeintervalParser.TimeintervalContext ctx);
	/**
	 * Visit a parse tree produced by {@link TimeintervalParser#uhrzeit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUhrzeit(TimeintervalParser.UhrzeitContext ctx);
}
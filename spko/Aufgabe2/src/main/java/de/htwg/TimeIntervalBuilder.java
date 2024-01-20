package de.htwg;
import java.util.Stack;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
public class TimeIntervalBuilder extends TimeintervalParserBaseListener {

    private Stack<Timeinterval> stack = new Stack<Timeinterval>();

    public Timeinterval build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree); // Tiefensuche
        return this.stack.pop();
    }

    @Override
    public void exitUhrzeit(TimeintervalParser.UhrzeitContext ctx) {
        StringBuilder uhrzeit = new StringBuilder();
        if (ctx.getChildCount() >= 1) {
            for(int i = 0; i < ctx.getChildCount(); i++) {
                uhrzeit.append(ctx.getChild(i).getText());
            }
            this.stack.push(new Uhrzeit(uhrzeit.toString()));
        }
    }

    @Override
    public void exitTimeinterval(TimeintervalParser.TimeintervalContext ctx) {
        if (ctx.getChildCount() == 5) {
            Timeinterval uhrzeit2 = this.stack.pop();
            String ws1 = ctx.getChild(1).getText();
            String until = ctx.getChild(2).getText();
            String ws2 = ctx.getChild(3).getText();
            Timeinterval uhrzeit1 = this.stack.pop();
            this.stack.push(new TimeintervalTimeSpan((Uhrzeit) uhrzeit1, ws1, until, ws2, (Uhrzeit) uhrzeit2));
        }
    }



}

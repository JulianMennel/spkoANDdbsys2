package de.htwg;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.sql.Time;
import java.util.Scanner;

public class TimeintervalToAst {

    private TimeintervalToAst() {

    }
    //10:00 p.m. - 11:00 p.m.
    //10:00 p.m. - 10:00 p.m.
    //10:00 p.m. - 9:00 p.m.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TimeintervalLexer lexer = new TimeintervalLexer(CharStreams.fromString(scan.nextLine()));
        TimeintervalParser parser = new TimeintervalParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.timeinterval();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.printf("%d error(s) detected%n",
                    parser.getNumberOfSyntaxErrors());
            System.exit(1);
        }

        Timeinterval ast = new TimeIntervalBuilder().build(tree);
        System.out.printf("Tree:  \"%s\"%n", ast);

        TimeintervalTimeSpan timeintervalTimeSpan = (TimeintervalTimeSpan) ast;
        System.out.println("Put in the name of your activity");
        String name = scan.nextLine();
        timeintervalTimeSpan.protocol(name);
        scan.close();

    }
}

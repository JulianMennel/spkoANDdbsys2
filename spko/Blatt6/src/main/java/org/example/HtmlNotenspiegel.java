// HtmlNotenspiegel.java
package org.example;

import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.ST;
import java.io.File;
import java.io.FileWriter;

public final class HtmlNotenspiegel {
    private HtmlNotenspiegel() { }

    public static void main(String[] args) throws Exception {
        Fachnote[] fachnoten = new Fachnote[] {
                new Fachnote("Sprachkonzepte", 1.3),
                new Fachnote("Sprachkonzepte Uebungen", true)
        };

        ST templ = new STGroupFile("htmlnotenspiegel.stg", '$', '$').getInstanceOf("notenspiegel");
        templ.add("n", fachnoten);
        String result = templ.render();

        File myObj = new File("HtmlNotenspiegel.html");

        if(myObj.createNewFile()) {
            FileWriter myWriter = new FileWriter(myObj.getName());
            myWriter.write(result);
            myWriter.close();
        } else {
            myObj.delete();
            myObj.createNewFile();
            FileWriter myWriter = new FileWriter(myObj.getName());
            myWriter.write(result);
            myWriter.close();
        }
        //System.out.println(result);
    }
}

final class Fachnote {
    public final String fach;
    public final boolean benotet;
    public final String note;

    public Fachnote(String fach, double note) {
        this.fach = fach;
        this.benotet = true;
        this.note = String.format("%.1f", note);
    }

    public Fachnote(String fach, boolean bestanden) {
        this.fach = fach;
        this.benotet = false;
        this.note = bestanden ? "be" : "nb";
    }
}
package org.example;

import java.io.FileWriter;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.LinkedList;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;

public final class Generator {
    public static void main(String[] args) throws Exception {
        var list = new LinkedList<ClassInfo>();
        list.add(new ClassInfo(Class.forName("java.util.Iterator")));

        ST template = new STGroupFile("aufgabe6.stg",'$', '$').getInstanceOf("aufgabe6");
        template.add("list", list);

        String result = template.render();

        File myObj = new File("HtmlAufgabe6.html");

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

        System.out.println(result);
    }
}

final class ClassInfo {
    public final String name;
    public LinkedList<InterfaceInfo> interfaces;
    public boolean isInterface;

    public ClassInfo(Class<?> c) {
        this.name = c.getName();
        this.interfaces = new LinkedList<>();
        if (!c.isInterface()) {
            isInterface = true;
            for (var i : c.getInterfaces()) {
                var currentInterface = new InterfaceInfo(i.getName());

                for (var m : i.getMethods()) {
                    String str = m.getReturnType().getName() + " " + m.getName() + "(";
                    Parameter[] parameters = m.getParameters();
                    boolean hasParams = false;

                    for (Parameter parameter : parameters) {
                        str = str + parameter.getType().getName();
                        str = str + ", ";
                        hasParams = true;
                    }
                    if (hasParams) {
                        str = str.substring(0, str.length() - 2);
                    }
                    str = str + ")";
                    currentInterface.methods.add(str);
                }
                this.interfaces.add(currentInterface);
            }
        } else {
            isInterface = false;
            var currentInterface = new InterfaceInfo(null);
            for(var m : c.getMethods()) {
                String str = m.getReturnType().getName() + " " + m.getName() + "(";
                Parameter[] parameters = m.getParameters();
                boolean hasParams = false;

                for (Parameter parameter : parameters) {
                    str = str + parameter.getType().getName();
                    str = str + ", ";
                    hasParams = true;
                }
                if (hasParams) {
                    str = str.substring(0, str.length() - 2);
                }
                str = str + ")";
                currentInterface.methods.add(str);
            }
            this.interfaces.add(currentInterface);
        }
    }
}

final class InterfaceInfo {
    public final String name;
    public final LinkedList<String> methods;

    public InterfaceInfo(String name) {
        this.name = name;
        this.methods = new LinkedList<>();
    }
}

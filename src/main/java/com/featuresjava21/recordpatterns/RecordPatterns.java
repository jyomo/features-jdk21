package com.featuresjava21.recordpatterns;

import com.featuresjava21.utils.Utils;

public class RecordPatterns {

    /* Antes de java 16, se tiene escribir la verificaciòn de siempre
    * String s = (String) obj;
    * */
    public static void validateInstancePriorOfJava16(Object obj) {
        if (obj instanceof String) {
            String s = (String) obj;
            Utils.print(s);
        }
    }

    /* A partir de java 16, se eliminò esa lìnea
    y tuvo un cambio la condiciòn de instancia
    * Se agrega una variable
     * */
    public static void validateInstanceAsOfJava16(Object obj) {
        if (obj instanceof String s) {
            Utils.print(s);
        }
    }

    public record Point(int x, int y) {
    }
  /* A partir de java 16,
  *
   */
    public static void printSumClasicJava16(Object obj) {
        if (obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            Utils.print(x + y);
        }
    }
    /* A partir de java 21
     * extrae el valor de los componentes Point del x, y
     */
    public static void printSumAsOfJava21(Object obj) {

        if (obj instanceof Point(int x, int y)) {
            Utils.print(x + y);
        }
    }



    public enum Color { RED, GREEN, BLUE }

    /*
    * Desde Java 21.
    * Patrones de registros anidados.
    * se extrae componentes de objetos anidados.
    * */
    public record ColoredPoint(Point p, Color c) {}
    public record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}
    public static void printUpperLeftColoredPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint ul, ColoredPoint lr)) {
            Utils.print(ul.c());
        }
    }

    public static void printColorOfUpperLeftPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint(Point p, Color c),
                                   ColoredPoint lr)) {
            System.out.println(c);
        }
    }

    public static void printXCoordOfUpperLeftPointWithPatterns(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint(Point(var x, var y), var c),  var lr)) {
            System.out.println("Upper-left corner: " + x);
        }
    }


}

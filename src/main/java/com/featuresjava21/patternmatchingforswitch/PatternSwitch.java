package com.featuresjava21.patternmatchingforswitch;

import com.featuresjava21.utils.*;


public class PatternSwitch {


    /**
     * 01 a. Antes de Java 21: encadenados if-else con instanceof
     */
    public static String formatterPriorOfJava21(Object obj) {

        String formatted = "unknown";
        if (obj instanceof Integer i) {
            formatted = String.format("int: %d", i);
        } else if (obj instanceof Long l) {
            formatted = String.format("long: %d", l);
        } else if (obj instanceof Double d) {
            formatted = String.format("double: %f", d);
        } else if (obj instanceof String s) {
            formatted = String.format("String: %s", s);
        }
        return formatted;
    }


    /**
     * 01 b. Con Java 21 - Permite labels case con patrones
     * Ejemplo de un Patròn: Integer i
     */
    public static String formatterSwitchForAnyType(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int: %d", i);
            case Long l -> String.format("long: %d", l);
            case Double d -> String.format("double: %f", d);
            case String s -> String.format("String: %s", s);
            default -> obj.toString();
        };
    }


    /**
     * 02 a. Antes de Java 21 , lanza NullPointerException si
     * la expresión del selector se evalúa como nula
     */
    public static void evaluateSwitchAndNullClassicExpression(String s) {
        if (s == null) {
            Utils.print("Oops clásico!");
            return;
        }
        switch (s) {
            case "Foo", "Bar" -> Utils.print("Foo Barr Great");
            default -> Utils.print("Ok");
        }
    }

    /**
     * 02 b. Java 21. Permite evaluar Null como label Case.
     */
    public static void evaluateSwitchAndNullExpressionInJava21(String s) {
        switch (s) {
            case null -> System.out.println("Oops!!!!");
            case "Foo", "Bar" -> System.out.println("Great");
            default -> System.out.println("Ok");
        }
    }

    /* java 21
    Los Label case del patrón se puede aplicar a
     *muchos valores y a condicionales.
     */
    public static void testStringOld(String response) {
        switch (response) {
            case null -> {
            }
            case String s -> {
                if (s.equalsIgnoreCase("YES"))
                    System.out.println("You got it");
                else if (s.equalsIgnoreCase("NO"))
                    System.out.println("Shame");
                else
                    System.out.println("Sorry?");
            }
        }
    }

    /*
     * * con Java 21 Refinamiento de Casos
     * con guardia;
     * -1 permiten agregar condiciones adicionales
     *   -> Esto mejora la claridad y mantenibilidad del código
     * -2 también puede combinarse con valores constantes
     *   -> facilita aún más la simplificación de la lógica condicional:
     * */
    public static void testStringEnhanced(String response) {
        switch (response) {
            case null -> {
            }
            case "y", "Y" -> {
                System.out.println("You got it");
            }
            case "n", "N" -> {
                System.out.println("Shame");
            }
            case String s when s.equalsIgnoreCase("YES") -> {
                System.out.println("You got it");
            }
            case String s when s.equalsIgnoreCase("NO") -> {
                System.out.println("Shame");
            }
            case String s -> {
                System.out.println("Sorry?");
            }
        }
    }

    /**
     * revisar
     */

    sealed public interface CardClassification permits Suit, Tarot {}
    public enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS, SPADES }
    final class Tarot implements CardClassification {}

//    static void exhaustiveSwitchWithoutEnumSupport(CardClassification c) {
//        switch (c) {
//            case Suit s when s == Suit.CLUBS -> {
//                System.out.println("It's clubs");
//            }
//            case Suit s when s == Suit.DIAMONDS -> {
//                System.out.println("It's diamonds");
//            }
//            case Suit s when s == Suit.HEARTS -> {
//                System.out.println("It's hearts");
//            }
//            case Suit s -> {
//                System.out.println("It's spades");
//            }
//            case Tarot t -> {
//                System.out.println("It's a tarot");
//            }
//        }
//    }

    // Dede Java 21 - Switch mejorado con enum (pasando un interfaz)
    public static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
        switch (c) {
            case Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit.SPADES -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
        }
    }

    //Swtich con enums (pasando directamente enum)
    public static int selectorWithLambdaforEnumsCases(Days days) {
        return switch (days) {
            case LUNES -> 1;
            case MARTES -> 2;
            case MIERCOLES -> 3;
            case JUEVES -> 4;
            case null, default -> 0;
        };
    }

    /**
     *
     */
    public static String selectionWithInstancesCases(User user) {
        return switch (user) {
            case Admin a -> "Clase Admin";
            case Client c -> "Clase Client";
            case null, default -> "Clase no soportada";
        };

    }

}



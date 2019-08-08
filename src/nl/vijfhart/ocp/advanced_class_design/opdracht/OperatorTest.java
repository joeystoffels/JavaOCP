package nl.vijfhart.ocp.advanced_class_design.opdracht;

/*
Maak een enum Operator in de package enums met de namen PLUS, KEER, MIN en GEDEELD_DOOR.
Een Operator heeft een String naam (+, x, - of /), en een BinaryOperator<Double>  bo die aangeeft wat de operator doet.

Maak ook een class OperatorTest, waarin de enum Operator wordt gebruikt in een method static void bereken(double a, Operator o, double b).
Als in de main() method de volgende aanroep staat:

bereken (4, PLUS, 5);

geeft dat de volgende uitvoer:
4.0 + 5.0 = 9.0

Tip: maak gebruik van een static import in OperatorTest
*/

import java.util.function.BinaryOperator;

class OperatorTest {

    public static void main(String... args) {
        System.out.println(bereken(4, Operator.PLUS, 5));
    }

    public static double bereken(double a, Operator o, double b) {
        return o.getBo().apply(a, b);
    }

    enum Operator {

        PLUS("+", (a, b) -> a + b),
        KEER("x", (a, b) -> a * b),
        MIN("-", (a, b) -> a - b),
        GEDEELD_DOOR("/", (a, b) -> a / b);

        private final String symbol;
        private final BinaryOperator<Double> bo;

        Operator(String symbol, BinaryOperator<Double> bo) {
            this.symbol = symbol;
            this.bo = bo;
        }

        String getSymbol() {
            return symbol;
        }

        BinaryOperator<Double> getBo() {
            return bo;
        }
    }

}

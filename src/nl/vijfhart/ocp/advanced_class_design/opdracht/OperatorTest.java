package nl.vijfhart.ocp.advanced_class_design.opdracht;

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

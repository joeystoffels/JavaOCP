package nl.vijfhart.ocp.advanced_class_design.uitwerking;

import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MIN("-", (a, b) -> a - b),
    KEER("x", (a, b) -> a * b),
    GEDEELD_DOOR("/", (a, b) -> a / b);

    private final String name;
    private final BinaryOperator<Double> bo;

    Operator(String name, BinaryOperator<Double> bo) {
        this.name = name;
        this.bo = bo;
    }

    public String toString() {
        return name;
    }

    public BinaryOperator<Double> getOperator() {
        return bo;
    }
}

package nl.vijfhart.ocp.advanced_class_design.uitwerking;

import static nl.vijfhart.ocp.advanced_class_design.uitwerking.Operator.PLUS;

class OperatorTest {

    public static void main(String args[]) {
        bereken(4, PLUS, 5);
    }

    public static void bereken(double a, Operator o, double b) {
        System.out.println(a + " " + o + " " + b + " = " +
                o.getOperator().apply(a, b));
    }
}

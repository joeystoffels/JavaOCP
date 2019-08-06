package nl.vijfhart.ocp.java_clazz_design.uitwerking;

public class LijnApp {

    public static void main(String args[]) {
        Punt a = new Punt(1, 2);
        Punt b = new Punt(3, 4);
        Lijn lijn = Lijn.getLijn(a, b);
        a.setX(20);
        lijn = lijn.getLijn(a, b);
        lijn.getP2().setX(10);
        System.out.println(a);
        System.out.println(lijn);
    }

}

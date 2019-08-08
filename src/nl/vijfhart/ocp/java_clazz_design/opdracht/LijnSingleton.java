package nl.vijfhart.ocp.java_clazz_design.opdracht;

/*
Een Lijn heeft twee punten. Punt heeft voor de x- en y- coördinaten getters en setters. Lijn zelf is immutable gemaakt (zie class_design\opdrachten\Lijn.java):
Zorg ervoor dat Lijn een singleton wordt. Kies zelf voor één van de strategieën.
*/

import nl.vijfhart.ocp.java_clazz_design.uitwerking.Lijn;
import nl.vijfhart.ocp.java_clazz_design.uitwerking.Punt;

final class LijnSingleton {

    private static LijnSingleton instance;

    private final Punt p1, p2;

    private LijnSingleton(Punt p1, Punt p2) {
        this.p1 = new Punt(p1.getX(), p1.getY());
        this.p2 = new Punt(p2.getX(), p2.getY());
    }

    public static LijnSingleton getInstance(Punt p1, Punt p2) {
        if (instance == null) {
            synchronized (Lijn.class) {
                if (instance == null) {
                    instance = new LijnSingleton(p1, p2);
                }
            }
        }
        return instance;
    }

    public Punt getP1() {
        return new Punt(p1.getX(), p1.getY());
    }

    public Punt getP2() {
        return new Punt(p2.getX(), p2.getY());
    }

}

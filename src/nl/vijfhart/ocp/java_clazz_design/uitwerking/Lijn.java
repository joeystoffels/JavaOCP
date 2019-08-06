package nl.vijfhart.ocp.java_clazz_design.uitwerking;

public final class Lijn {

    private static Lijn lijn;
    private final Punt p1, p2;

    private Lijn(Punt p1, Punt p2) {
        this.p1 = new Punt(p1.getX(), p1.getY());
        this.p2 = new Punt(p2.getX(), p2.getY());
    }

    public static Lijn getLijn(Punt p1, Punt p2) {
        if (lijn == null) {
            synchronized (Lijn.class) {
                if (lijn == null) {
                    lijn = new Lijn(p1, p2);
                }
            }
        }
        return lijn;
    }

    public Punt getP1() {
        return new Punt(p1.getX(), p1.getY());
    }

    public Punt getP2() {
        return new Punt(p2.getX(), p2.getY());
    }

    public String toString() {
        return "[" + p1.toString() + "-" + p2.toString() + "]";
    }

}

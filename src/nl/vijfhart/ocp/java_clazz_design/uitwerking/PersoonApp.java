package nl.vijfhart.ocp.java_clazz_design.uitwerking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PersoonApp {

    public static void main(String args[]) {
        List<String> namenLijst = new ArrayList<>(Arrays.asList("Piet", "Puk"));
        Persoon persoon = new Persoon(namenLijst);
        List<String> namen = persoon.getNamen();
        namen.add("Test"); // UnsupportedOperationException
        namenLijst.add("Test");
        System.out.println(persoon.getNamen()); // blijft ["Piet", "Puk"]
    }

}

package nl.vijfhart.ocp.java_clazz_design.opdracht;

import java.util.Arrays;

/*
Een class Persoon heeft een attribuut namen van het type List<String>.
Zorg ervoor dat de namen van een Persoon altijd benaderd kunnen worden, en dat Persoon immutable is.
Test deze class in een applicatie PersoonApp.
*/

public class PersoonApp {

    public static void main(String... args) {
        Persoon p = new Persoon(Arrays.asList("Henk", "Jan"));
    }

}

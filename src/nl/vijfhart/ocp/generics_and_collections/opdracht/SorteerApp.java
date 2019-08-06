package nl.vijfhart.ocp.generics_and_collections.opdracht;

import java.util.Arrays;

class SorteerApp {

    private static Integer[] getallen = new Integer[5];

    public static void main(String... args) {

        Arrays.setAll(getallen, (i) -> i * 2);

        for (int getal : getallen) {
            System.out.println(getal);
        }

        Arrays.sort(getallen, (a, b) -> b.compareTo(a));

        for (int getal : getallen) {
            System.out.println(getal);
        }
    }

}

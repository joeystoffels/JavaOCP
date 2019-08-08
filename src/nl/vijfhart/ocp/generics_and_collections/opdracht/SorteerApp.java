package nl.vijfhart.ocp.generics_and_collections.opdracht;

/*
Deze opdracht is deels bedoeld als herhaling van het gebruik van lambda expressies, en bereidt voor op een vervolgopdracht in het volgende hoofdstuk.

Maak een applicatie SorteerApp. Deze maakt de Integer array “getallen” met een opgegeven lengte.
Vul de array met even getallen via de method setAll() van de class java.util.Arrays.
Deze method vult de array met waarden die zijn afgeleid van de array index (zie verder de API documentatie).
Sorteer daarna de array met de sort() method van Arrays van groot naar klein.
Gebruik voor het vullen en sorteren lambda expressies. Toon tot slot de inhoud van de array.
 */

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

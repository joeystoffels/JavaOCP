package nl.vijfhart.ocp.streams.opdracht;

/*
Bij de opdrachten van het vorige hoofdstuk is de applicatie SorteerApp gemaakt (gebruik eventueel streams\opgaven\Opgave1.java).

Vul deze applicatie als volgt aan:
Wijzig de inhoud van de Integer array getallen: maak van alle even getallen tientallen, door ze met 5 te vermenigvuldigen.
Maak gebruik van een stream op de array die de elementen doorloopt, de wijziging daarop doorvoert, en de stream als Integer array terug geeft.
Doorloop de gewijzigde inhoud van de array als een stream en toon de waarde van elk element.
 */

import java.util.Arrays;
import java.util.stream.Collectors;

public class SorteerAppStreams {

    static Integer[] getallen = new Integer[5];

    public static void main(String... args) {

        Arrays.setAll(getallen, (i) -> i * 2);
        printGetallen();

        getallen = Arrays.stream(getallen).map(x -> x * 5).toArray(Integer[]::new);
        printGetallen();

        Arrays.sort(getallen, (a, b) -> b.compareTo(a));
        printGetallen();

    }

    private static void printGetallen() {
        System.out.println(Arrays.stream(getallen).collect(Collectors.toList()));
        Arrays.stream(getallen).forEach(System.out::println);
    }

}

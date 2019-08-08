package nl.vijfhart.ocp.streams.opdracht;

/*
Maak een applicatie WoordenApp, die alle woorden die worden meegegeven met komma’s gescheiden op het scherm toont.
Maak daarbij gebruik van collect() en joining(). Geef de woorden gesorteerd weer op volgorde van lengte, en daarbinnen op alfabetische volgorde.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WoordenApp {

    public static void main(String... args) {
        Comparator<String> compareAlfabetic = (a, b) -> a.compareTo(b);
        Comparator<String> compareLength = (a, b) -> a.length() - b.length();

        String result = Arrays.stream(args).sorted(compareLength.thenComparing(compareAlfabetic)).collect(Collectors.joining(", "));

        System.out.println(result);
    }

}

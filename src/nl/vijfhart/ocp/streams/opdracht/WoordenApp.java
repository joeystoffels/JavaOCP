package nl.vijfhart.ocp.streams.opdracht;

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

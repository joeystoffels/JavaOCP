package nl.vijfhart.ocp.streams.opdracht;

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

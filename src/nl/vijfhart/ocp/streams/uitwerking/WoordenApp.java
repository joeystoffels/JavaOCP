package nl.vijfhart.ocp.streams.uitwerking;

import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.joining;

public class WoordenApp {

    public static void main(String args[]) {
        String woorden =
                Stream.of(args)
                        /* .sorted((a,b)->a.length()<b.length()?-1:
                                          a.length()>b.length()?1:
                                          a.compareTo(b)) */
                        .sorted(comparing(String::length)
                                .thenComparing(naturalOrder()))
                        .collect(joining(", "));
        System.out.println(woorden);
    }

}

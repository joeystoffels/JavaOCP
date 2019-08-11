package nl.vijfhart.ocp.streams.uitwerking;

import java.util.Comparator;
import java.util.stream.Stream;

public class LetterApp {

    public static void main(String... args) {
        String woord = Stream.of(args)
                .filter(s ->
                        s.chars()
                                .distinct()
                                .count() == s.length())
                .max((s1, s2) -> s1.length() - s2.length())
                // .max(Comparator.comparingInt(String::length))
                .orElse("niet gevonden");
        System.out.println(woord);
    }

}

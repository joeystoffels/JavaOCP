package nl.vijfhart.ocp.streams.opdracht;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FaculteitApp {

    public static void main(String... args) {
        int input = 5;

        OptionalInt optionalInt = IntStream.iterate(1, x -> x + 1).limit(input).reduce((x, y) -> x * y);

        System.out.println(optionalInt.getAsInt());
    }

}

package nl.vijfhart.ocp.streams.opdracht;

/*
De faculteit van een getal wordt berekend door alle getallen van 1 t/m het opgegeven getal met elkaar te vermenigvuldigen.
Zo is de faculteit van 4 gelijk aan 24, want 1x2x3x4=24.

Maak een applicatie FaculteitApp die de faculteit van een opgegeven waarde berekent en op het scherm toont.
Maak daarin gebruik van iterate() om de getallen 1 t/m n te genereren, limit() om bij n te eindigen, en reduce om elk element met het volgende te vermenigvuldigen.
 */

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FaculteitApp {

    public static void main(String... args) {
        int input = 5;

        OptionalInt optionalInt = IntStream.iterate(1, x -> x + 1).limit(input).reduce((x, y) -> x * y);

        System.out.println(optionalInt.getAsInt());
    }

}

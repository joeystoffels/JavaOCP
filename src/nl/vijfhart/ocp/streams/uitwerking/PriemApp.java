package nl.vijfhart.ocp.streams.uitwerking;

/*
Maak een applicatie PriemApp dat van een opgegeven getal n het n-de
priemgetal toont. Tips:
• Maak een LongStream getallen vanaf 2 (het eerste priemgetal), die steeds met 1 wordt
opgehoogd.
• Start in een filter voor elk gegenereerd getal x een nieuwe LongStream vanaf 2 met als
lengte de wortel van x. De filter geeft true als x door geen van de getallen van deze stream
deelbaar is, en als x zelf geen 2 is. Gebruik hierbij de method noneMatch().
• Limiteer het aantal priemgetallen tot n
Sla n-1 priemgetallen over
 */

import java.util.stream.LongStream;

public class PriemApp {

    public static void main(String... args) {
        long n = Long.parseLong(args[0]);
        long priem = LongStream.iterate(2, x -> x + 1)
                .filter(i -> LongStream.iterate(2, x -> x + 1)
                        .limit((long) Math.sqrt(i))
                        .noneMatch(x -> i != 2 && i % x == 0))
                .limit(n)
                .skip(n - 1)
                .findFirst()
                .orElse(-1);
        System.out.println(priem);
    }

}

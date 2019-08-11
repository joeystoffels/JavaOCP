package nl.vijfhart.ocp.streams.uitwerking;

/*
Maak een applicatie die de faculteit van 100 berekent (1 * 2 * 3 … * 100). Maak daarbij
gebruik van een parallelle stream en een zelf gemaakte Collector. Tips:
• Laat een IntStream lopen van 1 t/m 100
• De faculteit van 100 is groter dan in een long past. Gebruik daarom binnen de collector een
BigInteger object om de waarde bij te houden (java.math.BigInteger).
• Maak biinnen de stream gebruik van mapToObj om elke int naar een BigInteger om te
zetten.
• Toon uiteindelijk de berekende waarde als een String.
 */

import java.math.BigInteger;
import java.util.stream.IntStream;

class FacultyTest {
    public static void main(String args[]) {
        int input = Integer.parseInt(args[0]);
        String value = IntStream.rangeClosed(1, input)
                .parallel()
                .mapToObj(x -> new BigInteger("" + x))
                .collect(BigFaculty::new
                        , BigFaculty::multiply
                        , BigFaculty::combine)
                .toString();
        System.out.println(value);
    }
}


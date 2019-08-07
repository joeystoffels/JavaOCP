package nl.vijfhart.ocp.exceptions.uitwerking;

import java.util.stream.Stream;

public class BronApp {

    public static void main(String args[]) {
        try (Bron a = new Bron("a");
             Bron b = new Bron("b");
             Stream<Bron> stream = Stream.of(a, b)) {
            stream.onClose(() -> System.out.println("closing stream"))
                    .peek(Bron::open)
                    .map(Bron::toString)
                    .forEach(System.out::println);
        }
    }

}

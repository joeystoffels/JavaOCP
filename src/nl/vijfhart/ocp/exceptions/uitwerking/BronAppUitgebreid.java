package nl.vijfhart.ocp.exceptions.uitwerking;

import java.io.IOException;
import java.util.stream.Stream;

class BronAppUitgebreid {

    public static void main(String args[]) {
        try (BronUitgebreid a = new BronUitgebreid("a");
             BronUitgebreid b = new BronUitgebreid("b");
             Stream<BronUitgebreid> stream = Stream.of(a, b)) {
            stream.onClose(() -> System.out.println("closing stream"))
                    .peek(BronAppUitgebreid::openBron)
                    .map(BronUitgebreid::toString)
                    .forEach(System.out::println);
        } catch (Exception ioe) {
            System.err.println(ioe);
        } finally {
            System.out.println("stream closed");
        }
    }

    static void openBron(BronUitgebreid b) {
        try {
            b.open();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}

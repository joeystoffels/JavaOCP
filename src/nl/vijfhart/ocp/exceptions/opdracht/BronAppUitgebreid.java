package nl.vijfhart.ocp.exceptions.opdracht;

/*
Breid vorige opgave uit. Zorg ervoor dat open() en close() een IOException opleveren,
en dat bij het doorlopen van de stream bij het openen de IOException wordt omgezet in een RuntimeException.

Tips:
Gebruik een nieuwe method in BronApp die de IOException bij het openen van een bron afvangt en verpakt in een RuntimeException.
Zet het doorlopen van de stream in een exception handler met een multicatch die IOException en RuntimeException afvangt
 */

import java.io.IOException;
import java.util.stream.Stream;

public class BronAppUitgebreid {

    static void openBron(Bron bron) {
        try {
            bron.open();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String... args) {
        Runnable streamClose = () -> {
            System.out.println("closing stream");
        };

        try (Bron bronA = new Bron("a");
             Bron bronB = new Bron("b");
             Stream<Bron> stream = Stream.of(bronA, bronB).onClose(streamClose)) {

            try {
                stream.forEach(x -> openBron(x));
            } finally {
                stream.close();
            }

        } catch (RuntimeException | IOException e) {
            System.out.println("java.lang.RuntimeException: java.io.IOException: error while opening");
            System.out.println("stream closed");
        }

    }

    static class Bron implements AutoCloseable {

        private String name;
        private boolean closed;

        Bron(String name) {
            this.name = name;
        }

        public void open() throws IOException {
            System.out.println("opening " + name);
            throw new IOException();
        }

        public void close() throws IOException {
            if (closed) return;
            System.out.println("closing " + name);
            closed = true;
            throw new IOException();
        }

    }

}

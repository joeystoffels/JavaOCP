package nl.vijfhart.ocp.exceptions.opdracht;

import java.util.stream.Stream;

public class BronApp {

    public static void main(String... args) {
        Runnable streamClose = () -> {
            System.out.println("closing stream");
        };

        try (Bron bronA = new Bron("Bron A");
             Bron bronB = new Bron("Bron B");
             Stream<Bron> stream = Stream.of(bronA, bronB).onClose(streamClose)) {

            stream.forEach(Bron::open);
        }
    }

    static class Bron implements AutoCloseable {

        private String name;
        private boolean closed;

        Bron(String name) {
            this.name = name;
        }

        public void open() {
            System.out.println("opening " + name);
        }

        public void close() {
            if (closed) return;
            System.out.println("closing " + name);
            closed = true;
        }

    }

}

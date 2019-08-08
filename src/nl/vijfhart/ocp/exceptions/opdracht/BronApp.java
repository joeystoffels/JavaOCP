package nl.vijfhart.ocp.exceptions.opdracht;

/*
In de voorbeelden bij dit hoofdstuk werden varianten van een class Bron gebruikt.
Maak in een class BronApp een Stream aan van twee Bron objecten en doorloop deze stream,
waarbij de bronnen geopend worden. Stream is zelf ook AutoCloseable.
Toon d.m.v. ARM aan dat ook de close() van Stream automatisch wordt gesloten.

Tip:
gebruik de onClose() method van BaseStream. Hieraan moet een functional interface worden
meegegeven: bepaal aan de hand van de signatuur van de method van deze interface wat voor
lambda-expressie in de onClose() method kan worden meegegeven.
 */

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

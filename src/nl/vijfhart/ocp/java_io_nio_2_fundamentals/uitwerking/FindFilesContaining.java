package nl.vijfhart.ocp.java_io_nio_2_fundamentals.uitwerking;

/*
 Maak een applicatie FindFilesContaining, die binnen de huidige directory zoekt
naar bestanden die een opgegeven tekst bevatten. Toon de bestandsnamen en de
gevonden regels.

 */

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FindFilesContaining {

    public static void main(String args[]) throws IOException {
        Files.list(Paths.get("."))
                .filter(p -> hasMatch(p, args[0]))
                .forEach(p -> showMatch(p, args[0]));
    }

    static boolean hasMatch(Path p, String text) {
        try {
            return Files.lines(p)
                    .anyMatch(s -> s.contains(text));
        } catch (IOException | UncheckedIOException ioe) {
            return false;
        }
    }

    static void showMatch(Path p, String text) {
        try {
            Files.lines(p)
                    .filter(s -> s.contains(text))
                    .forEach(s -> System.out.println(
                            String.format("%-30s", p.getFileName()) + ": " + s));
        } catch (IOException e) {
        }
    }

}

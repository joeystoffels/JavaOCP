package nl.vijfhart.ocp.java_io_nio_2_fundamentals.uitwerking;

/*
Maak met behulp van java.nio een applicatie NewDirsApp, die het volgende doet:
• Maak een Path "new" aan
• Maak daarvan een subdirectory van de huidige directory
• Maak een Path "a/b/c/" aan
• Plaats dat Path onder new m.b.v. resolve
• Maak alle onderliggende subdirectories aan.
• optioneel: Verwijder alle directories met behulp van Files.walk(...)
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

class NewDirsApp {

    public static void main(String args[]) throws Exception {
        Path newDir = Paths.get("new");
        Path dirs = Paths.get("a/b/c/d");

        if (!Files.exists(newDir))
            newDir = Files.createDirectory(newDir);

        dirs = newDir.resolve(dirs);
        System.out.println("resultaat van resolve: " + dirs);

        if (!Files.exists(dirs))
            dirs = Files.createDirectories(dirs);

        System.out.println("aangemaakt: " + dirs);

        Files.walk(newDir)
                .filter(p -> p.toFile().isDirectory())
                .sorted(Comparator.reverseOrder())
                .forEach(p -> delete(p));
    }

    static void delete(Path p) {
        try {
            Files.deleteIfExists(p);
            System.out.println("verwijderd: " + p);
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }

}

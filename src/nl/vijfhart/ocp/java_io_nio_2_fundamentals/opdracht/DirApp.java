package nl.vijfhart.ocp.java_io_nio_2_fundamentals.opdracht;

/*
Maak een programma DirApp die in de huidige directory de volgende directorystructuur maakt.

./a/b/c/d

Toon deze structuur als het aanmaken is gelukt.
Verwijder daarna met behulp van dezelfde applicatie de gehele directory structuur weer.

Tip: een directory kan alleen worden verwijderd als het leeg is.
 */

import java.io.File;

public class DirApp {

    public static void main(String... args) {
        File file = new File(".\\a\\b\\c\\d");
        file.mkdirs();

        System.out.println("created: " + file.getAbsolutePath());

        while (file.getParentFile() != null) {
            File newFile = file.getParentFile();
            file.delete();
            file = newFile;
        }

        System.out.println("removed: " + file.getAbsolutePath());
    }

}

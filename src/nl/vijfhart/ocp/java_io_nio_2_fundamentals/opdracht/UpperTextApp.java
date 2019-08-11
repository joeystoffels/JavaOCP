package nl.vijfhart.ocp.java_io_nio_2_fundamentals.opdracht;

/*
Maak een applicatie UpperTextApp die een opgegeven tekstbestand inleest,
en naar een opgegeven nieuw bestand wegschrijft. De inhoud van het nieuwe
bestand dient daarna in hoofdletters te staan.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class UpperTextApp {

    private final static File lowerCaseFile = new File("lowercasetext.txt");
    private final static File upperCaseFile = new File("uppercasetext.txt");

    public static void main(String... args) {
        initLowerCaseFile(lowerCaseFile);
        readFromFile(lowerCaseFile).stream().forEach(System.out::println);
        writeToFile(upperCaseFile, convertToUpperCase(lowerCaseFile));
        readFromFile(upperCaseFile).stream().forEach(System.out::println);
    }

    private static void initLowerCaseFile(File file) {
        List<String> lines = new ArrayList<>();

        for (int x = 0; x < 10; x++) {
            lines.add("lijn " + x);
        }

        writeToFile(file, lines);
    }

    private static List<String> convertToUpperCase(File origin) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(lowerCaseFile.toPath());
            lines.replaceAll(String::toUpperCase);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    private static void writeToFile(File file, List<String> lines) {
        try (FileOutputStream fos = new FileOutputStream(file);
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(osw)) {

            lines.stream().forEach((x) -> writeLine(bw, x));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> readFromFile(File file) {
        List<String> lines = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            br.lines().forEach(x -> lines.add(x));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    private static void writeLine(BufferedWriter bw, String line) {
        try {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

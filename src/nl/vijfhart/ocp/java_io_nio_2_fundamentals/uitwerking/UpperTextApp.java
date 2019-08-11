package nl.vijfhart.ocp.java_io_nio_2_fundamentals.uitwerking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class UpperTextApp {

    public static void main(String... args) throws Exception {
        File input = new File(args[0]);

        if (!input.exists()) {
            throw new IllegalArgumentException("bestand bestaat niet");
        }

        File output = new File(args[1]);
        output.createNewFile();

        try (FileReader fr = new FileReader(input);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(output);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            String regel;

            while ((regel = br.readLine()) != null) {
                System.out.println(regel);
                regel = regel.toUpperCase();
                pw.println(regel);
            }
            pw.flush();
        }

    }
}

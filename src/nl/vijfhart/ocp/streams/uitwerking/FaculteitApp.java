package nl.vijfhart.ocp.streams.uitwerking;

import java.util.stream.LongStream;

public class FaculteitApp {

    public static void main(String args[]) {
        long faculteit = LongStream.iterate(1, x -> x + 1)
                .limit(Integer.parseInt(args[0]))
                .reduce(1, (x, y) -> x * y);
        System.out.println(faculteit);
    }

}

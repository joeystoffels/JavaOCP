package nl.vijfhart.ocp.streams.uitwerking;

import java.util.Arrays;
import java.util.stream.Stream;

public class SorteerAppStreams {

    public static void main(String args[]) {
        Integer[] getallen = new Integer[Integer.parseInt(args[0])];
        Arrays.setAll(getallen, i -> i * 2);
        Arrays.sort(getallen, (a, b) -> b > a ? 1 : b < a ? -1 : 0);
        System.out.println(Arrays.toString(getallen));

        getallen = Stream.of(getallen)
                .map(x -> x * 5)
                .toArray(Integer[]::new);

        Stream.of(getallen)
                .forEach(System.out::println);

    }

}

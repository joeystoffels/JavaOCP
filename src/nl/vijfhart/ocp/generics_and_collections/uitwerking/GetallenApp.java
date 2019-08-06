package nl.vijfhart.ocp.generics_and_collections.uitwerking;

import java.util.ArrayList;
import java.util.List;

class GetallenApp {

    public static void main(String args[]) {

        List<Integer> lijst = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            lijst.add(i);
        }

        lijst.removeIf(x -> x % 2 == 0);
        lijst.replaceAll(x -> x * 2);
        lijst.forEach(System.out::println);
    }

}

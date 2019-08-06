package nl.vijfhart.ocp.generics_and_collections.uitwerking;

import java.util.Map;
import java.util.TreeMap;

class MapApp {

    public static void main(String args[]) {
        Map<Integer, String> map = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();

        for (String s : args) {
            map.merge(s.length(), s, (a, b) -> a.compareTo(b) > 0 ? a : b);
            map2.compute(s.length(), (a, b) -> b == null ? 1 : b + 1);
        }

        for (int i = 1; i < 30; i++) {
            map.computeIfPresent(i, (a, b) -> map2.get(a) == 1 ? null : b);
        }

        map.forEach((a, b) -> System.out.printf("%s: %s%n", a, b));
    }

}

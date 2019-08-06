package nl.vijfhart.ocp.generics_and_collections.opdracht;

import java.util.HashMap;
import java.util.Map;

class MapApp {

    public static void main(String... args) {
        Map<Integer, String> map = new HashMap<>();

        for (String arg : args) {
            map.merge(arg.length(), arg, (x, y) -> x.compareTo(y) > 0 ? x : y);
        }

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

}

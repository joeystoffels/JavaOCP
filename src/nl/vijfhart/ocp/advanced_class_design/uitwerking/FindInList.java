package nl.vijfhart.ocp.advanced_class_design.uitwerking;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class FindInList {

    public static void main(String args[]) {
        List<String> list = Arrays.asList(args);
        System.out.println(find(list, new Predicate<String>() {
            public boolean test(String s) {
                return s.length() > 3;
            }
        }));
        System.out.println(find(list, s -> s.length() > 3));

    }

    public static <T> T find(List<T> list, Predicate<T> p) {
        for (T t : list) {
            if (p.test(t)) {
                return t;
            }
        }
        return null;
    }
}

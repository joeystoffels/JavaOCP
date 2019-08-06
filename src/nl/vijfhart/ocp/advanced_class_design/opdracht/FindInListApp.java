package nl.vijfhart.ocp.advanced_class_design.opdracht;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FindInListApp {

    static <T> T find(List<T> list, Predicate<T> filter) {
        for (T item : list) {
            if (filter.test(item)) {
                return item;
            }
        }
        return null;
    }

    public static void main(String... args) {
        System.out.println(find(Arrays.asList(args), arg -> arg.length() > 3));

        System.out.println(find(Arrays.asList(args),
                new Predicate<String>() {
                    @Override
                    public boolean test(String t) {
                        if (t.length() > 3) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
        ));
    }

}

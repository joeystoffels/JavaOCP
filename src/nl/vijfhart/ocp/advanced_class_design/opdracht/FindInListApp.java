package nl.vijfhart.ocp.advanced_class_design.opdracht;

/*
Maak een applicatie FindInList met een method static<T> T find(List<T>  list, Predicate<T> filter  )
Deze method geeft het eerste element uit de list die voldoet aan de Predicate, of anders null.

Zoek met behulp van deze find() methode in een list met woorden naar het eerste woord van meer dan 3 letters.
Doe dit eerst met een anonieme inner class die Predicate implementeert en vervolgens met een Lambda expressie.
 */

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

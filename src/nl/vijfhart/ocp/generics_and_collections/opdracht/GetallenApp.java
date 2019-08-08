package nl.vijfhart.ocp.generics_and_collections.opdracht;

/*
Maak een applicatie GetallenApp en vul daarin een List met de getallen 1 t/m 10.
Gebruik daarna de method removeIf() van Collection om de even getallen te verwijderen.
Gebruik vervolgens replaceAll() van List om de overgebleven getallen te verdubbelen.
Toon na afloop alle waarden met forEach().
 */

import java.util.ArrayList;
import java.util.List;

public class GetallenApp {

    static List<Integer> list = new ArrayList<>();

    public static void main(String... args) {

        for (int x = 1; x <= 10; x++) {
            list.add(x);
        }

        list.removeIf((x) -> x % 2 == 0);
        printList();

        list.replaceAll((x) -> x * 2);
        printList();

    }

    static void printList() {
        list.forEach(System.out::println);
    }

}


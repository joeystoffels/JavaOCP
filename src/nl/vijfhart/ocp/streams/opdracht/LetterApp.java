package nl.vijfhart.ocp.streams.opdracht;

/*
Maak een applicatie LetterApp die van de opgegeven woorden alleen de woorden toont waarin
elke letter maar één keer voorkomt (zoals problematisch en nachtverblijf). Extra
uitdaging: toon alleen het langste gevonden woord, en anders de melding: “niet gevonden”.
Maak daarvoor gebruik van de functie max().
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LetterApp {

    public static void main(String... args) {
        List<String> distinctLetterWords = getOnlyDifferentLetterWords(Arrays.asList(args));
        Comparator<String> comp = (a, b) -> Integer.compare(a.length(), b.length());
        Optional<String> max = distinctLetterWords.stream().max(comp);

        if (!distinctLetterWords.isEmpty()) {
            System.out.println("langste woord:" + max.get());
        } else {
            System.out.println("niet gevonden");
        }
    }

    private static List<String> getOnlyDifferentLetterWords(List<String> words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            long distinctCount = word.chars().distinct().count();

            if (distinctCount == word.length()) {
                result.add(word);
            }
        }

        return result;
    }

}

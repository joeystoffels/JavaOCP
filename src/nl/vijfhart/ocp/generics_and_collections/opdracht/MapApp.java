package nl.vijfhart.ocp.generics_and_collections.opdracht;

/*
Maak een applicatie MapApp die zal worden aangeroepen met een reeks woorden.
In de applicatie wordt een Map met Integer keys en String values gevuld.
De keys worden gevormd door de lengtes van de opgegeven woorden.
De values zijn de woorden zelf. Als er meerdere woorden met dezelfde lengte worden meegegeven,
worden alfabetisch kleinere woorden vervangen door alfabetisch grotere woorden.
Toon na afloop de key-value paren in de Map.

Tips:
gebruik van merge() bij het vullen van de (eerste) map
Strings zijn Comparable: gebruik compareTo() in de BiFunction voor het bepalen van de value
gebruik forEach() voor het tonen van de key-value paren.

Optioneel:
Vul een tweede map met per lengte het aantal woorden van die lengte.
Lengtes die slechts één keer voor blijken te komen worden uit de eerste map verwijderd.
Maak voor het tellen van de voorkomende lengtes gebruik van compute().
Voor het verwijderen kan computeIfPresent() worden gebruikt in een for loop, waarbij
mogelijke woordlengtes van 1 t/m 30 worden gecontroleerd.
 */

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

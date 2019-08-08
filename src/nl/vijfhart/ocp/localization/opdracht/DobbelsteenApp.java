package nl.vijfhart.ocp.localization.opdracht;

/*
Maak een applicatie Dobbelsteen die tien keer met een dobbelsteen gooit.
Geef elke keer het gegooide aantal ogen in de opgegeven taal (bijvoorbeeld Nederlands of Engels).
Maak daarbij gebruik van een method ints() van java.util.Random.
 */

import java.util.Random;
import java.util.ResourceBundle;

public class DobbelsteenApp {

    public static void main(String... args) {

        String localeInput = args[0];
        ResourceBundle bundle;

        if (localeInput.equals("nl")) {
            bundle = ResourceBundle.getBundle("Greeting_nl");
        } else if (localeInput.equals("en")) {
            bundle = ResourceBundle.getBundle("Greeting_en");
        } else {
            throw new RuntimeException();
        }

        new Random().ints(10, 1, 6).forEach(x -> System.out.println(bundle.getString("" + x)));

    }

}

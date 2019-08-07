package nl.vijfhart.ocp.localization.opdracht;

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

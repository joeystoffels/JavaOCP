package nl.vijfhart.ocp.localization.uitwerking;

//Maak enkele Dobbelsteen_en.properties, Dobbelsteen_nl.properties en Dobbelsteen.properties aan met vergelijkbare inhoud:
//        1=one
//        2=two
//        3=three
//        4=four
//        5=five
//        6=six

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

class DobbelsteenApp {

    public static void main(String args[]) {
        Locale locale = args.length == 0 ? Locale.getDefault() :
                new Locale(args[0].toLowerCase());
        ResourceBundle bundle = ResourceBundle.getBundle("Dobbelsteen", locale);

        new Random()
                .ints(10, 1, 7)
                .mapToObj(Integer::toString)
                .map(bundle::getString)
                .forEach(System.out::println);
    }

}

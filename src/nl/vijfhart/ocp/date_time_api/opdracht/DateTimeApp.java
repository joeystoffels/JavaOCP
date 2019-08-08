package nl.vijfhart.ocp.date_time_api.opdracht;

/*
Een vliegtuig vetrekt op 29 oktober 2016 om half 11 ’s ochtends vanaf Schiphol en komt 8 uur en 30 minuten later aan in New York. Hoe laat is het daar dan?

Tips:
Maak gebruik van de method withZoneSameInstant() van ZonedDateTime om een moment op Schiphol te vertalen naar hetzelfde moment in New York, en bereken daarna de aankomsttijd.
Het ZoneId van New York is America/New_York, van Amsterdam is dat Europe/Amsterdam.
(Optioneel) Een week later vertrekt een ander vliegtuig ook om half 11 ’s ochtends vanuit New York. Hoe laat komt dit vliegtuig aan in Schiphol?
 */

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeApp {

    public static void main(String... args) {

        // Vliegtuig 1
        ZonedDateTime vertrek = ZonedDateTime.parse("2016-10-29T10:30:00Z[Europe/Amsterdam]");
        System.out.println(vertrek);

        Duration vliegtijd = Duration.ofHours(8).plusMinutes(30);

        ZonedDateTime aankomst = vertrek.withZoneSameInstant(ZoneId.of("America/New_York")).plus(vliegtijd);
        System.out.println(aankomst);

        // Vliegtuig 2
        ZonedDateTime aankomstWeekLater = ZonedDateTime.parse("2016-11-06T10:30:00Z[America/New_York]").plus(vliegtijd);
        System.out.println(aankomstWeekLater);

    }

}

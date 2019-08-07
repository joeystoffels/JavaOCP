package nl.vijfhart.ocp.date_time_api.opdracht;

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

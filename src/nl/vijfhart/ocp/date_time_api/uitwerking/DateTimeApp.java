package nl.vijfhart.ocp.date_time_api.uitwerking;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeApp {

    public static void main(String args[]) {
        ZoneId zoneNY = ZoneId.of(ZoneId.getAvailableZoneIds().stream()
                .filter(s -> s.toUpperCase().indexOf("YORK") >= 0)
                .findFirst()
                .orElse(null));
        ZoneId zoneAM = ZoneId.of("Europe/Amsterdam");
        LocalDate date = LocalDate.of(2016, 10, 29);
        LocalTime time = LocalTime.of(10, 30);
        Duration vlucht = Duration.ofHours(8).plus(Duration.ofMinutes(30));
        ZonedDateTime vertrek = ZonedDateTime.of(date, time, zoneAM);
        System.out.println(vertrek);
        ZonedDateTime aankomst = vertrek.withZoneSameInstant(zoneNY).plus(vlucht);
        System.out.println(aankomst);
        date = aankomst.plusWeeks(1).toLocalDate();
        vertrek = ZonedDateTime.of(date, time, zoneNY);
        System.out.println(vertrek);
        aankomst = vertrek.withZoneSameInstant(zoneAM).plus(vlucht);
        System.out.println(aankomst);
    }

}

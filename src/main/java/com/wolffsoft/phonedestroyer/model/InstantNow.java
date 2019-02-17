package com.wolffsoft.phonedestroyer.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class InstantNow {

    public static Instant instantNow() {
        return Instant.now();
    }

    public static String formatInstantToString(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.SHORT)
                .withZone(ZoneId.systemDefault());

        return formatter.format(instant);
    }
}

package com.wolffsoft.phonedestroyer.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class InstantNowToString {

    public static String instantToString() {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.SHORT)
                .withZone(ZoneId.systemDefault());

        return formatter.format(Instant.now());
    }
}

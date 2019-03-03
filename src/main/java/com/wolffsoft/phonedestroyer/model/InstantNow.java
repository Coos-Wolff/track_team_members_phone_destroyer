package com.wolffsoft.phonedestroyer.model;

import java.time.LocalDate;

public class InstantNow {

    public static LocalDate localDateNow() {
        return LocalDate.now();
    }

    public static String formatInstantToString() {
        return localDateNow().toString();
    }
}

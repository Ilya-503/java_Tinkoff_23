package edu.homeworks.hw5;

import java.util.regex.Pattern;

public final class Task5 {

    private static final Pattern LEGAL_RUS_CAR_ID_PATTERN = Pattern.compile("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$");

    private Task5() {
    }

    public static boolean isLegalRusCarId(String carID) {
        return RegexUtils.isMatchingRegex(carID, LEGAL_RUS_CAR_ID_PATTERN);
    }


}

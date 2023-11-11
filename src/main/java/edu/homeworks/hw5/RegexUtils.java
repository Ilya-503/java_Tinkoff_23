package edu.homeworks.hw5;

import java.util.regex.Pattern;

public final class RegexUtils {

    private RegexUtils() {
    }

    public static boolean isMatchingRegex(String str, Pattern pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return pattern.matcher(str).matches();
    }
}

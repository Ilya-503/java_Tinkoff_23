package edu.homeworks.hw5;

import java.util.regex.Pattern;

public final class Task7 {

    private static final Pattern  LENGTH_MORE_TWO_SYMBOLS =
        Pattern.compile("^[0,1]{2}0[0,1]*$");
    private static final Pattern STARTS_ENDS_THE_SAME_SYMBOL_PATTERN =
        Pattern.compile("(^1[1,0]*1$)|(^0[1,0]*0$)");
    private static final Pattern LENGTH_BETWEEN_ONE_AND_THREE_PATTERN =
        Pattern.compile("^[0,1]{1,3}$");

    private Task7() {
    }

    public static boolean hasLengthBigger2WithThirdZero(String str) {
        if (str == null || str.isBlank()) {
            return false;
        }
        return LENGTH_MORE_TWO_SYMBOLS.matcher(str).matches();
    }

    public static boolean startsAndEndsWithTheSameSymbols(String str) {
        if (str == null || str.isBlank()) {
            return false;
        }
        return STARTS_ENDS_THE_SAME_SYMBOL_PATTERN.matcher(str).matches();
    }

    public static boolean hasLengthBetweenOneAndThree(String str) {
        if (str == null || str.isBlank()) {
            return false;
        }
        return LENGTH_BETWEEN_ONE_AND_THREE_PATTERN.matcher(str).matches();
    }
}

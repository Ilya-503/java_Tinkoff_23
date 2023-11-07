package edu.homeworks.hw5;

import java.util.regex.Pattern;

public final class Task7 {

    private static final Pattern  LENGTH_MORE_TWO_SYMBOLS =
        Pattern.compile("^[0,1]{2}0[0,1]*$");
    private static final Pattern STARTS_ENDS_THE_SAME_SYMBOL_PATTERN =
        Pattern.compile("^([01])([01]*(\\1))?$");
    private static final Pattern LENGTH_BETWEEN_ONE_AND_THREE_PATTERN =
        Pattern.compile("^[0,1]{1,3}$");

    private Task7() {
    }

    public static boolean hasLengthBigger2WithThirdZero(String str) {
        return RegexUtils.isMatchingRegex(str, LENGTH_MORE_TWO_SYMBOLS);
    }

    public static boolean startsAndEndsWithTheSameSymbols(String str) {
        return RegexUtils.isMatchingRegex(str, STARTS_ENDS_THE_SAME_SYMBOL_PATTERN);
    }

    public static boolean hasLengthBetweenOneAndThree(String str) {
        return RegexUtils.isMatchingRegex(str, LENGTH_BETWEEN_ONE_AND_THREE_PATTERN);
    }
}

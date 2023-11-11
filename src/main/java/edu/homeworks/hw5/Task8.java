package edu.homeworks.hw5;

import java.util.regex.Pattern;

public final class Task8 {

    private static final Pattern ODD_LEN_PATTERN =
        Pattern.compile("^[01]([01]{2})*$");

    private static final Pattern ZERO_ODD_OR_ONE_EVEN_PATTERN =
        Pattern.compile("(^0([01]{2})*$)|(^1[01]([01]{2})*$)");

    private static final Pattern IS_NOT_FOUR_OR_SEVEN_PATTERN =
        Pattern.compile("^(?:(?!\\b1{2,3}\\b)[01])*$");

    private static final Pattern ODD_CHAR_IS_ONE =
        Pattern.compile("^1([01]1)*[01]?$");

    private static final Pattern ZEROS_AND_ONES_ARE_LIMITED =
        Pattern.compile("(^1?0{2,}$)|(^0+1?0+$)|(^0{2,}1?$)");

    private static final Pattern NO_ONES_SEQUENCE =
        Pattern.compile("^(?:(?!11)[01])*$");


    private Task8() {
    }

    public static boolean hasOddLen(String str) {
        return RegexUtils.isMatchingRegex(str, ODD_LEN_PATTERN);
    }

    public static boolean startWithZeroOddOrOneEven(String str) {
        return RegexUtils.isMatchingRegex(str, ZERO_ODD_OR_ONE_EVEN_PATTERN);
    }

    public static boolean isNotFourOrSeven(String str) {
        return RegexUtils.isMatchingRegex(str, IS_NOT_FOUR_OR_SEVEN_PATTERN);
    }

    public static boolean hasAllOddCharsAreOne(String str) {
        return RegexUtils.isMatchingRegex(str, ODD_CHAR_IS_ONE);
    }

    public static boolean hasLimitedZerosAndOnes(String str) {
        return RegexUtils.isMatchingRegex(str, ZEROS_AND_ONES_ARE_LIMITED);
    }

    public static boolean hasNoOnesSequence(String str) {
        return RegexUtils.isMatchingRegex(str, NO_ONES_SEQUENCE);
    }
}

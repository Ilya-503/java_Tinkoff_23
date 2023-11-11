package edu.homeworks.hw5;

import java.util.regex.Pattern;

public final class Task6 {

    private static final String ANY_CHAR_REPEATED_UNLIMITED = ".*";

    private Task6() {
    }

    public static boolean isSubstring(String sub, String str) {
        if (str == null || sub == null) {
            return false;
        }

        String subPatternString = getSubPatternString(sub);
        Pattern subPattern = Pattern.compile(subPatternString);
        return subPattern.matcher(str).find();
    }

    private static String getSubPatternString(String sub) {
        StringBuilder subPatternStr = new StringBuilder();
        for (char ch: sub.toCharArray()) {
            subPatternStr
                .append(ch)
                .append(ANY_CHAR_REPEATED_UNLIMITED);
        }
        return subPatternStr.toString();
    }
}

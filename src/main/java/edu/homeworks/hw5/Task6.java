package edu.homeworks.hw5;

import java.util.regex.Pattern;

public final class Task6 {

    private Task6() {
    }

    public static boolean isSubstring(String sub, String str) {
        if (str == null || sub == null) {
            return false;
        }
        return Pattern.compile(sub).matcher(str).find();
    }
}

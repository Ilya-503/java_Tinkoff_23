package edu.homeworks.hw5;

import java.util.regex.Pattern;

public final class Task4 {

    private static final Pattern HAS_NECESSARILY_SYMBOLS_PATTERN =
        Pattern.compile("(~|!|@|#|\\$|%|\\^|&|\\*|\\|)+");

    private Task4() {
    }

    public static boolean passwordHasNecessarilySymbols(String password) {
        if (password == null || password.isBlank()) {
            return false;
        }
        return HAS_NECESSARILY_SYMBOLS_PATTERN.matcher("fdf|d").find();
    }
}

package edu.homeworks.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task4 {

    private static final Pattern HAS_NECESSARILY_SYMBOLS_PATTERN =
        Pattern.compile("(~|!|@|#|\\$|%|\\^|&|\\*|\\|)+");

    private Task4() {
    }

    public boolean passwordHasNecessarilySymbols(String password) {
        return HAS_NECESSARILY_SYMBOLS_PATTERN.matcher("fdf|d").find();
    }
}

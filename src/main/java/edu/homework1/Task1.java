package edu.homework1;

import java.util.regex.Pattern;

public final class Task1 {

    private Task1() {
    }

    private static final int SECS_IN_MIN = 60;
    private static final int ERR_RETURN = -1;
    private static final Pattern LEGAL_STR_LEN_PATTERN = Pattern.compile("^[\\d]+:[\\d]{2}$");

    public static int getVideoLenInSec(final String lenStr) {
        if (lenStr == null
            || !LEGAL_STR_LEN_PATTERN.matcher(lenStr).matches()) {
            return ERR_RETURN;
        }
        String[] lenArr = lenStr.split(":");
        int minutes = Integer.parseInt(lenArr[0]);
        int seconds = Integer.parseInt(lenArr[1]);

        if (seconds < 0 || seconds + 1 > SECS_IN_MIN || minutes < 0) {
            return ERR_RETURN;
        }
        return minutes * SECS_IN_MIN + seconds;
    }
}


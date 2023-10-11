package edu.homework1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task1 {

    private Task1() {
    }

    private static final Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("MagicNumber")
    public static int getVideoLenInSec(final String lenStr) {
        try {
            String[] lenArr = lenStr.split(":");
            int minutes = Integer.parseInt(lenArr[0]);
            int seconds = Integer.parseInt(lenArr[1]);

            if (seconds < 0 || seconds > 59 || minutes < 0) {
                throw new IllegalArgumentException();
            }
            return minutes * 60 + seconds;

        } catch (IllegalArgumentException
                 | ArrayIndexOutOfBoundsException
                 | NullPointerException e) {
            LOGGER.error("Неверный формат длины видео ");
            return -1;
        }
    }
}
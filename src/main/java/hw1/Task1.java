package hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();
    public static int getVideoLenInSec(String lenStr) {
        try {
            String[] lenArr = lenStr.split(":");
            int minutes = Integer.parseInt(lenArr[0]);
            int seconds = Integer.parseInt(lenArr[1]);

            if (seconds < 0 || seconds > 59 || minutes < 0) {
                throw new IllegalArgumentException();
            }

            return minutes * 60 + seconds;

        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            LOGGER.error("Неверный формат длины видео ");
            return -1;
        }
    }
}

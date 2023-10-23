package edu.hw2.Task3;

import org.apache.logging.log4j.Logger;

public final class Utils {

    private Utils() {
    }

    private static final long MILLIS_TO_SLEEP = 1500;

    public static void imitateGettingConnection(Logger logger) {
        makeImitation(logger, "Getting connection ...");
    }

    public static void imitateConnection(Logger logger) {
        makeImitation(logger, "Connecting to the server ...");
    }

   private static void makeImitation(Logger logger, String actionMsg) {
        logger.info(actionMsg);

        try {
            Thread.sleep(MILLIS_TO_SLEEP);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}

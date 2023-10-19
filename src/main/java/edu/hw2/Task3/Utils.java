package edu.hw2.Task3;

import edu.hw2.Task3.Connection.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Utils {

    private Utils() {
    }

    public final static Logger LOGGER = LogManager.getLogger();
    private static final long MILLIS_TO_SLEEP = 1500;

    public static void imitateGettingConnection(Connection connection) {
        makeImitation("Getting connection ...");
        LOGGER.info("Got " + connection);
    }

    public static void imitateConnection() {
        makeImitation("Connecting to the server ...");
    }

   private static void makeImitation(String actionMsg) {
        LOGGER.info(actionMsg);

        try {
            Thread.sleep(MILLIS_TO_SLEEP);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

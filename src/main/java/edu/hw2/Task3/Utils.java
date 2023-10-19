package edu.hw2.Task3;

import edu.hw2.Task3.Connection.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Utils {

    private Utils() {
    }

    public final static Logger LOGGER = LogManager.getLogger();

    public static void imitateGettingConnection(Connection connection) {
        makeImitation("Getting connection ...");
        LOGGER.info("Got " + connection);
    }

    public static void imitateConnection() {
        makeImitation("Connecting to the server ...");
    }

   private static void makeImitation(String actionMsg) {
        LOGGER.info(actionMsg);
        long millisToSleep = 1500;

        try {
            Thread.sleep(millisToSleep);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

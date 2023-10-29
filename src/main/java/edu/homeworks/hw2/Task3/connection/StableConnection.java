package edu.homeworks.hw2.Task3.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {

    private final Logger logger;

    public StableConnection() {
        logger = LogManager.getLogger();
    }

    @Override
    public void execute(String command) {
            logger.info("executing command ...");
    }

    @Override
    public void close() throws Exception {
        logger.info("Connection was closed");
    }
}

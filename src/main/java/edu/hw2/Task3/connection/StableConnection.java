package edu.hw2.Task3.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.hw2.Task3.Utils.imitateConnection;

public class StableConnection implements Connection {

    private final Logger logger;

    public StableConnection() {
        logger = LogManager.getLogger();
    }

    @Override
    public void execute(String command) {
            imitateConnection(logger);
    }

    @Override
    public void close() throws Exception {
        logger.info("Connection was closed");
    }
}

package edu.hw2.Task3.connection;

import edu.hw2.Task3.exceptions.ConnectionException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {

    private final double failChance;
    private final Logger logger;

    public FaultyConnection(double failChance) {
        this.failChance = failChance;
        logger = LogManager.getLogger();
    }

    @Override
    public void execute(String command) throws ConnectionException {
        logger.info("executing command ...");

        double curFailChance = new Random().nextDouble();
        if (curFailChance <= failChance) {
            throw new ConnectionException("Failed to connect");
        }
    }

    @Override
    public void close() throws Exception {
        logger.info("Connection was closed");
    }
}

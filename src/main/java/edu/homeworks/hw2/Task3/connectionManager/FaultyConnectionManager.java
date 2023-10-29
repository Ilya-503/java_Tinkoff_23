package edu.homeworks.hw2.Task3.connectionManager;

import edu.homeworks.hw2.Task3.connection.Connection;
import edu.homeworks.hw2.Task3.connection.FaultyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnectionManager implements ConnectionManager {

    private final Logger logger;
    private final double connectionFailChance;

    public FaultyConnectionManager(double connectionFailChance) {
        this.connectionFailChance = connectionFailChance;
        logger = LogManager.getLogger();
    }

    @Override
    public Connection getConnection() {
        logger.info("getting connection ....");
        return new FaultyConnection(connectionFailChance);

    }
}

package edu.homeworks.hw2.Task3.connectionManager;

import edu.homeworks.hw2.Task3.connection.Connection;
import edu.homeworks.hw2.Task3.connection.FaultyConnection;
import edu.homeworks.hw2.Task3.connection.StableConnection;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultConnectionManager implements ConnectionManager {

    private final Logger logger;
    private final double getFailConnectionChance;
    private final double connectionFailChance;

   public DefaultConnectionManager(double getFailConnectionChance, double connectionFailChance) {
        this.getFailConnectionChance = getFailConnectionChance;
        this.connectionFailChance = connectionFailChance;
        logger = LogManager.getLogger();
    }

    @Override
    public Connection getConnection() {
       logger.info("getting connection ...");

        double chance = new Random().nextDouble();

        return chance <= getFailConnectionChance
                ? new FaultyConnection(connectionFailChance)
                : new StableConnection();
    }
}

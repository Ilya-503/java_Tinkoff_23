package edu.hw2.Task3.connectionManager;

import edu.hw2.Task3.connection.Connection;
import edu.hw2.Task3.connection.FaultyConnection;
import edu.hw2.Task3.connection.StableConnection;
import java.util.Random;
import  edu.hw2.Task3.Utils;
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
       Utils.imitateGettingConnection(logger);

        double chance = new Random().nextDouble();

        return chance <= getFailConnectionChance
                ? new FaultyConnection(connectionFailChance)
                : new StableConnection();
    }
}

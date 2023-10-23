package edu.hw2.Task3.connectionManager;

import edu.hw2.Task3.connection.Connection;
import edu.hw2.Task3.connection.FaultyConnection;
import edu.hw2.Task3.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import java.util.logging.ConsoleHandler;

public class FaultyConnectionManager implements ConnectionManager {

    private final Logger logger;
    private final double connectionFailChance;

    FaultyConnectionManager(double connectionFailChance) {
        this.connectionFailChance = connectionFailChance;
        logger = LogManager.getLogger();
    }

    @Override
    public Connection getConnection() {
        Utils.imitateGettingConnection(logger);
        return new FaultyConnection(connectionFailChance);

    }
}

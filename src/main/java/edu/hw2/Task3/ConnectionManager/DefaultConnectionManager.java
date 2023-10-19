package edu.hw2.Task3.ConnectionManager;

import edu.hw2.Task3.Connection.Connection;
import edu.hw2.Task3.Connection.FaultyConnection;
import edu.hw2.Task3.Connection.StableConnection;
import java.util.Random;
import static edu.hw2.Task3.Utils.imitateGettingConnection;

public class DefaultConnectionManager implements ConnectionManager {

    private final static double CHANCE_TO_GET_FAULTY_CONNECTION = 0.3;

    @Override
    public Connection getConnection() {
        double chance = new Random().nextDouble();
        Connection connection = chance <= CHANCE_TO_GET_FAULTY_CONNECTION
                ? new FaultyConnection()
                : new StableConnection();

        imitateGettingConnection(connection);
        return connection;
    }
}

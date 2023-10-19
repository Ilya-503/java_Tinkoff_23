package edu.hw2.Task3.ConnectionManager;

import edu.hw2.Task3.Connection.Connection;
import edu.hw2.Task3.Connection.FaultyConnection;
import static edu.hw2.Task3.Utils.imitateGettingConnection;

public class FaultyConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        Connection connection = new FaultyConnection();
        imitateGettingConnection(connection);
        return connection;
    }
}

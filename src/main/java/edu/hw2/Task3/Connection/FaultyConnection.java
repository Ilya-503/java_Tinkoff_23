package edu.hw2.Task3.Connection;

import edu.hw2.Task3.ConnectionException;
import java.util.Random;
import static edu.hw2.Task3.Utils.LOGGER;
import static edu.hw2.Task3.Utils.imitateConnection;

public class FaultyConnection implements Connection {

    private final static double FAIL_CHANCE = 0.4;

    @Override
    public void execute(String command) throws ConnectionException {
        imitateConnection();

        double curFailChance = new Random().nextDouble();
        if (curFailChance <= FAIL_CHANCE) {
            throw new ConnectionException("Failed to connect");
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info(this + " was closed");
    }

    @Override
    public String toString() {
        return "FAULTY connection";
    }
}

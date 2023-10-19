package edu.hw2.Task3.Connection;

import static edu.hw2.Task3.Utils.LOGGER;
import static edu.hw2.Task3.Utils.imitateConnection;

public class StableConnection implements Connection {

    @Override
    public void execute(String command) {
            imitateConnection();
    }

    @Override
    public void close() throws Exception {
        LOGGER.info(this + " was closed");
    }

    @Override
    public String toString() {
        return "STABLE connection";
    }
}
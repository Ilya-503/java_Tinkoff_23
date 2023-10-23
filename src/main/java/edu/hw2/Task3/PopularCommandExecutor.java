package edu.hw2.Task3;

import edu.hw2.Task3.connection.Connection;
import edu.hw2.Task3.connectionManager.ConnectionManager;
import edu.hw2.Task3.exceptions.ConnectionException;
import edu.hw2.Task3.exceptions.OutOfLimitedAttemptsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.Executor;

public class PopularCommandExecutor {

    private final ConnectionManager manager;
    private final int maxAttempts;
    private final CommandExecutor executor;
    private final Logger logger;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        if (manager == null || maxAttempts <= 0) {
            throw new IllegalArgumentException();
        }

        this.manager = manager;
        this.maxAttempts = maxAttempts;
        executor = new CommandExecutor();
        logger = LogManager.getLogger();
    }

    public void updatePackages() {
        logger.info("Trying to updatePackages");
        executor.execute(manager, "apt update && apt upgrade -y", maxAttempts);
    }
}

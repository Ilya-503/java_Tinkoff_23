package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionManager.ConnectionManager;
import static edu.hw2.Task3.Utils.LOGGER;

public class PopularCommandExecutor {

    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        if (manager == null || maxAttempts <= 0) {
            throw new IllegalArgumentException();
        }

        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    private void tryExecute(String command) throws ConnectionException {
        int curAttempt = 1;

        while (maxAttempts - curAttempt > -1) {
            try (var connection = manager.getConnection()) {
                LOGGER.info("Trying to execute command: " + command);
                LOGGER.info(String.format("Attempt: %d from %d", curAttempt, maxAttempts));
                connection.execute(command);
                LOGGER.info("Executed successfully!");
                return;

            } catch (ConnectionException e) {
                LOGGER.error("Connection failed");
                curAttempt++;

                if (curAttempt > maxAttempts) {
                    throw new ConnectionException("Out of limited attempts", e);
                }

            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}

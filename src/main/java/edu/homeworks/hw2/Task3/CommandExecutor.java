package edu.homeworks.hw2.Task3;

import edu.homeworks.hw2.Task3.connectionManager.ConnectionManager;
import edu.homeworks.hw2.Task3.exceptions.ConnectionException;
import edu.homeworks.hw2.Task3.exceptions.OutOfLimitedAttemptsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandExecutor {

    private final Logger logger;

    CommandExecutor() {
        logger = LogManager.getLogger();
    }

    public void execute(ConnectionManager manager, String command, int maxAttempts)
        throws OutOfLimitedAttemptsException {
        int curAttempt = 1;
        while (curAttempt < maxAttempts + 1) {
            logger.info(
                String.format("Attempt %d from %d", curAttempt, maxAttempts)
            );

            try (var connection = manager.getConnection()) {
                connection.execute(command);
                logger.info("Success execute!");
                return;

            } catch (ConnectionException e) {
                logger.error("Connection failed");
                curAttempt++;

                if (curAttempt > maxAttempts) {
                    throw new OutOfLimitedAttemptsException("Couldn't execute with all attempts", e);
                }

            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}

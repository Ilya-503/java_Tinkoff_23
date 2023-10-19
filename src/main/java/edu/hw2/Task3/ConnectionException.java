package edu.hw2.Task3;

public class ConnectionException extends RuntimeException {

    public ConnectionException(String exceptionMsg, Throwable cause) {
        super(exceptionMsg, cause);
    }

    public ConnectionException(String exceptionMsg) {
        super(exceptionMsg);
    }
}

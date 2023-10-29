package edu.homeworks.hw2.Task3.exceptions;

public class OutOfLimitedAttemptsException extends RuntimeException {

    public OutOfLimitedAttemptsException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

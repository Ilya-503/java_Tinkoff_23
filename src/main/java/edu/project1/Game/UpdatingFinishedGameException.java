package edu.project1.Game;

public final class UpdatingFinishedGameException extends RuntimeException {

    UpdatingFinishedGameException() {
        super();
    }

    UpdatingFinishedGameException(String msg) {
        super(msg);
    }

    UpdatingFinishedGameException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

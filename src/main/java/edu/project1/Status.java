package edu.project1;

public sealed interface Status permits GameStatus {

    boolean isEndGame();
    String getMessage();
}

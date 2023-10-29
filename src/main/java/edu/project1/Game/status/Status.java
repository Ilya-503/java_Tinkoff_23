package edu.project1.Game.status;

public sealed interface Status permits GameStatus {

    boolean isEndGame();

    String getMessage();
}

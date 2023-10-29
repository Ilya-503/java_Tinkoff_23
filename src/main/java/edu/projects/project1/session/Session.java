package edu.projects.project1.session;

import edu.projects.project1.Game.Game;
import edu.projects.project1.Game.GuessResult;
import edu.projects.project1.Game.status.GameStatus;
import java.util.Arrays;
import java.util.List;

public final class Session {

    private final Game game;
    private final GameConsole gameConsole;
    private final char[] userWord;
    private boolean isGameEnd;

    Session(String hiddenWord, int maxMistakes) {
        game = new Game(hiddenWord, maxMistakes);
        gameConsole = new GameConsole();
        isGameEnd = false;

        userWord = new char[hiddenWord.length()];
        Arrays.fill(userWord, '*');
    }

    public void startGame() {
        int maxMistakes = game.getMaxMistakes();
        int wordLen = game.getHiddenWord().length();
        gameConsole.printStartMsg(maxMistakes, wordLen);

        playGame();
    }

    private void playGame() {

        while (!isGameEnd) {
            String userInput = gameConsole.getUserInput();
            boolean isGivingUp = userInput.equals(gameConsole.getGiveUpCommand());

            if (isGivingUp) {
                game.giveUp();
                setSessionStatus(GameStatus.DEFEAT);
                return;
            }
            char letter = userInput.charAt(0);
            var guessResult = game.tryGuess(letter);
            updateSession(guessResult, letter);
        }
    }

    private void updateSession(GuessResult guessResult, char letter) {
        var letterIndexes = guessResult.getLetterIndexes();
        updateUserWord(letter, letterIndexes);
        gameConsole.printMsg(guessResult.getMsg());
        gameConsole.printMsg("The word: " + new String(userWord));

        var status = game.getGameStatus();
        setSessionStatus(status);
    }

    private void setSessionStatus(GameStatus status) {
        isGameEnd = status.isEndGame();
        gameConsole.printMsg(status.getMessage());
    }

    private void updateUserWord(char letter, List<Integer> indexes) {
        for (int i: indexes) {
            userWord[i] = letter;
        }
    }
}

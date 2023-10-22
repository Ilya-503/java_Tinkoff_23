package edu.project1.session;

import edu.project1.Game.Game;
import edu.project1.Game.status.GameStatus;
import edu.project1.Game.GuessResult;
import java.util.Arrays;
import java.util.List;
import static edu.project1.Game.status.GameStatus.DEFEAT;

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

        startGame(maxMistakes, hiddenWord.length());
    }

    public void startGame(int maxMistakes, int hiddenWordLen) {
        gameConsole.printStartMsg(maxMistakes, hiddenWordLen);

        playGame();
    }

    private void playGame() {

        while (!isGameEnd) {
            String userInput = gameConsole.getUserInput();
            boolean isGivingUp = userInput.equals(gameConsole.getGiveUpCommand());

            if (isGivingUp) {
                game.giveUp();
                setSessionStatus(DEFEAT);
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

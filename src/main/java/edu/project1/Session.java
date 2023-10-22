package edu.project1;

import java.util.Arrays;
import java.util.List;
import static edu.project1.GameStatus.DEFEAT;

public final class Session {

    private final Game game;
    private final GameConsole gameConsole;
    private final char[] userWord;
    private final String hiddenWord;
    private boolean isGameEnd;


    Session(String hiddenWord, int maxMistakes) {
        this.hiddenWord = hiddenWord;
        game = new Game(hiddenWord, maxMistakes, 0);
        gameConsole = new GameConsole();

        userWord = new char[hiddenWord.length()];
        Arrays.fill(userWord, '*');
    }

    public void startGame() {
        boolean isLegalHiddenWord = game.checkIfLegalWord(hiddenWord);
        boolean isLegalMaxMistakes = game.checkIfLegalMaxMistakes();

        if (!isLegalHiddenWord) {
            gameConsole.printIllegalHiddenWord(hiddenWord == null ? "" : hiddenWord);
            return;
        }
        if (!isLegalMaxMistakes) {
            gameConsole.printIllegalMaxMistakes();
            return;
        }

        gameConsole.printStartMsg(game.getMaxMistakes(), hiddenWord.length());
        playGame();
    }


    private void playGame() {

        while (!isGameEnd) {
            gameConsole.printMsg("The word: " + new String(userWord) + "\n");
            String userInput = gameConsole.getUserInput();
            boolean isGivingUp = userInput.equals(gameConsole.getGiveUpCommand());
            if (isGivingUp) {
                updateGameStatus(DEFEAT);
                break;
            }

            char letter = userInput.charAt(0);
            var guessResult = game.tryGuess(letter);
            updateSession(guessResult);
        }
    }

    private void updateSession(GuessResult guessResult) {
        char guessedLetter = guessResult.getGuessedLetter();
        var letterIndexes = guessResult.getLetterIndexes();
        updateUserWord(guessedLetter, letterIndexes);
        gameConsole.printMsg(guessResult.getMsg());

        updateGameStatus(game.getGameStatus());
    }

    private void updateGameStatus(GameStatus gameStatus) {
        isGameEnd = gameStatus.isEndGame();
        gameConsole.printMsg(gameStatus.getMessage());
    }

    private void updateUserWord(char letter, List<Integer> indexes) {
        for (int i: indexes) {
            userWord[i] = letter;
        }
    }
}

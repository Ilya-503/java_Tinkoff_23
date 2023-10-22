package edu.project1;

import edu.project1.GuessResultType.GuessResult;
import edu.project1.GuessResultType.GuessResult.Defeat;
import java.util.Arrays;
import java.util.List;

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
        boolean isLegalHiddenWord = game.checkIfLegalWord();
        boolean isLegalMaxMistakes = game.checkIfLegalMaxMistakes();

        if (!isLegalHiddenWord) {
            gameConsole.printIllegalHiddenWord(hiddenWord == null ? "" : hiddenWord);
            return;
        }
        if (!isLegalMaxMistakes) {
            gameConsole.printIllegalMaxMistakes();
            return;
        }

        playGame();
    }


    private void playGame() {
        gameConsole.printStartMsg(game.getMaxMistakes(), hiddenWord.length());

        while (!isGameEnd) {
            gameConsole.printMsg("The word: " + new String(userWord) + "\n");
            String userInput = gameConsole.getUserInput();
            boolean isGivingUp = userInput.equals(gameConsole.getGiveUpCommand());
            if (isGivingUp) {
                updateSession(new Defeat());
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
        isGameEnd = guessResult.getGameEndStatus();
        gameConsole.printMsg(guessResult.getMsg());
    }

    private void updateUserWord(char letter, List<Integer> indexes) {
        for (int i: indexes) {
            userWord[i] = letter;
        }
    }
}

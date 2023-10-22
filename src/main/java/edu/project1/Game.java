package edu.project1;

import edu.project1.GuessResult.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static edu.project1.GameStatus.DEFEAT;
import static edu.project1.GameStatus.WIN;
import static edu.project1.GameStatus.PLAYING;
import static edu.project1.Utils.isMatchingRegex;
import static edu.project1.Utils.parseWordByChars;

public final class Game {

    private final Map<Character, List<Integer>> wordChars;
    private final Set<Character> guessedLetters;
    private final int maxMistakes;
    private final String hiddenWord;
    private int madeMistakes;
    private GameStatus gameStatus;


    public Game(String hiddenWord, int maxMistakes) {
        this.hiddenWord = hiddenWord;
        this.maxMistakes = maxMistakes;
        this.guessedLetters = new HashSet<>();
        madeMistakes = 0;
        wordChars = parseWordByChars(hiddenWord);
        gameStatus = PLAYING;
    }

    public GuessResult tryGuess(char letter) {
        if (wordChars.containsKey(letter)) {
            guessedLetters.add(letter);
            if (guessedLetters.size() == wordChars.size()) {
                gameStatus = WIN;
            }
            var letterIndexes = wordChars.get(letter);
            return new SuccessGuess(letterIndexes);
        }

        madeMistakes++;
        if (madeMistakes == maxMistakes) {
            gameStatus = DEFEAT;
        }
        return new FailedGuess(maxMistakes, madeMistakes);
    }

    public void giveUp() {
        gameStatus = DEFEAT;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getMaxMistakes() {
        return maxMistakes;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }
}

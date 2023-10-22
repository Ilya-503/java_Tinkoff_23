package edu.project1;

import edu.project1.GuessResult.*;
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

    private static final String CORRECT_WORD_REGEX = "^[a-zA-Z]{2,}$"; // кол-во букв = 23?
    private final Map<Character, List<Integer>> wordChars;
    private final int maxMistakes;
    private final Set<Character> guessedLetters;
    private int madeMistakes;

    public Game(String hiddenWord, int maxMistakes, int madeMistakes) {
        this.maxMistakes = maxMistakes;
        this.madeMistakes = madeMistakes;
        this.guessedLetters = new HashSet<>();
        wordChars = parseWordByChars(hiddenWord);
    }

    public GuessResult tryGuess(char letter) {
        if (wordChars.containsKey(letter)) {
            guessedLetters.add(letter);
            var letterIndexes = wordChars.get(letter);
            return new SuccessGuess(letter, letterIndexes);
        }
        madeMistakes++;
        return new FailedGuess(maxMistakes, madeMistakes);
    }

    public GameStatus getGameStatus() {
        if (madeMistakes + 1 > maxMistakes) {
            return DEFEAT;
        }
        if (guessedLetters.size() == wordChars.size()) {
            return WIN;
        }
        return PLAYING;
    }

    public boolean checkIfLegalWord(String word) {
        return isMatchingRegex(word, CORRECT_WORD_REGEX);
    }

    public boolean checkIfLegalMaxMistakes() {   // maxMistake < wordChars.len - 1
        return maxMistakes > 0 && maxMistakes < 23;
    }

    public int getMaxMistakes() {
        return maxMistakes;
    }
}

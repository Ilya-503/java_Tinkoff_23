package edu.project1;

import edu.project1.GuessResultType.GuessResult;
import edu.project1.GuessResultType.GuessResult.*;
import java.util.List;
import java.util.Map;
import static edu.project1.Utils.isMatchingRegex;
import static edu.project1.Utils.parseWordByChars;

public final class Game {

    private static final String CORRECT_WORD_REGEX = "^[a-zA-Z]{2,}$"; // кол-во букв = 23?
    private final Map<Character, List<Integer>> wordChars;
    private final String hiddenWord;
    private final int maxMistakes;
    private int madeMistakes;

    public Game(String hiddenWord, int maxMistakes, int madeMistakes) {
        this.hiddenWord = hiddenWord;
        this.maxMistakes = maxMistakes;
        this.madeMistakes = madeMistakes;
        wordChars = parseWordByChars(hiddenWord);
    }

    public GuessResult tryGuess(char letter) {
        if (wordChars.containsKey(letter)) {
            var letterIndexes = wordChars.remove(letter);
            if (wordChars.isEmpty()) {
                return new Win(letter, letterIndexes);
            }
            return new SuccessGuess(letter, letterIndexes);
        }

        madeMistakes++;
        if (madeMistakes + 1 > maxMistakes) {
            return new Defeat();
        }
        return new FailedGuess(maxMistakes, madeMistakes);
    }

    public boolean checkIfLegalWord() {
        return isMatchingRegex(hiddenWord, CORRECT_WORD_REGEX);
    }

    public boolean checkIfLegalMaxMistakes() {   // maxMistake < wordChars.len - 1
        return maxMistakes > 0 && maxMistakes < 23;
    }

    public int getMaxMistakes() {
        return maxMistakes;
    }
}

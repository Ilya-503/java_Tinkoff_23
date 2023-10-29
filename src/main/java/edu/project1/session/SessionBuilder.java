package edu.project1.session;

import java.util.HashSet;
import static edu.project1.Utils.isMatchingRegex;

public final class SessionBuilder {

    private static final String CORRECT_WORD_REGEX = "^[a-z]{2,}$";
    private static final int ALPHABET_SIZE = 23;

    private SessionBuilder() {
    }

    public static Session getNewSession(String hiddenWord, int maxMistakes) throws IllegalArgumentException {
        int lettersAmount = countUniqueLetters(hiddenWord);
        checkIfLegalWord(hiddenWord, lettersAmount);
        checkIfLegalMaxMistakes(maxMistakes, hiddenWord.length());

        return new Session(hiddenWord, maxMistakes);
    }

    private static void checkIfLegalWord(String word, int letters) throws IllegalArgumentException {
        if (!isMatchingRegex(word, CORRECT_WORD_REGEX)) {
            throw new IllegalArgumentException("Illegal hidden word format");
        }
        if (letters == ALPHABET_SIZE) {
            throw new IllegalArgumentException("Illegal word: player always wins");
        }
    }

    private static void checkIfLegalMaxMistakes(int maxMistakes, int letters) throws IllegalArgumentException {
        if (maxMistakes < 1) {
            throw new IllegalArgumentException("Max mistakes value must be greater zero");
        }
        if (maxMistakes > ALPHABET_SIZE - letters) {
            throw new IllegalArgumentException("Max mistakes value too big: player always wins");
        }
    }

    private static int countUniqueLetters(String str) {
        if (str == null || str.isEmpty() || str.isBlank()) {
            return 0;
        }

        var charSet = new HashSet<Character>();
        for (char ch: str.toCharArray()) {
            charSet.add(ch);
        }
        return charSet.size();
    }
}

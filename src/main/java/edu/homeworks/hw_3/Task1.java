package edu.homeworks.hw_3;

import java.util.Map;
import static java.lang.Character.LOWERCASE_LETTER;
import static java.lang.Character.UPPERCASE_LETTER;

public final class Task1 {

    private static final Map<Integer, Character> FIRST_ALPH_LETTER_MAP = Map.of(
        (int) LOWERCASE_LETTER, 'a',
        (int) UPPERCASE_LETTER, 'A'
    );

    private static final int CODE_DIFF = 'z' - 'a';

    private Task1() {
    }

    public static String atbash(String str) {
        if (str == null) {
            return "";
        }

        StringBuilder result = new StringBuilder(str.length());

        for (char letter: str.toCharArray()) {

            if (!Character.isLetter(letter)) {
                result.append(letter);
                continue;
            }

            int charType = Character.getType(letter);
            char firstAlphLetter = FIRST_ALPH_LETTER_MAP.get(charType);
            char newLetter = (char) (letter + CODE_DIFF - 2 * (letter - firstAlphLetter));
            result.append(newLetter);
        }

        return result.toString();
    }
}

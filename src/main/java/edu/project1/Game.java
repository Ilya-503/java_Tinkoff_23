package edu.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Game {

    public static void main(String[] args) {
        System.out.println(new Game().wordChars);
    }

    private final String hiddenWord ;
    private final Map<Character, List<Integer>> wordChars;

    Game() {
        hiddenWord = WordsDictionary.getRandomWord();
        wordChars = parseWordByChars(hiddenWord);
    }

    private Map<Character, List<Integer>> parseWordByChars(final String word) {
        var wordChars = new HashMap<Character, List<Integer>>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            wordChars.computeIfAbsent(ch, k -> new ArrayList<>());
            wordChars.get(ch).add(i);
        }
        return wordChars;
    }
}

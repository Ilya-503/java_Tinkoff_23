package edu.projects.project1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class Utils {

    private Utils() {
    }

  public static Map<Character, List<Integer>> parseWordByChars(String word) {
        var wordChars = new HashMap<Character, List<Integer>>();
        if (word == null) {
            return wordChars;
        }

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            wordChars.computeIfAbsent(ch, k -> new ArrayList<>());
            wordChars.get(ch).add(i);
        }
        return wordChars;
    }

    public static boolean isMatchingRegex(String str, String reg) {
        if (str == null || reg == null) {
            return false;
        }
        return Pattern.compile(reg).matcher(str).matches();
    }
}

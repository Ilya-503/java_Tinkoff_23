package edu.project1;

import java.util.List;
import java.util.Random;

public final class WordsDictionary {

    private final static List<String> WORDS = List.of(
        "brainstorm",
        "backend",
        "google"
    );

    private final static Random rand = new Random();

    private WordsDictionary() {
    }

    public static String getRandomWord() {
        int len = WORDS.size();
        return WORDS
            .get(rand.nextInt(0, len));
    }
}

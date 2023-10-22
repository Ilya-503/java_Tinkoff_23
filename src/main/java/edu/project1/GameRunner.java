package edu.project1;

import edu.project1.session.Session;
import edu.project1.session.SessionBuilder;

public final class GameRunner {
    public static void main(String[] args) {
        String hiddenWord = WordsDictionary.getRandomWord();
        int maxMistakes = 6;

        try {
            Session session = SessionBuilder.startNewSession(hiddenWord, maxMistakes);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

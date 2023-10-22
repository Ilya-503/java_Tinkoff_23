package edu.project1;

public final class GameRunner {
    public static void main(String[] args) {
        String hiddenWord = WordsDictionary.getRandomWord();
        int maxMistakes = 6;

        Session session = new Session(hiddenWord, 3);
        session.startGame();
    }
}

package edu.project1;

import java.util.ArrayList;
import java.util.List;

public sealed interface GuessResult {

   char getGuessedLetter();
   List<Integer> getLetterIndexes();
   String getMsg();

    final class SuccessGuess implements GuessResult {

        private final char guessedLetter;
        private final List<Integer> letterIndexes;

        public SuccessGuess(char guessedLetter, List<Integer> letterIndexes) {
            this.guessedLetter = guessedLetter;
            this.letterIndexes = letterIndexes;
        }

        @Override
        public char getGuessedLetter() {
            return guessedLetter;
        }

        @Override
        public List<Integer> getLetterIndexes() {
            return letterIndexes;
        }

        @Override
        public String getMsg() {
            return "Hit!";
        }
    }

    final class FailedGuess implements GuessResult {

        private final int maxMistakes;
        private final int madeMistakes;

        public FailedGuess(int maxMistakes, int madeMistakes) {
            this.maxMistakes = maxMistakes;
            this.madeMistakes = madeMistakes;
        }

        @Override
        public char getGuessedLetter() {
            return 0;
        }

        @Override
        public List<Integer> getLetterIndexes() {
            return new ArrayList<>();
        }

        @Override
        public String getMsg() {
            return String.format("Missed, mistake %d of %d", madeMistakes, maxMistakes);
        }
    }
}

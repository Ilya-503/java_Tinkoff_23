package edu.project1.GuessResultType;

import edu.project1.Session;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public sealed interface GuessResult {

   boolean getGameEndStatus();
   char getGuessedLetter();
   List<Integer> getLetterIndexes();
   String getMsg();

    final class Win implements GuessResult {

        private final char guessedLetter;
        private final List<Integer> letterIndexes;

        public Win(char guessedLetter, List<Integer> letterIndexes) {
            this.guessedLetter = guessedLetter;
            this.letterIndexes = letterIndexes;
        }

        @Override
        public boolean getGameEndStatus() {
            return true;
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
            return "You win!";
        }
    }

    final class Defeat implements GuessResult {

        @Override
        public boolean getGameEndStatus() {
            return true;
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
            return "You lost!";
        }
    }

    final class SuccessGuess implements GuessResult {

        private final char guessedLetter;
        private final List<Integer> letterIndexes;

        public SuccessGuess(char guessedLetter, List<Integer> letterIndexes) {
            this.guessedLetter = guessedLetter;
            this.letterIndexes = letterIndexes;
        }

        @Override
        public boolean getGameEndStatus() {
            return false;
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
            return "Hit!\n";
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
        public boolean getGameEndStatus() {
            return false;
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

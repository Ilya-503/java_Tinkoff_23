package edu.projects.project1.Game;

import edu.projects.project1.Game.status.GameStatus;
import edu.projects.project1.Utils;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Game {

    private final Map<Character, List<Integer>> wordChars;
    private final Set<Character> guessedLetters;
    private final int maxMistakes;
    private final String hiddenWord;
    private int madeMistakes;
    private GameStatus gameStatus;


    public Game(String hiddenWord, int maxMistakes) {
        this.hiddenWord = hiddenWord;
        this.maxMistakes = maxMistakes;
        this.guessedLetters = new HashSet<>();
        madeMistakes = 0;
        wordChars = Utils.parseWordByChars(hiddenWord);
        gameStatus = GameStatus.PLAYING;
    }

    public GuessResult tryGuess(char letter) throws UpdatingFinishedGameException {
        if (!gameStatus.equals(GameStatus.PLAYING)) {
            throw new UpdatingFinishedGameException("Can't guess cause game has already finished");
        }

        if (wordChars.containsKey(letter)) {
            guessedLetters.add(letter);
            if (guessedLetters.size() == wordChars.size()) {
                gameStatus = GameStatus.WIN;
            }
            var letterIndexes = wordChars.get(letter);
            return new GuessResult.SuccessGuess(letterIndexes);
        }

        madeMistakes++;
        if (madeMistakes == maxMistakes) {
            gameStatus = GameStatus.DEFEAT;
        }
        return new GuessResult.FailedGuess(maxMistakes, madeMistakes);
    }

    public void giveUp() throws UpdatingFinishedGameException {
        if (!gameStatus.equals(GameStatus.PLAYING)) {
            throw new UpdatingFinishedGameException("Can't give up cause game has already finished");
        }
        gameStatus = GameStatus.DEFEAT;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getMaxMistakes() {
        return maxMistakes;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }
}

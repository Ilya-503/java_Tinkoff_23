package edu.projects.project1;

import edu.projects.project1.session.Session;
import edu.projects.project1.session.SessionBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GameRunner {

    private final static Logger LOGGER = LogManager.getLogger();

    private GameRunner() {
    }

    @SuppressWarnings({"MagicNumber", "UncommentedMain"})
    public static void main(String[] args) {
        String hiddenWord = WordsDictionary.getRandomWord();
        int maxMistakes = 6;

        try {
            Session session = SessionBuilder.getNewSession(hiddenWord, maxMistakes);
            session.startGame();
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

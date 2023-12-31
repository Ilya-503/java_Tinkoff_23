package edu.projects.project1.session;

import edu.projects.project1.Utils;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GameConsole {

    private static final String GIVE_UP_COMMAND = "gp";
    private static final String LETTER_REGEX = "^[\\s]*[a-zA-z][\\s]*$";
    private final Scanner reader;
    private final Logger logger;

    GameConsole() {
        reader = new Scanner(System.in);
        logger = LogManager.getLogger();
    }

    public void printStartMsg(int maxMistakes, int hiddenWordLen) {
        printMsg("Welcome!");
        printMsg(String.format("You can make %d mistakes", maxMistakes));
        printMsg(String.format("Word's length: %d", hiddenWordLen));
        printMsg(String.format("Type %s to give up\n", GIVE_UP_COMMAND));
    }

    public void printIllegalHiddenWord(String word) {
        printMsg(
            String.format("Can't play with word \"%s\"", word)
        );
    }

    public void printIllegalMaxMistakes() {
        printMsg("Maximum mistakes value must be positive");
    }

    public String getUserInput() {

        boolean isLetter = false;
        boolean isGivingUp = false;
        String userInput;

        do {
            printMsg("Try guess: ");
            userInput = reader.nextLine();
            printMsg("");

            isLetter = Utils.isMatchingRegex(userInput, LETTER_REGEX);
            isGivingUp = userInput.equals(GIVE_UP_COMMAND);

        } while (!isGivingUp && !isLetter);

        return userInput;
    }

    public String getGiveUpCommand() {
        return GIVE_UP_COMMAND;
    }

    void printMsg(String msg) {
        logger.info(msg);
    }

}

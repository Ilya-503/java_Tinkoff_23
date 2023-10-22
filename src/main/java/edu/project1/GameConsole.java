package edu.project1;

import java.util.Scanner;
import static edu.project1.Utils.isMatchingRegex;

public final class GameConsole {

    private static final String COMMAND_REG_TEMPLATE = "^[\\s]*%s[\\s]*$";
    private static final String GIVE_UP_COMMAND ="gp";
    private static final String LETTER_REGEX = String.format(COMMAND_REG_TEMPLATE, "[a-zA-z]");
    private static final String GIVE_UP_REGEX = String.format(COMMAND_REG_TEMPLATE, GIVE_UP_COMMAND);
    private final Scanner reader;

    GameConsole() {
        reader = new Scanner(System.in);
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

            isLetter = isMatchingRegex(userInput, LETTER_REGEX);
            isGivingUp = isMatchingRegex(userInput, GIVE_UP_REGEX);

        } while (!isGivingUp && !isLetter);

        return userInput;
    }

    public String getGiveUpCommand() {
        return GIVE_UP_COMMAND;
    }

    void printMsg(String msg) {
        System.out.println(msg);
    }

}

package edu.project1;

import java.lang.reflect.Parameter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;
import static edu.project1.InputType.GIVE_UP;
import static edu.project1.InputType.LETTER;
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

    public String getGiveUpCommand() {
        return GIVE_UP_COMMAND;
    }

    InputType getUserInput() {

        boolean isLetter = false;
        boolean isGivingUp = false;

        do {
            String userInput = readString();
            isLetter = isMatchingRegex(userInput, LETTER_REGEX);
            isGivingUp = isMatchingRegex(userInput, GIVE_UP_REGEX);

        } while (!isGivingUp && !isLetter);

        if (isLetter) {
            return LETTER;
        }
        return GIVE_UP;
    }



    private String readString() {
        String str;
        printMsg("Try guess: ");
        str = reader.nextLine();
        printMsg("");

        return str;
    }

    void printMsg(String msg) {
        System.out.println(msg);
    }

}

package edu.project1;

import java.util.Scanner;

public final class GameConsole {

    private final Scanner reader;

    GameConsole() {
        reader = new Scanner(System.in);
    }

    String readLetter() {
        return reader.next();
    }

    void printMsg(String msg) {
        System.out.println(msg);
    }

}

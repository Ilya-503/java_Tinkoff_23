package edu.homeworks.hw3.Task2;

import java.util.ArrayList;
import java.util.List;

public final class Task2 {

    private static final char OPENING_PARENTHESIS = '(';
    private static final char CLOSING_PARENTHESIS = ')';

    private Task2() {
    }

    public static List<String> clusterize(String parenthesesSequence) throws IllegalArgumentException {
        List<String> clusters = new ArrayList<>();
        StringBuilder cluster = new StringBuilder();
        int openingParenthCounter = 0;

        if (parenthesesSequence == null) {
            return clusters;
        }

        for (char ch: parenthesesSequence.toCharArray()) {

            if (!isParenthesis(ch)) {
                throw new IllegalArgumentException("Illegal char: " + ch);
            }

            cluster.append(ch);

            if (ch == OPENING_PARENTHESIS) {
                openingParenthCounter++;
                continue;
            }

            openingParenthCounter--;
            if (openingParenthCounter < 0) {
                throw new UnbalancedClusterException();
            }

            if (openingParenthCounter == 0) {
                clusters.add(cluster.toString());
                cluster.setLength(0);
            }
        }

        if (openingParenthCounter != 0) {
            throw new UnbalancedClusterException();
        }
        return clusters;
    }

    private static boolean isParenthesis(char ch) {
        return ch == OPENING_PARENTHESIS || ch == CLOSING_PARENTHESIS;
    }
}

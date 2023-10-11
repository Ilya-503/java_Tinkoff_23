package edu.homework1;

import java.util.Set;

public final class Task6 {

    private Task6() {
    }

    private static final short KAPREKAR_CONST = 6174;

    private static final Set<Integer> REPDIGITS = Set.of(
        1111, 2222, 3333, 4444, 5555,
        6666, 7777, 8888, 9999
    );

    @SuppressWarnings("MagicNumber")
    public static int countK(final int num) {
        if (num < 1001 || num > 9999 || REPDIGITS.contains(num)) {
            return -1;
        }

        int minNum = 0;
        int maxNum = 0;
        int[] digChars = String
            .valueOf(num)
            .chars()
            .sorted()
            .toArray();

        for (byte i = 0; i < 4; i++) {
            int digit = digChars[i] - '0';
            minNum = minNum * 10 + digit;
            maxNum = maxNum + digit * (int) Math.pow(10, i);
        }

        int diff = maxNum - minNum;
        if (diff == KAPREKAR_CONST) {
            return 1;
        }
        return 1 + countK(diff);
    }
}

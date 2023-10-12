package edu.homework1;

import java.util.Set;
import static edu.homework1.Task2.getNumLen;

public final class Task6 {

    private Task6() {
    }

    private static final short KAPREKAR_CONST = 6174;
    private static final Set<Integer> REPDIGITS = Set.of(
        1111, 2222, 3333, 4444, 5555,
        6666, 7777, 8888, 9999
    );
    private static final int MIN_ALLOWED_VAL = 1001;
    private static final int MAX_ALLOWED_VAL = 9999;
    private static final int BASE_NUM = 10;

    public static int countK(final int num) {
        if (num < MIN_ALLOWED_VAL
            || num > MAX_ALLOWED_VAL
            || REPDIGITS.contains(num)) {
            return -1;
        }

        int minNum = 0;
        int maxNum = 0;
        int[] digChars = String
            .valueOf(num)
            .chars()
            .sorted()
            .toArray();

        int numLen = getNumLen(num);

        for (byte i = 0; i < numLen; i++) {
            int digit = digChars[i] - '0';
            minNum = minNum * BASE_NUM + digit;
            maxNum = maxNum + digit * (int) Math.pow(BASE_NUM, i);
        }

        int diff = maxNum - minNum;
        if (diff == KAPREKAR_CONST) {
            return 1;
        }
        return 1 + countK(diff);
    }
}

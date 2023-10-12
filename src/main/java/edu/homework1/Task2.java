package edu.homework1;

public final class Task2 {

    private Task2() {
    }

    private static final int BASE_NUM = 10;

    public static int getNumLen(int num) {
        try {
            int absNum = Math.abs(num);
            if (absNum < BASE_NUM) {
                return 1;
            }

            int numLen = 0;
            while (absNum > 0) {
                numLen++;
                absNum /= BASE_NUM;
            }
            return numLen;
        } catch (NullPointerException e) {
            return -1;
        }
    }
}

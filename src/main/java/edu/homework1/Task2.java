package edu.homework1;

public final class Task2 {

    private Task2() {
    }

    @SuppressWarnings("MagicNumber")
    public static int getNumLen(int num) {
        try {
            int absNum = Math.abs(num);
            if (absNum < 10) {
                return 1;
            }

            int numLen = 0;
            while (absNum > 0) {
                numLen++;
                absNum /= 10;
            }
            return numLen;
        } catch (NullPointerException e) {
            return -1;
        }
    }
}

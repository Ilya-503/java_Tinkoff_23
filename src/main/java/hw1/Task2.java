package hw1;

public class Task2 {
    public static int getNumLen(Integer num) {
        if (num == null) {
            return -1;
        }

        num = Math.abs(num);
        if (num < 10) {
            return 1;
        }

        int numLen = 0;
        while (num > 0) {
            numLen++;
            num /= 10;
        }

        return numLen;
    }
}

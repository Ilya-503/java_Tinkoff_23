package hw1;

public class Task6 {
    private static final short KAPREKAR_CONST = 6174;
    public static int countK(int num) {
        if (num < 1001 || num > 9999 || hasAllSameDig(num)) {
            return -1;
        }

        int minNum = 0, maxNum = 0;
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
    private static boolean hasAllSameDig(int num) {
        return String
            .valueOf(num)
            .chars()
            .allMatch(chr -> chr - '0' == num % 10);
    }
}

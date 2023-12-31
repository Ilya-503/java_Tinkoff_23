package edu.homeworks.homework1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task0 {

    static int[] getSortedSquares(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];

        int leftIdx = 0;
        int rightIdx = len - 1;
        int resArrIdx = len - 1;

        while (resArrIdx > 0) {
            int leftValue = (int) Math.pow(arr[leftIdx], 2);
            int rightValue = (int) Math.pow(arr[rightIdx], 2);

            if (leftValue > rightValue) {
                result[resArrIdx] = leftValue;
                leftIdx++;

            } else {
                result[resArrIdx] = rightValue;
                rightIdx--;
            }
            resArrIdx--;
        }

        return result;
    }

    private Task0() {}

    private final static Logger LOGGER = LogManager.getLogger();

    public static void sayHi() {
        LOGGER.info("Привет, мир!");
    }
}

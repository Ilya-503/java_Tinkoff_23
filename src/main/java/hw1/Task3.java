package hw1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {
    public static boolean isNestable(int[] nestingArr, int[] toNestArr) {
        try {
            if (nestingArr.length == 0) {
                return true;
            }
            if (toNestArr.length == 0) {
                return false;
            }

            int[] nestingArrExtrVals = getArrExtremeValues(nestingArr);
            int[] toNestArrExtrVals = getArrExtremeValues(toNestArr);

            return nestingArrExtrVals[0] > toNestArrExtrVals[0]
                && nestingArrExtrVals[1] < toNestArrExtrVals[1];

        } catch (NullPointerException e) {
            return false;
        }
    }

    private static int[] getArrExtremeValues(int[] arr) {
        AtomicInteger minV = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger maxV = new AtomicInteger(Integer.MIN_VALUE);

        Arrays
            .stream(arr)
            .forEach(val -> {
                minV.set(Math.min(minV.get(), val));
                maxV.set(Math.max(maxV.get(), val));
        });
        return new int[] {minV.intValue(), maxV.intValue()};

    }
}

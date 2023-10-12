package edu.homework1;

public final class Task3 {

    private Task3() {
    }

    public static boolean isNestable(final int[] nestingArr, final int[] toNestArr) {
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

    private static int[] getArrExtremeValues(final int[] arr) {
        int minV = Integer.MAX_VALUE;
        int maxV = Integer.MIN_VALUE;

        for (int num: arr) {
            minV = Math.min(minV, num);
            maxV = Math.max(maxV, num);
        }
        return new int[] {minV, maxV};
    }
}

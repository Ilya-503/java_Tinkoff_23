package edu.homework1.Task7;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Task7 {

    private Task7() {
    }

    private static final RotateBitProvider LEFT_ROTATE_BIT_PROVIDER = ((bit, shiftBit, len) -> {
        int newBit = bit + shiftBit;
        return newBit > len - 1
            ? newBit % len
            : newBit;
    });

    private static final RotateBitProvider RIGHT_ROTATE_BIT_PROVIDER = ((bit, shiftBit, len) -> {
        int newBit = bit - shiftBit;
        return newBit < 0
            ? len + newBit
            : newBit;
    });

    private static final Map<RotateDirection, RotateBitProvider> BIT_PROVIDER_MAP = Map.of(
        RotateDirection.LEFT, LEFT_ROTATE_BIT_PROVIDER,
        RotateDirection.RIGHT, RIGHT_ROTATE_BIT_PROVIDER
    );

    public static int rotateLeft(int num, int shiftBit) {
        return rotateNum(num, shiftBit, RotateDirection.LEFT);
    }

    public static int rotateRight(int num, int shiftBit) {
        return rotateNum(num, shiftBit, RotateDirection.RIGHT);
    }

    private static int rotateNum(int num, int shiftBit, RotateDirection direction) {
        if (direction == null || num < 0 || shiftBit < 0) {
            return -1;
        }
        if (num == 0) {
            return 0;
        }

        int rotatedNum = 0;
        Set<Integer> inputBits = getBitSet(num);
        int len = Integer.toBinaryString(num).length();

        for (int bit: inputBits) {
            var bitProvider = BIT_PROVIDER_MAP.get(direction);
            int newBit = bitProvider.getBit(bit, shiftBit % len, len);
            rotatedNum += (int) Math.pow(2, newBit);
        }
        return rotatedNum;
    }

    @SuppressWarnings("ParameterAssignment")
    private static Set<Integer> getBitSet(int num) {
        Set<Integer> bitSet = new HashSet<>();
        int idx = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                bitSet.add(idx);
            }
            num /= 2;
            idx++;
        }
        return bitSet;
    }
}


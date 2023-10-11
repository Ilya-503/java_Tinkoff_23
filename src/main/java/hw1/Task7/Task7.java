package hw1.Task7;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import static hw1.Task2.getNumLen;

public class Task7 {
    private static final RotateBitProvider leftRotateProvider = ((bit, shiftBit, len) -> {
        int newBit = bit + shiftBit;
        return newBit > len - 1 ?
            newBit % len :
            newBit;
    });

    private static final RotateBitProvider rightRotateProvider = ((bit, shiftBit, len) -> {
        int newBit = bit - shiftBit;
        return newBit < 0 ?
            len + newBit :
            newBit;
    });

    private static final Map<ROTATE_DIRECTION, RotateBitProvider> bitProviders = Map.of(
        ROTATE_DIRECTION.LEFT, leftRotateProvider,
        ROTATE_DIRECTION.RIGHT, rightRotateProvider
    );

    public static int rotateLeft(int num, int shiftBit) {
        return rotateNum(num, shiftBit, ROTATE_DIRECTION.LEFT);
    }

    public static int rotateRight(int num, int shiftBit) {
        return rotateNum(num, shiftBit, ROTATE_DIRECTION.RIGHT);
    }

    private static int rotateNum(int num, int shiftBit, ROTATE_DIRECTION direction) {
        try {
            if (num < 0 || shiftBit < 0 ) {
                throw new IllegalArgumentException();
            }
            if (num == 0) {
                return 0;
            }

            AtomicInteger rotatedNum = new AtomicInteger();
            Set<Integer> inputBits = getBitSet(num);
            int len = Integer.toBinaryString(num).length();

            inputBits.forEach(
                bit -> {
                    var bitProvider = bitProviders.get(direction);
                    int newBit = bitProvider.getBit(bit, shiftBit % len, len);
                    rotatedNum.addAndGet((int) Math.pow(2, newBit));
                }
            );
            return rotatedNum.intValue();

        } catch (NullPointerException | IllegalArgumentException e) {
            return -1;
        }
    }

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


package hw1.Task7;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.Map;

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
        if (num < 0 || shiftBit < 0 ) {
            throw new IllegalArgumentException();
        }
        if (num == 0) {
            return 0;
        }

        try {
            BitSet inputBits = BitSet.valueOf(
                BigInteger
                    .valueOf(num)
                    .toByteArray()
            );
            int len = inputBits.length();
            BitSet resBits = new BitSet(len);

            inputBits.stream().forEach(
                bit -> {
                    var bitProvider = bitProviders.get(direction);
                    int newBit = bitProvider.getBit(bit, shiftBit, len);
                    resBits.set(newBit);
                }
            );
            return resBits
                .stream()
                .reduce(
                    0,
                    (res, bit) -> res + (int) Math.pow(2, bit)
                );
        } catch (NullPointerException | IllegalArgumentException e) {
            return -1;
        }
    }
}


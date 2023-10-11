package hw1;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Task7 {

    static HashMap<ROTATE_DIRECTION, Long> bitSetters = Map.of(
        ROTATE_DIRECTION.LEFT,  ,
        ROTATE_DIRECTION.RIGHT,
        )

    public static void main(String[] args) {
        System.out.println(rotateRight(9, 3));
    }


    public static int rotateLeft(int num, int bitAm) {
        return rotateNum(num, bitAm, ROTATE_DIRECTION.LEFT);
    }

    public static int rotateRight(int num, int bitAm) {
        return rotateNum(num, bitAm, ROTATE_DIRECTION.RIGHT);
    }


    private static int rotateNum(int num, int bitAm, ROTATE_DIRECTION direction) { // chec null, 0, negative
        BitSet inputBits = BitSet.valueOf(
            BigInteger
                .valueOf(num)
                .toByteArray()
        );
        int len = inputBits.length();
        BitSet resBits = new BitSet(len);
        int finalBitAm = bitAm % len;       // for use in lambda

        inputBits.stream().forEach(
            bit -> {
                int newBit = bit - finalBitAm;
                resBits.set(
                    newBit < 0 ? len + newBit : newBit
                );
            }
        );
        return resBits
            .stream()
            .reduce(0,
                (res, bit) -> res + (int) Math.pow(2, bit)
            );
    }


    private static int getNewBit(ROTATE_DIRECTION direction) {

    }

}
enum ROTATE_DIRECTION {
    LEFT, RIGHT;
}
// newBit > len - 1 ? newBit % len : newBit


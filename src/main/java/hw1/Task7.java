package hw1;

import javassist.bytecode.ByteArray;
import java.math.BigInteger;
import java.util.BitSet;

public class Task7 {

    public static void main(String[] args) {
        System.out.println(rotateRight(9, 3));
    }

    public static int rotateRight(int num, int bitAm) {
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


}

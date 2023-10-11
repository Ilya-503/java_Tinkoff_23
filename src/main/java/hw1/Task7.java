package hw1;

public class Task7 {

    public static int rotateLeft(int num, int bitAm) {
        return (num << bitAm) | (num >> (Integer.SIZE - bitAm % Integer.SIZE));
    }
    public static int rotateRight(int num, int bitAm) {
        return (num >> bitAm) | (num << (Integer.SIZE - bitAm % Integer.SIZE));
    }
}

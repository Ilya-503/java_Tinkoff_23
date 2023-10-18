package edu.hw2.Task2;

public interface FlatShape {
    double getArea();

    default void checkSideLen(double side, String errMsg) throws IllegalArgumentException {
        if (side <= 0) {
            throw new IllegalArgumentException(errMsg);
        }
    }
}

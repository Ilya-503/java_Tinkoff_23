package edu.hw2.Task2;

public class Square extends Rectangle implements FlatShape {

    private static final String ILLEGAL_SIDE_ERR_MSG = "Side must be positive";

    public Square(double side) {
        super(side, side);
    }
}

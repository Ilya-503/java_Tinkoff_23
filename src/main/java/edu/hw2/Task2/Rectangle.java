package edu.hw2.Task2;

public class Rectangle implements FlatShape {

    private static final String ILLEGAL_WIDTH_ERR_MSG = "Width must be positive";
    private static final String ILLEGAL_HEIGHT_ERR_MSG = "Height must be positive";

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        checkSideLen(width, ILLEGAL_WIDTH_ERR_MSG);
        checkSideLen(height, ILLEGAL_HEIGHT_ERR_MSG);
        this.width = width;
        this.height = height;
    }

    public Rectangle setWidth(double width) {
        return new Rectangle(width, height);
    }

    public Rectangle setHeight(double height) {
        return new Rectangle(width, height);
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

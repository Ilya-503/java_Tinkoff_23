package edu.hw2.Task1;

import static edu.hw2.Task1.Expression.*;


public class Task1 {
    public static void main(String[] args) {
        var one = new Constant(1);
        var negOne = new Negate(1);
        var mult = new Multiplication(43, negOne);
        System.out.println(mult.evaluate());
    }
}

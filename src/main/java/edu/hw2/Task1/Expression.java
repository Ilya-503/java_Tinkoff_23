package edu.hw2.Task1;

import static java.lang.Math.pow;

public sealed interface Expression {
    double evaluate();

    record Constant(double constant) implements Expression {

        @Override
        public double evaluate() {
            return constant;
        }
    }

    final class Negate implements Expression {

        private final double negConstant;

        public Negate(Expression expr) {
            negConstant = -expr.evaluate();
        }

        public Negate(double constant) {
            negConstant = -constant;
        }

        @Override
        public double evaluate() {
            return negConstant;
        }
    }

    final class Exponent implements Expression {

        private final double expResult;

        public Exponent(double foot, double degree) {
            expResult = pow(foot, degree);
        }

        public Exponent(Expression foot, double degree) {
            expResult = pow(foot.evaluate(), degree);
        }

        public Exponent(double foot, Expression degree) {
            expResult = pow(foot, degree.evaluate());
        }

        public Exponent(Expression foot, Expression degree) {
            expResult = pow(foot.evaluate(), degree.evaluate());
        }

        @Override
        public double evaluate() {
            return expResult;
        }
    }

    final class Addition implements Expression {

        private final double sumResult;

        public Addition(double a, double b) {
            sumResult = a + b;
        }

        public Addition(Expression a, double b) {
            sumResult = a.evaluate() + b;
        }

        public Addition(double a, Expression b) {
            sumResult = a + b.evaluate();
        }

        public Addition(Expression a, Expression b) {
            sumResult = a.evaluate() + b.evaluate();
        }

        @Override
        public double evaluate() {
            return sumResult;
        }
    }

    public final class Multiplication implements Expression {

        private final double multResult;

        public Multiplication(double a, double b) {
            multResult = a * b;
        }

        public Multiplication(Expression a, double b) {
            multResult = a.evaluate() * b;
        }

        public Multiplication(double a, Expression b) {
            multResult = a * b.evaluate();
        }

        public Multiplication(Expression a, Expression b) {
            multResult = a.evaluate() * b.evaluate();
        }

        @Override
        public double evaluate() {
            return multResult;
        }
    }
}

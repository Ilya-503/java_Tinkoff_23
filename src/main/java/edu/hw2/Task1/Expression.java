package edu.hw2.Task1;

import static java.lang.Math.pow;

public sealed interface Expression {
    double evaluate();

    record Constant(double constant) implements Expression {

        @Override
        public double evaluate() {
            return constant;
        }

        @Override
        public String toString() {
            return String.valueOf(constant);
        }
    }

    final class Negate implements Expression {

        private final double negConstant;

        public Negate(Expression expr) {
            negConstant = -expr.evaluate();
        }

        @Override
        public double evaluate() {
            return negConstant;
        }

        @Override
        public String toString() {
            return String.valueOf(negConstant);
        }
    }

    final class Exponent implements Expression {

        private final double expResult;

        public Exponent(Expression foot, int degree) {
            expResult = pow(foot.evaluate(), degree);
        }

        @Override
        public double evaluate() {
            return expResult;
        }

        @Override
        public String toString() {
            return String.valueOf(expResult);
        }
    }

    final class Addition implements Expression {

        private final double sumResult;

        public Addition(Expression a, Expression b) {
            sumResult = a.evaluate() + b.evaluate();
        }

        @Override
        public double evaluate() {
            return sumResult;
        }

        @Override
        public String toString() {
            return String.valueOf(sumResult);
        }
    }

    final class Multiplication implements Expression {

        private final double multResult;

        public Multiplication(Expression a, Expression b) {
            multResult = a.evaluate() * b.evaluate();
        }

        @Override
        public double evaluate() {
            return multResult;
        }

        @Override
        public String toString() {
            return String.valueOf(multResult);
        }
    }
}

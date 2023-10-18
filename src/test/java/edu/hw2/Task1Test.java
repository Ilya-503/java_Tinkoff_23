package edu.hw2;

import static edu.hw2.Task1.Expression.*;
import static org.assertj.core.api.Assertions.assertThat;
import edu.hw2.Task1.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

public class Task1Test {

    @DisplayName("Check Constant")
    @ParameterizedTest(name = "const = {0}")
    @ValueSource(doubles = {
        0,
        -1,
        4.5,
        -0.435
    })
    public void constantTest(double constant) {
        double num = new Constant(constant).evaluate();
        assertThat(num).isEqualTo(constant);
    }


    @DisplayName("Check Negate")
    @ParameterizedTest(name = "const = {0}")
    @MethodSource("constProvider")
    public void negateTest(Expression expr) {
      double negNum = new Negate(expr).evaluate();
      double expectedNum = -expr.evaluate();

      assertThat(negNum).isEqualTo(expectedNum);
    }

    private static Stream<Arguments> constProvider() {
        return Stream.of(
            Arguments.of(new Constant(0.69)),
            Arguments.of(new Constant(3.434)),
            Arguments.of(new Constant(0))
        );
    }


    @DisplayName("Check Exponent")
    @ParameterizedTest(name = "foot = {0}, degree = {1}")
    @MethodSource("expConstsProvider")
    public void multTest(Expression footExpr, int degree) {
        double num = new Exponent(footExpr, degree).evaluate();
        double expectedNum = Math.pow(footExpr.evaluate(), degree);

        assertThat(num).isEqualTo(expectedNum);
    }

    private static Stream<Arguments> expConstsProvider() {
        return Stream.of(
            Arguments.of(new Constant(12), 1),
            Arguments.of(new Negate(new Constant(1)), 2),
            Arguments.of(new Constant(0), 4),
            Arguments.of(new Constant(4), -2)
        );
    }

    @DisplayName("Check Addition")
    @ParameterizedTest(name = "a= {0}, b={1}")
    @MethodSource("addConstsProvider")
    public void addTest(Expression aExpr, Expression bExpr) {
        double num = new Addition(aExpr, bExpr).evaluate();
        double expectedNum = aExpr.evaluate() + bExpr.evaluate();

        assertThat(num).isEqualTo(expectedNum);
    }

    private static Stream<Arguments> addConstsProvider() {
        return Stream.of(
            Arguments.of(new Constant(12), new Constant(0)),
            Arguments.of(new Negate(new Constant(1)), new Constant(-3)),
            Arguments.of(new Exponent(new Constant(3), 5), new Constant(1))
        );
    }

    @DisplayName("Check Multiplication")
    @ParameterizedTest(name = "a= {0}, b={1}")
    @MethodSource("multConstsProvider")
    public void multTest(Expression aExpr, Expression bExpr) {
        double num = new Multiplication(aExpr, bExpr).evaluate();
        double expectedNum = aExpr.evaluate() * bExpr.evaluate();

        assertThat(num).isEqualTo(expectedNum);
    }

    private static Stream<Arguments> multConstsProvider() {
        return Stream.of(
            Arguments.of(new Addition(new Constant(1), new Constant(-5)), new Constant(2)),
            Arguments.of(new Constant(0), new Negate(new Constant(2)))
        );
    }


}

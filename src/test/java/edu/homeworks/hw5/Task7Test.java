package edu.homeworks.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.homeworks.hw5.Task7.hasLengthBetweenOneAndThree;
import static edu.homeworks.hw5.Task7.hasLengthBigger2WithThirdZero;
import static edu.homeworks.hw5.Task7.startsAndEndsWithTheSameSymbols;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {

    @DisplayName("check min len")
    @ParameterizedTest(name = "str= {0}")
    @MethodSource("minLenStringsProvider")
    public void minLenWith3rdZeroTest(String str, boolean expectedResult) {
        boolean hasLenMoreThanTwoWith3rdZero = hasLengthBigger2WithThirdZero(str);
        assertThat(hasLenMoreThanTwoWith3rdZero).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> minLenStringsProvider() {
        return Stream.of(
            Arguments.of("", false),
            Arguments.of("01001-", false),
            Arguments.of("ab1", false),
            Arguments.of("01 1", false),
            Arguments.of("10", false),
            Arguments.of("00", false),
            Arguments.of("101", false),
            Arguments.of("10101", false),
            Arguments.of("0011", false),
            Arguments.of("100", true),
            Arguments.of("1101", true)
        );
    }

    @DisplayName("check extreme same chars")
    @ParameterizedTest(name = "str= {0}")
    @MethodSource("extremeCharsStringsProvider")
    public void extremeCharsAreSameTest(String str, boolean expectedResult) {
        boolean hasStartAndEndCharsAreSame = startsAndEndsWithTheSameSymbols(str);
        assertThat(hasStartAndEndCharsAreSame).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> extremeCharsStringsProvider() {
        return Stream.of(
            Arguments.of("", false),
            Arguments.of("01001-", false),
            Arguments.of("ab1", false),
            Arguments.of("01 1", false),
            Arguments.of("10", false),
            Arguments.of("00", true),
            Arguments.of("1", true),
            Arguments.of("0", true),
            Arguments.of("10101", true),
            Arguments.of("0011", false)
        );
    }

    @DisplayName("check legal len")
    @ParameterizedTest(name = "str= {0}")
    @MethodSource("differentLenStringProvider")
    public void lenBetweenTest(String str, boolean expectedResult) {
        boolean hasStartAndEndCharsAreSame = hasLengthBetweenOneAndThree(str);
        assertThat(hasStartAndEndCharsAreSame).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> differentLenStringProvider() {
        return Stream.of(
            Arguments.of("", false),
            Arguments.of("01001-", false),
            Arguments.of("ab1", false),
            Arguments.of("01 1", false),
            Arguments.of("10101", false),
            Arguments.of("0011", false),
            Arguments.of("10", true),
            Arguments.of("00", true),
            Arguments.of("1", true),
            Arguments.of("0", true),
            Arguments.of("011", true)
        );
    }
}

package edu.homeworks.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.homeworks.hw5.Task8.hasAllOddCharsAreOne;
import static edu.homeworks.hw5.Task8.hasLimitedZerosAndOnes;
import static edu.homeworks.hw5.Task8.hasOddLen;
import static edu.homeworks.hw5.Task8.isNotFourOrSeven;
import static edu.homeworks.hw5.Task8.startWithZeroOddOrOneEven;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {

    @DisplayName("check odd len")
    @ParameterizedTest(name = "str= {0}")
    @MethodSource("oddLenTestStringsProvider")
    public void oddLenTest(String str, boolean expectedResult) {
        boolean hasOddLen = hasOddLen(str);
        assertThat(hasOddLen).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> oddLenTestStringsProvider() {
        return Stream.of(
            Arguments.of("", false),
          Arguments.of("11", false),
          Arguments.of("01", false),
          Arguments.of("1", true),
          Arguments.of("011", true)
        );
    }

    @DisplayName("check 0-odd or 1-even")
    @ParameterizedTest(name = "str= {0}")
    @MethodSource("differentLenParityTestStringsProvider")
    public void differentLenParityTest(String str, boolean expectedResult) {
        boolean hasCorrectLenParity = startWithZeroOddOrOneEven(str);
        assertThat(hasCorrectLenParity).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> differentLenParityTestStringsProvider() {
        return Stream.of(
            Arguments.of("00", false),
            Arguments.of("01", false),
            Arguments.of("0001", false),
            Arguments.of("1", false),
            Arguments.of("100", false),
            Arguments.of("111", false),
            Arguments.of("0", true),
            Arguments.of("011", true),
            Arguments.of("11", true),
            Arguments.of("1100", true)
        );
    }

    @DisplayName("check not 4 and 7")
    @ParameterizedTest(name = "str= {0}")
    @MethodSource("isNotFourOrSevenTestStringsProvider")
    public void isNotFourOrSevenTest(String str, boolean expectedResult) {
        boolean isNotFourOrSeven = isNotFourOrSeven(str);
        assertThat(isNotFourOrSeven).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> isNotFourOrSevenTestStringsProvider() {
        return Stream.of(
            Arguments.of("11", false),
            Arguments.of("111", false),
            Arguments.of("0001", true),
            Arguments.of("1", true),
            Arguments.of("100", true),
            Arguments.of("0", true),
            Arguments.of("011", true)
        );
    }

    @DisplayName("check all chars are 1")
    @ParameterizedTest(name = "str= {0}")
    @MethodSource("allOddCharsAreOneTestStringsProvider")
    public void allOddCharsAreOneTest(String str, boolean expectedResult) {
        boolean allOddCharsAreOne = hasAllOddCharsAreOne(str);
        assertThat(allOddCharsAreOne).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> allOddCharsAreOneTestStringsProvider() {
        return Stream.of(
            Arguments.of("110", false),
            Arguments.of("0111", false),
            Arguments.of("0001", false),
            Arguments.of("1", true),
            Arguments.of("10", true),
            Arguments.of("1010", true),
            Arguments.of("1111", true)
        );
    }

    @DisplayName("check limited ones and zeros")
    @ParameterizedTest(name = "str= {0}")
    @MethodSource("limitedOnesAndZerosTestStringsProvider")
    public void limitedOnesAndZerosTest(String str, boolean expectedResult) {
        boolean zerosAndOnesAreInRange = hasLimitedZerosAndOnes(str);
        assertThat(zerosAndOnesAreInRange).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> limitedOnesAndZerosTestStringsProvider() {
        return Stream.of(
            Arguments.of("11", false),
            Arguments.of("0", false),
            Arguments.of("11100", false),
            Arguments.of("01", false),
            Arguments.of("00", true),
            Arguments.of("1000", true),
            Arguments.of("1000", true),
            Arguments.of("0010", true),
            Arguments.of("001", true)
        );
    }

    @DisplayName("check no ones sequence")
    @ParameterizedTest(name = "str= {0}")
    @MethodSource("noOnesSequenceTestStringsProvider")
    public void noOnesSequenceTest(String str, boolean expectedResult) {
        boolean hasNoOnesSequence = Task8.hasNoOnesSequence(str);
        assertThat(hasNoOnesSequence).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> noOnesSequenceTestStringsProvider() {
        return Stream.of(
            Arguments.of("11", false),
            Arguments.of("01101", false),
            Arguments.of("000011", false),
            Arguments.of("00", true),
            Arguments.of("1000", true),
            Arguments.of("1010", true),
            Arguments.of("10", true),
            Arguments.of("001", true)
        );
    }









}

package edu.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.homeworks.homework1.Task4.getCorrectStr;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @DisplayName("Check Task4")
    @ParameterizedTest(name = "str = {0}")
    @MethodSource("provideIncorrectStrings")
    public void getCorrectStringTest(String str, String expectedCorrectStr) {
        String correctString = getCorrectStr(str);
        assertThat(correctString).isEqualTo(expectedCorrectStr);
    }

    private static Stream<Arguments> provideIncorrectStrings() {
        return Stream.of(
            Arguments.of("", ""),
            Arguments.of(null, ""),
            Arguments.of(" ", " "),
            Arguments.of("1", "1"),
            Arguments.of("ab", "ba"),
            Arguments.of("bac", "abc"),
            Arguments.of("hTsii  s aimex dpus rtni.g", "This is a mixed up string.")
        );
    }
}

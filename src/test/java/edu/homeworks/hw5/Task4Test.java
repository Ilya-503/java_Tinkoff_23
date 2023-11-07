package edu.homeworks.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import static edu.homeworks.hw5.Task4.passwordHasNecessarilySymbols;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @DisplayName("check necessary symbols for password")
    @ParameterizedTest(name = "passw= {0}")
    @MethodSource("passwordsProvider")
    public void passwHasNecessarySymbolsTest(String passw, boolean expectedResult) {
        boolean result = passwordHasNecessarilySymbols(passw);
        assertThat(result).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> passwordsProvider() {
        return Stream.of(
            Arguments.of("", false),
            Arguments.of("abc", false),
            Arguments.of("~a", true),
            Arguments.of("av!", true),
            Arguments.of("v@w", true),
            Arguments.of("kol%1", true),
            Arguments.of("josg^", true),
            Arguments.of("&&1", true),
            Arguments.of("**", true),
            Arguments.of("nice|good", true),
            Arguments.of("ni!ce^|go@od", true)
        );
    }
}

package edu.homeworks.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class RegexUtilsTest {

    @DisplayName("check RegexUtils")
    @ParameterizedTest(name = "str= {0}")
    @MethodSource("regexUtilsStringsProvider")
    public void regexUtilsTest(String str, boolean expectedResult) {
        Pattern firstNamePattern = Pattern.compile("^[A-Z][a-z]+$");
        boolean result = RegexUtils.isMatchingRegex(str, firstNamePattern);

        assertThat(result).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> regexUtilsStringsProvider() {
        return Stream.of(
          Arguments.of("Josh", true),
          Arguments.of("", false),
          Arguments.of(null, false),
          Arguments.of("    ", false),
          Arguments.of("josH", false),
          Arguments.of("Ly", true)
        );
    }

}

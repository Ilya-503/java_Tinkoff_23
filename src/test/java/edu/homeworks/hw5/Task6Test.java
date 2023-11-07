package edu.homeworks.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.homeworks.hw5.Task6.isSubstring;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    @DisplayName("check substring validation")
    @ParameterizedTest(name = "sub= {0}, str= {1}")
    @MethodSource("stringsProvider")
    public void isLegalCarIdTest(String sub, String str, boolean expectedResult) {
        boolean result = isSubstring(sub, str);
        assertThat(result).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> stringsProvider() {
        return Stream.of(
            Arguments.of(null, null, false),
            Arguments.of(null, "afa", false),
            Arguments.of("k", null, false),
            Arguments.of("k", "K-pop", false),
            Arguments.of("k", "kek", true),
            Arguments.of("abc", "abc", true),
            Arguments.of("12", "23_babf_4123_3", true)
        );
    }
}

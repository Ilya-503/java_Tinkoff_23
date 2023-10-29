package edu.homeworks.hw_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.homeworks.hw_3.Task1.atbash;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    @DisplayName("Check atbash")
    @ParameterizedTest(name = "str = {0}")
    @MethodSource("atbashArgsProvider")
    public void atbashTest(String msg, String expectedMsg) {
        var atbashMsg = atbash(msg);

        assertThat(atbashMsg).isEqualTo(expectedMsg);
    }

    private static Stream<Arguments> atbashArgsProvider() {
        return Stream.of(
            Arguments.of("Hello_world12!", "Svool_dliow12!"),
            Arguments.of("12!", "12!"),
            Arguments.of(null, ""),
            Arguments.of("\"\"", "\"\"")
        );
    }
}

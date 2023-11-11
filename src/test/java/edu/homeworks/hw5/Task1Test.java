package edu.homeworks.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import static edu.homeworks.hw5.Task1.getAverageDuration;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Task1Test {

    @DisplayName("Check Illegal format")
    @ParameterizedTest()
    @MethodSource("averDurationIllegalStringsProvider")
    public void averageDurationWithIllegalFormatTest(List<String> datesList) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> getAverageDuration(datesList)
        );
    }

    public static Stream<Arguments> averDurationIllegalStringsProvider() {
        return Stream.of(
            Arguments.of(
                List.of()
            ),
            Arguments.of(
                List.of("2022-04-01, 21:30 - 2022-04-02, 01:20", "")
            ),
            Arguments.of(
                List.of("2022-04-01, 21:30 - 2022-04-02, 01:20", "1999-04-01, 21:30 - 1999-04-01, 20:20")
            ),
            Arguments.of(
                List.of("2022-04-01, 21:30 - 2022-04-02, 01:20", "2022-04-01, 21:30")
            )
        );
    }

    @DisplayName("Check legal format")
    @ParameterizedTest(name = "duration = {1}")
    @MethodSource("averDurationLegalStringsProvider")
    public void averageDurationLegalTest(List<String> datesList, long expectedMinutes) {
        Duration averDuration = getAverageDuration(datesList);
        assertThat(averDuration.toMinutes()).isEqualTo(expectedMinutes);
    }

    public static Stream<Arguments> averDurationLegalStringsProvider() {
        return Stream.of(
            Arguments.of(
                List.of(
                    "2023-11-12, 20:20 - 2023-12-12, 21:20"
                ), 43260
            ),
            Arguments.of(
              List.of(
                  "2022-03-12, 20:20 - 2022-03-12, 23:50",
                  "2022-04-01, 21:30 - 2022-04-02, 01:20"
              ), 220
            ),
            Arguments.of(
                List.of(
                    "2023-11-12, 20:20 - 2023-12-12, 21:20", //43260
                    "2023-11-12, 20:20 - 2023-11-12, 21:20", // 60
                    "2014-01-01, 10:10 - 2014-01-01, 10:10"  // 0
                ), 14440
            )
        );
    }


}

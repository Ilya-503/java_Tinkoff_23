package edu.homeworks.hw_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Map;
import java.util.stream.Stream;
import static edu.homeworks.hw_3.Task3.getFreqDict;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Task3Test {

    @DisplayName("check legal freqDict")
    @ParameterizedTest(name = "arr= {0}")
    @MethodSource("legalFreqDictArgsProvider")
    public void freqDictTest(Object[] sequence, Map<Object, Integer> expectedDict) {
        var dict = getFreqDict(sequence);

        assertThat(dict).isEqualTo(expectedDict);
    }

    private static Stream<Arguments> legalFreqDictArgsProvider() {
        return Stream.of(
            Arguments.of(
                new String[] {"код", "код", "код", "bug"}, Map.of("код", 3, "bug", 1)
            ),
            Arguments.of(
                new Number[] {12, 4, 12, 12}, Map.of(12, 3, 4, 1)
            )
        );
    }

    @DisplayName("check illegal freqDict")
    @Test
    public void illegalFreqDictTest() {

        Number[] numbers = new Number[] {12, 42, 12L};
        Object[] objects = new Object[] {"12", 42, '2'};

        assertAll(
            () -> assertIllegalArgsException(numbers),
            () -> assertIllegalArgsException(objects)
        );
    }

    private void assertIllegalArgsException(Object[] arr) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> getFreqDict(arr));
    }
}

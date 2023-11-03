package edu.homeworks.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class Task8Test {


    @DisplayName("check getting elem backward iterator")
    @ParameterizedTest(name = "list= {0}")
    @MethodSource("listProvider")
    public void backwardIteratorTest(List<Object> list) {
        var iterator = new BackwardIterator<Object>(list);

        for (int i = list.size() - 1; i > - 1; i--) {
            assertThat(iterator.hasNext()).isTrue();
            assertThat(iterator.next()).isEqualTo(list.get(i));
        }
    }

    @DisplayName("check arr boundary backward iterator")
    @ParameterizedTest(name = "list= {0}")
    @MethodSource("listProvider")
    public void endListBackwardIteratorTest(List<Object> list) {
        var iterator = new BackwardIterator<Object>(list);

        for (int i = list.size() - 1; i > - 1; i--) {
            iterator.next();
        }

        assertThat(iterator.hasNext()).isFalse();
        assertThatExceptionOfType(NoSuchElementException.class)
            .isThrownBy(iterator::next);
    }

    private static Stream<Arguments> listProvider() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3)),
            Arguments.of(List.of("ga", "ga", "ulala"))
        );
    }
}

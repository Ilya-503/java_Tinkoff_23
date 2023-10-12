package edu.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.homework1.Task3.isNestable;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @DisplayName("Check Task3 with null args")
    @ParameterizedTest(name = "arr1 = {0}, arr2 = {1}")
    @MethodSource("provideArgsWithNull")
    public void isNestableWithNullArgsTest(int[] nestingArr, int[] toNestArr) {
        boolean isNestable = isNestable(nestingArr, toNestArr);
        assertThat(isNestable).isFalse();
    }

    private static Stream<Arguments> provideArgsWithNull() {
        return Stream.of(
            Arguments.of(null, null),
            Arguments.of(new int[] {1, 2, 3}, null)
        );
    }

    @DisplayName("Check Task3 able to nest")
    @ParameterizedTest(name = "arr1 = {0}, arr2 = {1}")
    @MethodSource("provideNestableArrs")
    public void nestableArrsTest(int[] nestingArr, int[] toNestArr) {
        boolean isNestable = isNestable(nestingArr, toNestArr);
        assertThat(isNestable).isTrue();
    }

    private static Stream<Arguments> provideNestableArrs() {
        return Stream.of(
            Arguments.of(new int[] {1, 2}, new int[] {0, 10, 3, 9}),
            Arguments.of(new int[] {1}, new int[] {0, 10, 3, 9}),
            Arguments.of(new int[] {1, 2, 4, 5}, new int[] {0, 10}),
            Arguments.of(new int[0], new int[] {0}),
            Arguments.of(new int[0], new int[0])
        );
    }

    @DisplayName("Check Task3 not able to nest")
    @ParameterizedTest(name = "arr1 = {0}, arr2 = {1}")
    @MethodSource("provideNonNestableArrs")
    public void nonNestableArrsTest(int[] nestingArr, int[] toNestArr) {
        boolean isNestable = isNestable(nestingArr, toNestArr);
        assertThat(isNestable).isFalse();
    }

    private static Stream<Arguments> provideNonNestableArrs() {
        return Stream.of(
            Arguments.of(new int[] {1, 2}, new int[] {1, 10, 3, 9}),
            Arguments.of(new int[] {1}, new int[] {}),
            Arguments.of(new int[] {1, 2, 4, 5}, new int[] {0, 3}),
            Arguments.of(new int[] {3}, new int[] {1}),
            Arguments.of(new int[] {3}, new int[] {4, 5, 6})
        );
    }


}

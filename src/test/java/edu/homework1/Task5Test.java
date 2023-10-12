package edu.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static edu.homework1.Task5.isPalindromeDescendant;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    @DisplayName("Check Task5 with no palindrome")
    @ParameterizedTest(name = "num = {0}")
    @ValueSource(ints = {
        0,
        -9,
        50,
        143,
        5325
    })
    public void isNotPalindromeDescendantTest(int num) {
        boolean isPalindromeDescendant = isPalindromeDescendant(num);
        assertThat(isPalindromeDescendant).isFalse();
    }

    @DisplayName("Check Task5 with palindrome")
    @ParameterizedTest(name = "num = {0}")
    @ValueSource(ints = {
        11,
        121,
        65,
        -11211230
    })
    public void isPalindromeDescendantTest(int num) {
        boolean isPalindromeDescendant = isPalindromeDescendant(num);
        assertThat(isPalindromeDescendant).isTrue();
    }
}

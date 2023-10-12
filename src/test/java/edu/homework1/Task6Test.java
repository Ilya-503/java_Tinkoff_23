package edu.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static edu.homework1.Task6.countK;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    @DisplayName("Check Task6 with illegal data")
    @ParameterizedTest(name = "num = {0}")
    @ValueSource(ints = {
        0,
        1000,
        5555,
        9999,
        100000
    })
    public void countKWithIllegalDataTest(int num) {
        int kDepth = countK(num);
        assertThat(kDepth).isEqualTo(-1);
    }

    @DisplayName("Check Task6 with legal data")
    @ParameterizedTest(name = "num = {0}")
    @CsvSource({
        "6621, 5",
        "6554, 4",
        "1234, 3 "
    })
    public void countKWithLegalDataTest(int num, int expectedDepth) {
        int kDepth = countK(num);
        assertThat(kDepth).isEqualTo(expectedDepth);
    }
}

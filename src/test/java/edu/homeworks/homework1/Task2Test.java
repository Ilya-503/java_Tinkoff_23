package edu.homeworks.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.homeworks.homework1.Task2.getNumLen;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @DisplayName("Check Task2 with legal data")
    @ParameterizedTest(name = "num = {0}")
    @CsvSource({
        "-432, 3",
        "0, 1",
        "-0, 1",
        "-4200, 4"
    })
    public void getNumLenWithLegalDataTest(int num, int expectedNumLen) {
        int numLen = getNumLen(num);
        assertThat(numLen).isEqualTo(expectedNumLen);
    }
}

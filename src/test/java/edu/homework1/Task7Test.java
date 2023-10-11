package edu.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.homework1.Task7.Task7.rotateLeft;
import static edu.homework1.Task7.Task7.rotateRight;
import static org.assertj.core.api.Assertions.assertThat;

class Task7Test {

    @DisplayName("Check rotation with illegal arguments")
    @ParameterizedTest(name = "num = {0}, shift = {1}")
    @CsvSource({
        "-1, 3",
        "4, -4",
    })
    public void rotateWithIllegalArgsTest(int num, int shiftBit) {
        int rotatedNum = rotateLeft(num, shiftBit);
        assertThat(rotatedNum).isEqualTo(-1);
    }

    @DisplayName("Check left rotate")
    @ParameterizedTest(name = "num = {0}, shift = {1}")
    @CsvSource({
        "9, 1, 3",
        "9, 4, 9",
        "135, 3, 60",
        "1, 10, 1",
        "10, 0, 10",
        "2, 20, 2"
    })
    public void rotateLeftTest(int num, int shiftBit, int expectedNum) {
        int rotatedNum = rotateLeft(num, shiftBit);
        assertThat(rotatedNum).isEqualTo(expectedNum);
    }

    @DisplayName("Check right rotate")
    @ParameterizedTest(name = "num = {0}, shift = {1}")
    @CsvSource({
        "9, 1, 12",
        "1, 10, 1",
        "10, 0, 10",
        "135, 3, 240",
        "2, 20, 2"
    })
    public void rotateRightTest(int num, int shiftBit, int expectedNum) {
        int rotatedNum = rotateRight(num, shiftBit);
        assertThat(rotatedNum).isEqualTo(expectedNum);
    }
}

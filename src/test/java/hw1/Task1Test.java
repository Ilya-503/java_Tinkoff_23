package hw1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static hw1.Task1.getVideoLenInSec;

public class Task1Test {
    private static StringBuilder strBuilder;


    @BeforeAll
    public static void setUp() {
        strBuilder = new StringBuilder();
    }

    @BeforeEach
    public void cleanStrBuilder() {
        strBuilder.setLength(0);
    }

    @DisplayName("Check Task1 with legal data")
    @ParameterizedTest(name = "mins = {0}, secs = {1}")
    @CsvSource({
        "21, 54",
        "00, 58",
        "00, 00",
        "58, 00",
        "432, 21"
    })
    public void getVideoLenWithLegalArgsTest(int minutes, int seconds) {
        strBuilder
            .append(minutes)
            .append(":")
            .append(seconds);

        int videoLen = getVideoLenInSec(strBuilder.toString());
        assertThat(videoLen).isEqualTo(minutes * 60 + seconds);
    }

    @DisplayName("Check Task1 with illegal int args")
    @ParameterizedTest(name = "mins = {0}, secs = {1}")
    @CsvSource({
        "-21, 43",
        "21, -43",
        "43, 61",
        "43, -01"
    })
    public void getVideoLenWithIllegalIntArgsTest(int minutes, int seconds) {
        strBuilder
            .append(minutes)
            .append(":")
            .append(seconds);

        int videoLen = getVideoLenInSec(strBuilder.toString());
        assertThat(videoLen).isEqualTo(-1);

    }

    @DisplayName("Check Task1 with illegal data")
    @ParameterizedTest()
    @ValueSource(strings = {
        "432:fds",
        ":",
        "gs:fsd:fs",
        "ga:fd",
        ":fdf",
        "fs:"
    })
    public void getVideoLenWithIllegalArgsTest(String videoLenStr) {
        int videoLen = getVideoLenInSec(videoLenStr);
        assertThat(videoLen).isEqualTo(-1);
    }
}

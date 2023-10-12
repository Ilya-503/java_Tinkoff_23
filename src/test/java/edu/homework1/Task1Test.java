package edu.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static edu.homework1.Task1.getVideoLenInSec;

public class Task1Test {

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
        String videoLenStr = getVideoLenString(minutes, seconds);
        int videoLen = getVideoLenInSec(videoLenStr);
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
        String videoLenStr = getVideoLenString(minutes, seconds);
        int videoLen = getVideoLenInSec(videoLenStr);
        assertThat(videoLen).isEqualTo(-1);
    }

    @DisplayName("Check Task1 with illegal data")
    @ParameterizedTest()
    @ValueSource(strings = {
        "432:fds",
        ":",
        "",
        "gs:fsd:fs",
        "ga:fd",
        ":fdf",
        "fs:"
    })
    public void getVideoLenWithIllegalArgsTest(String videoLenStr) {
        int videoLen = getVideoLenInSec(videoLenStr);
        assertThat(videoLen).isEqualTo(-1);
    }

    private static String getVideoLenString(int mins, int secs) {
        return new StringBuilder()
            .append(mins)
            .append(":")
            .append(secs == 0 ? "00" : secs)
            .toString();
    }
}

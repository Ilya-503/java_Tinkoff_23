package edu.homeworks.hw_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static edu.homeworks.hw_3.Task4.intToRoman;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Task4Test {

    @DisplayName("Check legal to roman convert")
    @ParameterizedTest(name = "num= {0}")
    @CsvSource({
        "1, I",
        "8, VIII",
        "999, CMXCIX",
        "556, DLVI"
    })
    public void legalIntToRomanConvert(int num, String expectedRoman) {
        var roman = intToRoman(num);

        assertThat(roman).isEqualTo(expectedRoman);
    }


    @DisplayName("Check illegal to roman convert")
    @ParameterizedTest(name = "num= {0}")
    @ValueSource(ints = {-23, 0, 10_0000})
    public void illegalToRomanConvert(int num) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> intToRoman(num));
    }
}

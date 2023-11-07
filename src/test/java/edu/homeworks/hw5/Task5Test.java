package edu.homeworks.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.homeworks.hw5.Task5.isLegalRusCarId;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    @DisplayName("check RUS cars ID validation")
    @ParameterizedTest(name = "ID= {0}")
    @MethodSource("carsIDsProvider")
    public void isLegalCarIdTest(String carID, boolean expectedResult) {
        boolean result = isLegalRusCarId(carID);
        assertThat(result).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> carsIDsProvider() {
        return Stream.of(
            Arguments.of("", false),
            Arguments.of("А123ВЕ777 ", false),
            Arguments.of("    А123ВЕ777", false),
            Arguments.of("А123ВЕ777 А123ВЕ777", false),
            Arguments.of("А123ВЕ777", true),
            Arguments.of("О777ОО177", true)
        );
    }
}



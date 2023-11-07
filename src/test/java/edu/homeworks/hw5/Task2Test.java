package edu.homeworks.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import static edu.homeworks.hw5.Task2.getAllFridayThe13InYear;
import static edu.homeworks.hw5.Task2.getNextCloserFridayThe13Date;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @DisplayName("Check allFridays13InGivenYear")
    @ParameterizedTest(name = "year= {0}")
    @MethodSource("yearsForAllFridays13Provider")
    public void getAllFridays13Test(int year, List<LocalDate> expectedDates) {
        var dates = getAllFridayThe13InYear(year);
        assertThat(dates).isEqualTo(expectedDates);
    }

    public static Stream<Arguments> yearsForAllFridays13Provider() {
        return Stream.of(
            Arguments.of(
                0, List.of()
            ),
            Arguments.of(
                -200, List.of()
            ),
            Arguments.of(1925, List.of(
                LocalDate.of(1925, 2, 13),
                LocalDate.of(1925, 3, 13),
                LocalDate.of(1925, 11, 13)
            ))
        );
    }

    @DisplayName("Check closerFridayThe13Date")
    @ParameterizedTest(name = "date= {0}")
    @MethodSource("datesForCloserFriday13DateProvider")
    public void getCloseFriday13DateTest(LocalDate date, LocalDate expectedDate) {
       var closerDate = getNextCloserFridayThe13Date(date);
       assertThat(closerDate).isEqualTo(expectedDate);
    }

    public static Stream<Arguments> datesForCloserFriday13DateProvider() {
        return Stream.of(
            Arguments.of(
                LocalDate.of(2024, 9, 13),
                LocalDate.of(2024, 9, 13)
            ),
            Arguments.of(
                LocalDate.of(2024, 9, 14),
                LocalDate.of(2024, 12, 13)
            ),
            Arguments.of(
                LocalDate.of(2023, 11, 14),
                LocalDate.of(2024, 9, 13))
        );
    }
}

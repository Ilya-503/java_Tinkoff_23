package edu.homeworks.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.Month.FEBRUARY;

public final class Task2 {

    private Task2() {
    }

    public static LocalDate getNextCloserFridayThe13(LocalDate date) {

        var fridayThe13Dates = getAllFridayThe13InYear(date.getYear());
        for (var fridayDate: fridayThe13Dates) {
            if (fridayDate.isAfter(date)) {
                return fridayDate;
            }
        }
        return null;
    }



    @SuppressWarnings("MagicNumber") // doesn't like 13
    public static List<LocalDate> getAllFridayThe13InYear(int year) {
        return getAllDatesWithNeededDayOfWeek(FRIDAY, 13, year);
    }

    private static List<LocalDate>
    getAllDatesWithNeededDayOfWeek(DayOfWeek dayOfWeek, int day, int year) {

        List<LocalDate> dates = new ArrayList<>();
        boolean isNotLeapYear = !(Year.isLeap(year));

        if (day < 1 || year < 1) {
            return dates;
        }


        for (var month: Month.values()) {

            if (month.maxLength() < day || month == FEBRUARY && day == FEBRUARY.maxLength() && isNotLeapYear) {
                continue;
            }

            if (Year.of(year).atMonth(month).atDay(day).getDayOfWeek() == dayOfWeek) {
                dates.add(LocalDate.of(year, month, day));
            }
        }
        return dates;
    }
}

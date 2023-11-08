package edu.homeworks.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.Month.FEBRUARY;

public final class Task2 {

    private static final int UNLUCKY_FRIDAY_DAY = 13;
    private static final int MAX_YEARS_TO_ADD = 5;

    private Task2() {
    }

    public static LocalDate getNextCloserFridayThe13Date(LocalDate date) throws NullPointerException {
        if (date == null) {
            throw new NullPointerException("input data is null");
        }

        TemporalAdjuster closerFriday13 = TemporalAdjusters.ofDateAdjuster(inputDate -> {
            int year = inputDate.getYear();
            List<LocalDate> fridayThe13DatesList;

            do {
                fridayThe13DatesList = getAllFridayThe13InYear(year++);
                for (var fridayDate : fridayThe13DatesList) {
                    if (fridayDate.isEqual(date) || fridayDate.isAfter(date)) {
                        return fridayDate;
                    }
                }
            } while (year <= year + MAX_YEARS_TO_ADD);

            throw new NullPointerException("Couldn't find closer friday the 13");
        });

        return date.with(closerFriday13);
    }

    public static List<LocalDate> getAllFridayThe13InYear(int year) {
        return getAllDatesWithNeededDayOfWeek(FRIDAY, UNLUCKY_FRIDAY_DAY, year);
    }

    private static List<LocalDate>
    getAllDatesWithNeededDayOfWeek(DayOfWeek dayOfWeek, int day, int year) {

        List<LocalDate> dates = new ArrayList<>();
        boolean isNotLeapYear = !(Year.isLeap(year));

        if (dayOfWeek == null || day < 1 || year < 1) {
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

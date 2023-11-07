package edu.homeworks.hw5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task1 {
    private static final Pattern LEGAL_DATE_STRING_REGEX =
        Pattern.compile("^(\\d{4}-\\d{2}-\\d{2}), (\\d{2}:\\d{2}) - (\\d{4}-\\d{2}-\\d{2}), (\\d{2}:\\d{2})$");

    private Task1() {
    }

    @SuppressWarnings("MagicNumber")
    public static Duration getAverageDuration(List<String> datesStr) throws IllegalArgumentException {
        if (datesStr == null || datesStr.isEmpty()) {
            throw new IllegalArgumentException("Input list is empty");
        }

        Duration duration = Duration.ZERO;

        for (var dateStr: datesStr) {
            Matcher matcher = LEGAL_DATE_STRING_REGEX.matcher(dateStr);
            if (!matcher.matches() | matcher.groupCount() != 4) {
                throw new IllegalArgumentException("Illegal string date format: " + dateStr);
            }

            try {
                LocalDate startDate = LocalDate.parse(matcher.group(1));
                LocalTime startTime = LocalTime.parse(matcher.group(2));

                LocalDate endDate = LocalDate.parse(matcher.group(3));
                LocalTime endTime = LocalTime.parse(matcher.group(4));

                duration = duration.plus(
                    Duration.between(startDate.atTime(startTime), endDate.atTime(endTime))
                );
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException(ex.getMessage());
            }
        }
        return duration.dividedBy(datesStr.size());
    }
}

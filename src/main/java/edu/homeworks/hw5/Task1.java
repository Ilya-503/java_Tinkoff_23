package edu.homeworks.hw5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task1 {
    private static final Pattern LEGAL_DATE_STRING_REGEX =
        Pattern.compile("^(\\d{4}-\\d{2}-\\d{2}), (\\d{2}:\\d{2}) - (\\d{4}-\\d{2}-\\d{2}), (\\d{2}:\\d{2})$");

    private static final int GROUPS_AMOUNT_IN_DATE_STRING = 4;

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
            if (!matcher.matches() | matcher.groupCount() != GROUPS_AMOUNT_IN_DATE_STRING) {
                throw new IllegalArgumentException("Illegal string date format: " + dateStr);
            }

            try {
                var startDateTime = getDateTime(matcher.group(1), matcher.group(2));
                var endDateTime = getDateTime(matcher.group(3), matcher.group(4));

                if (startDateTime.isAfter(endDateTime)) {
                    throw new IllegalArgumentException("End date before start date");
                }

                duration = duration.plus(
                    Duration.between(startDateTime, endDateTime)
                );
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException(ex.getMessage());
            }
        }
        return duration.dividedBy(datesStr.size());
    }

    private static LocalDateTime getDateTime(String dateStr, String timeStr) {
        return LocalDate
            .parse(dateStr)
            .atTime(
                LocalTime.parse(timeStr)
            );
    }
}

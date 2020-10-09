package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Map;

public class Task030Impl implements Task030 {
    /**
     * Get amount of days between two dates.
     *
     * @param dateStart first date
     * @param dateEnd   second date
     * @return amount of days
     */
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        if (dateStart == null || dateEnd == null) {
            throw new IllegalArgumentException();
        }
        int years = dateEnd.getYear() - dateStart.getYear();
        int days = dateEnd.getDayOfYear() - dateStart.getDayOfYear();
        int result = years * 365 + days;
        return result;
    }

    /**
     * Add designated amount of days to <code>dateStart</code>.
     *
     * @param dateStart date to adjust
     * @param daysToAdd amount of days to add
     * @return adjusted date
     */
    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        LocalDate result = dateStart.plusDays(daysToAdd);
        return result;
    }

    /**
     * Get amount of seconds between two instants.
     *
     * @param instantStart first instant
     * @param instantEnd   second instant
     * @return amount of seconds
     */
    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        return instantEnd.getEpochSecond() - instantStart.getEpochSecond();
    }

    /**
     * Get day of week of the given date.
     *
     * @param localDate date to check
     * @return day of week
     */
    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        return localDate.getDayOfWeek();
    }

    /**
     * Calculate date of the nearest weekend start.
     *
     * @param localDate date to start
     * @return weekend start date
     */
    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        int day = localDate.getDayOfWeek().getValue();
        int shift = 6 - day;
        return localDate.plusDays(shift);
    }

    /**
     * Get local time from given string.
     *
     * @param timeString string with time
     * @return local time
     */
    @Override
    public LocalTime getLocalTime(String timeString) {
        Map<Long, String> ampmStrings = Map.of(0L, "AM", 1L, "PM");
        DateTimeFormatter timeFormatter = new DateTimeFormatterBuilder()
                .appendPattern("hh:mm")
                .appendText(ChronoField.AMPM_OF_DAY, ampmStrings)
                .toFormatter();
        LocalTime time = LocalTime.parse(timeString, timeFormatter);

        return time;
    }
}

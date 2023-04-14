package com.platform.utils;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;


public class NextWorkingDay {
    public static TemporalAdjuster toNextWorkingDay() {
        return TemporalAdjusters.ofDateAdjuster(temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

            int dayToAdd = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            }
            if (dayOfWeek == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
    }
}

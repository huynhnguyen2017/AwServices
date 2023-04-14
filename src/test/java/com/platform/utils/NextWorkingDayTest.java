package com.platform.utils;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@QuarkusTest
class NextWorkingDayTest {

    @Test
    void toNextWorkingDay_givenFriday_returnNextMonday() {
        LocalDate today = LocalDate.of(2023, 03, 31);
        LocalDate actual = today.with(NextWorkingDay.toNextWorkingDay());

        Assertions.assertEquals("2023-04-03", actual.format(DateTimeFormatter.ISO_DATE));
    }

    @Test
    void getTimeZone_noGiven_returnDefaultTimeZoneOnSystem() {

        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        Assertions.assertEquals(ZoneId.of("Asia/Saigon"), zoneId);
    }

    @Test
    void checkTimeZoneSaigon_noGiven_returnDateWithTimeZoneIsSaiGon() {
        ZoneId saiGonTimeZone = TimeZone.getDefault().toZoneId();

        LocalDate today = LocalDate.of(2023, 04, 02);

        ZonedDateTime todayInTimeZoneSaigon = today.atStartOfDay(saiGonTimeZone);

        Assertions.assertEquals(LocalDate.of(2023, 04, 02).atStartOfDay(ZoneId.of("Asia/Saigon")), todayInTimeZoneSaigon);
    }
}
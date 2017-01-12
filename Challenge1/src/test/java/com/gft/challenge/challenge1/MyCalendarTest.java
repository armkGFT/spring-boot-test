package com.gft.challenge.challenge1;

import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyCalendarTest {

    @Test
    public void shouldReturnTuesdayWhenGivenMonday() {

        // given
        LocalDate startDate = LocalDate.of(2016, 9, 19);
        LocalDate expectedDate = LocalDate.of(2016, 9, 20);
        MyCalendar myCalendar= new MyCalendar(startDate);

        // when
        LocalDate actualDate = myCalendar.next();

        // then
        Assert.assertEquals(expectedDate, actualDate);
    }

    @Test
    public void shouldReturnFridayWhenGivenWednesday() {
        // given
        LocalDate startDate = LocalDate.of(2016, 9, 21);
        LocalDate expectedDate = LocalDate.of(2016, 9, 23);
        MyCalendar myCalendar= new MyCalendar(startDate);

        // when
        LocalDate actualDate = myCalendar.next();

        // then
        Assert.assertEquals(expectedDate, actualDate);

    }

    @Test
    public void shouldReturnTuesdayWhenGivenFriday() {
        // given
        LocalDate startDate = LocalDate.of(2016, 9, 23);
        MyCalendar myCalendar= new MyCalendar(startDate);

        // when
        LocalDate actualDate = myCalendar.next();

        // then
        Assert.assertEquals(DayOfWeek.TUESDAY, actualDate.getDayOfWeek());

    }

    @Test
    public void shouldReturnFridayWenGivenTuesday() {
        // given
        LocalDate startDate = LocalDate.of(2016, 9, 20);
        MyCalendar myCalendar= new MyCalendar(startDate);

        // when
        LocalDate actualDate = myCalendar.next();

        // then
        Assert.assertEquals(DayOfWeek.FRIDAY, actualDate.getDayOfWeek());
    }

    @Test
    public void shouldReturnConsecutiveMeetingDates() {

        // given
        LocalDate startDate = LocalDate.of(2016, 9, 19);
        List<LocalDate> expectedDates = new ArrayList<>();
        expectedDates.add(LocalDate.of(2016, 9, 20));
        expectedDates.add(LocalDate.of(2016, 9, 23));
        expectedDates.add(LocalDate.of(2016, 9, 27));
        expectedDates.add(LocalDate.of(2016, 9, 30));

        MyCalendar myCalendar = new MyCalendar(startDate);
        List<LocalDate> actualDates = new ArrayList<>();

        // when
        for (int i = 0; i < expectedDates.size(); i++) {
            LocalDate date = myCalendar.next();
            actualDates.add(date);
        }

        // then
        Assert.assertArrayEquals(expectedDates.toArray(), actualDates.toArray());
    }
}
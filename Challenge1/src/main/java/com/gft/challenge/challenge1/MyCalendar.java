package com.gft.challenge.challenge1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Iterator;

/**
 * Created by armk on 2017-01-11.
 */
public class MyCalendar implements Iterator<LocalDate> {

    private static final TemporalAdjuster NEXT_TUESDAY = TemporalAdjusters.next(DayOfWeek.TUESDAY);
    private static final TemporalAdjuster NEXT_FRIDAY = TemporalAdjusters.next(DayOfWeek.FRIDAY);

    private LocalDate currentDate;

    public MyCalendar(LocalDate startDate) {
        this.currentDate = startDate;
    }


    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public LocalDate next() {

        LocalDate nextTuesday = currentDate.with(NEXT_TUESDAY);
        LocalDate nextFriday = currentDate.with(NEXT_FRIDAY);

        currentDate = (nextTuesday.isBefore(nextFriday)) ? nextTuesday : nextFriday;
        return currentDate;
    }
}

package com.gft.challenge.challenge1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Iterator;

final class MyCalendar implements Iterator<LocalDate> {

    private static final TemporalAdjuster NEXT_TUESDAY = TemporalAdjusters.next(DayOfWeek.TUESDAY);
    private static final TemporalAdjuster NEXT_FRIDAY = TemporalAdjusters.next(DayOfWeek.FRIDAY);

    private LocalDate currentDate;

    MyCalendar(LocalDate startDate) {
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

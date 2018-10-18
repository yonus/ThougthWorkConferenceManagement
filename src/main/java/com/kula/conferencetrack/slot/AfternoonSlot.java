package com.kula.conferencetrack.slot;

import java.time.Duration;
import java.time.LocalTime;

public class AfternoonSlot extends Slot {


    public static final LocalTime START_TIME = LocalTime.of(13,0);
    public static final Duration TOTAL_DURATION =  Duration.ofMinutes(240);

    @Override
    LocalTime getStartTime() {
        return   START_TIME;
    }

    @Override
    Duration getTotalDuration() {
        return  TOTAL_DURATION;
    }
}

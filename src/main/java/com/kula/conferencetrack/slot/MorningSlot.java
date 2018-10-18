package com.kula.conferencetrack.slot;

import java.time.Duration;
import java.time.LocalTime;

public class MorningSlot extends Slot {

    public static final LocalTime START_TIME = LocalTime.of(9,0);
    public static final Duration TOTAL_DURATION =  Duration.ofHours(3);

    @Override
    LocalTime getStartTime() {
        return   START_TIME;
    }

    @Override
    Duration getTotalDuration() {
        return  TOTAL_DURATION;
    }
}

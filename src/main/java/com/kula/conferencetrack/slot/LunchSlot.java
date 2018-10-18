package com.kula.conferencetrack.slot;

import com.kula.conferencetrack.model.event.LunchEvent;

import java.time.Duration;
import java.time.LocalTime;

public class LunchSlot extends Slot {
    public static final LocalTime START_TIME = LocalTime.of(12,0);
    public static final Duration TOTAL_DURATION =  Duration.ofHours(1);

     public  LunchSlot(){
         addEvent(new LunchEvent());
     }

    @Override
    LocalTime getStartTime() {
        return   START_TIME;
    }

    @Override
    Duration getTotalDuration() {
        return  TOTAL_DURATION;
    }



}

package com.kula.conferencetrack.slot;


import com.kula.conferencetrack.model.event.NetworkEvent;

import java.time.Duration;
import java.time.LocalTime;

public class NetworkingSlot extends  Slot {

    public static final LocalTime START_TIME = LocalTime.of(17,0);
    public static final Duration TOTAL_DURATION =  Duration.ofMinutes(30);

    public  NetworkingSlot(){
        addEvent(new NetworkEvent());
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

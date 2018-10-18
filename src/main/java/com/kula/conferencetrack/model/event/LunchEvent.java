package com.kula.conferencetrack.model.event;

import com.kula.conferencetrack.constants.ConferenceTrackConstants;

import java.time.Duration;
import java.time.LocalTime;

public class LunchEvent extends Event {

    public static final LocalTime START_TIME = LocalTime.of(12,0);
    public static final Duration MAX_DURATION =  Duration.ofMinutes(60);
    public static final String TITLE = "Lunch";

    public LunchEvent() {
        super(TITLE, START_TIME, MAX_DURATION);
    }
}

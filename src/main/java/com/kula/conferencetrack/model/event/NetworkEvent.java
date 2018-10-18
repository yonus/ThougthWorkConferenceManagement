package com.kula.conferencetrack.model.event;

import com.kula.conferencetrack.constants.ConferenceTrackConstants;

import java.time.Duration;
import java.time.LocalTime;

public class NetworkEvent extends Event {

    public static final LocalTime START_TIME = LocalTime.of(17,0);
    public static final Duration MAX_DURATION =  Duration.ofMinutes(1);
    public static final String TITLE = "Networking";

    public NetworkEvent() {

        super(TITLE, START_TIME, MAX_DURATION);
    }
}

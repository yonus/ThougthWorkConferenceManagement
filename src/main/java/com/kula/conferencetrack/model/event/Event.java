package com.kula.conferencetrack.model.event;

import java.time.Duration;
import java.time.LocalTime;

public class Event {

    private String title;
    private LocalTime startTime;
    private Duration durationInMunute;

    public Event(String title, LocalTime startTime, Duration durationInMunute) {
        this.title = title;
        this.startTime = startTime;
        this.durationInMunute = durationInMunute;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public Duration getDurationInMunute() {
        return durationInMunute;
    }

    public void setDurationInMunute(Duration durationInMunute) {
        this.durationInMunute = durationInMunute;
    }
}

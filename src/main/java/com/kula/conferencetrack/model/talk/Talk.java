package com.kula.conferencetrack.model.talk;

import java.time.Duration;

/**
 * Model for talk  title and duration information
 */
public class Talk implements Comparable<Talk>{

    private  String title;

    private Duration durationMunite;

    public Talk (String  title , int duration){
        this.title = title;
        this.durationMunite = Duration.ofMinutes(duration);
    }

    public Talk (String  title , Duration duration){
        this.title = title;
        this.durationMunite = duration;
    }


    public Duration getDurationMunite() {
        return durationMunite;
    }


    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Talk talk) {
        if((talk.durationMunite.toMinutes() > this.durationMunite.toMinutes())){
            return 1;
        }
        else{
            return -1;
        }
    }
}

package com.kula.conferencetrack.model.talk;

import java.time.Duration;


public class LightningTalk extends Talk {

    public LightningTalk(String title) {
        super(title, Duration.ofMinutes(5));
    }

}

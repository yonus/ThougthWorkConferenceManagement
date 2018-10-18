package com.kula.conferencetrack.model;

import com.kula.conferencetrack.slot.LunchSlot;
import com.kula.conferencetrack.slot.MorningSlot;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrackTest {

    @Test
    public void addSlot() {
        Track track = new Track(1);
        track.addSlot(new MorningSlot());
        track.addSlot(new LunchSlot());
        Assert.assertTrue(track.getSlots().size() == 2);

    }

    @Test
    public void getTrackNumber() {
        Track track = new Track(3);
        Assert.assertTrue(track.getTrackNumber() == 3);
    }
}
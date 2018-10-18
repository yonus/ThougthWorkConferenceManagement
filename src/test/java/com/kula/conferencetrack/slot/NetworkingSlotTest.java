package com.kula.conferencetrack.slot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NetworkingSlotTest {
    private Slot slot;

    @Before
    public void setUp(){
        slot = new NetworkingSlot();
    }

    @Test
    public void getStartTime() {
        Assert.assertTrue(slot.getStartTime().equals(NetworkingSlot.START_TIME));
    }

    @Test
    public void getTotalDuration() {
      Assert.assertTrue(slot.getTotalDuration().equals(NetworkingSlot.TOTAL_DURATION));
    }
}
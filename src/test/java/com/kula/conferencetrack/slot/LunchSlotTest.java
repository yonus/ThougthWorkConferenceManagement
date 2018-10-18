package com.kula.conferencetrack.slot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class LunchSlotTest{
    private  Slot slot;

    @Before
    public void setUp(){
         slot = new LunchSlot();
    }


    @Test
    public void getStartTime(){
        LocalTime lunchStartTime = LocalTime.of(12,0);
        Assert.assertTrue(lunchStartTime.equals(slot.getStartTime()));
    }

    @Test
    public void addEvent_notaAddedOtherEvent(){
        boolean success = slot.addEvent("Event1", Duration.ofMinutes(10));
        Assert.assertFalse(success);
    }


}
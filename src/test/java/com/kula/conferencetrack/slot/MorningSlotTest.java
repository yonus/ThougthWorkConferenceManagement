package com.kula.conferencetrack.slot;

import com.kula.conferencetrack.model.event.Event;
import com.kula.conferencetrack.model.event.LunchEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;

public class MorningSlotTest {

    private Slot slot;

    @Before
    public void setUp(){
        slot = new MorningSlot();
    }


    @Test
    public void addEvent_startTime(){

        slot.addEvent("Event1", Duration.ofMinutes(60));
        slot.addEvent("Event2", Duration.ofMinutes(40));
        slot.addEvent("Event3" ,Duration.ofMinutes(40));


        List<Event> events = slot.getEvents();
        if(events == null || events.size() !=  3){
            Assert.fail();
        }
        LocalTime  currentEventStartTime = slot.getStartTime();
        boolean  isAllEventStartTimeTrue = true;
        for(Event event : events){
            if(!event.getStartTime().equals(currentEventStartTime)){
                isAllEventStartTimeTrue = false;
                break;
            }

            currentEventStartTime = currentEventStartTime.plusMinutes(event.getDurationInMunute().toMinutes());
        }
        Assert.assertTrue(isAllEventStartTimeTrue);


    }

    @Test
    public void addEvent_withNotValidStartTimeEvent(){
        boolean success = slot.addEvent(new LunchEvent());
        Assert.assertFalse(success);

    }



}
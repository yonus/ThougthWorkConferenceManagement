package com.kula.conferencetrack.slot;

import com.kula.conferencetrack.model.event.Event;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The abstract class keeps list of event and provides
 * methods adding event by using method implemented in subclass/concrete class
 */
public abstract class  Slot {

    protected List<Event> events = new ArrayList<>();

    private int usedDuration;

    /**
     *
     * @return Starting  time of slot
     */
    abstract  LocalTime getStartTime();



    /**
     *
     * @return Total Max duration for the slot
     */
    abstract Duration getTotalDuration();

    /**
     * Accumulate duration im minutes if  sum of  usedDuration and duration   is less than or total
     * avaliable duration for slot  , then used duration is added to this duration
     * @param duration
     * @return true if duration is accumulated
     */
    private boolean accumulateDuration(int duration){
        int totalUsedDuration = usedDuration + duration;
        if(totalUsedDuration > getTotalDuration().toMinutes()){
            return false;
        }
        usedDuration = totalUsedDuration;
        return true;

    }

    /**
     * Add event to slot if  event duration is less than avaliable duration or
     * event start time is before than max finish time of slot
     * @param event
     * @return true if event is added to slot
     */
    public boolean addEvent(Event event){
      LocalTime eventStartTime = event.getStartTime();
      LocalTime slotMaxFinishTime  = getStartTime().plusMinutes(getTotalDuration().toMinutes());
      if(eventStartTime.isBefore(getStartTime()) || slotMaxFinishTime.equals(eventStartTime) || eventStartTime.isAfter(slotMaxFinishTime)){
          return false;
      }

      if(accumulateDuration((int) event.getDurationInMunute().toMinutes())){
          events.add(event);
          return true;
      }
      return false;
    }


    /**
     * Add event to slot if  event duration is less than avaliable duration
     * @param duration of event
     * @param title of event
     * @return true if event is added to slot
     */
    public boolean addEvent(String title , Duration duration){
        LocalTime eventStartTime = getStartTime().plusMinutes(usedDuration);
        Event event = new Event(title,eventStartTime,duration);
        return addEvent(event);
    }

    /**
     *
     * @return list of event in slot
     */
    public List<Event> getEvents(){
        return events;
    }









}

package com.kula.conferencetrack.model;

import com.kula.conferencetrack.slot.Slot;
import com.kula.conferencetrack.slot.SlotFactory;
import com.kula.conferencetrack.slot.SlotType;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private  List<Slot> slots;
    private  Integer trackNumber;


    public Track(Integer trackNumber){
        this.trackNumber = trackNumber;
        slots  = new ArrayList<>();
    }

    /**
     * Add new Slot to Track
     * @param slot
     * @return
     */
    public  boolean addSlot(Slot slot){
        return slots.add(slot);
    }

    /**
     * Create and Add slot to track
     * @param slotType
     * @return  created slot
     */
    public Slot createSlot(SlotType slotType){
       Slot slot = SlotFactory.getSlot(slotType);
       addSlot(slot);
       return slot;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }
}

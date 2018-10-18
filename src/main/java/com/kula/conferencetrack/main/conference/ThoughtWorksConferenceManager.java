package com.kula.conferencetrack.main.conference;


import com.kula.conferencetrack.exception.ConferenceManagementException;
import com.kula.conferencetrack.model.Track;
import com.kula.conferencetrack.model.talk.Talk;
import com.kula.conferencetrack.reader.TalkReader;
import com.kula.conferencetrack.slot.Slot;
import com.kula.conferencetrack.slot.SlotType;
import com.kula.conferencetrack.writer.ConferenceWriter;

import java.io.IOException;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.function.Supplier;

public class ThoughtWorksConferenceManager implements ConferenceManager {

    private  TalkReader talkReader;
    private  ConferenceWriter conferenceWriter;

    public ThoughtWorksConferenceManager(TalkReader talkReader, ConferenceWriter conferenceWriter){
        this.talkReader = talkReader;
        this.conferenceWriter = conferenceWriter;
    }




    @Override
    public Conference schedule() throws ConferenceManagementException {
        try {
            Conference conference = new Conference();
            SortedSet<Talk> talks = readTalks();
            Integer trackNumber = 1;
            while(talks.size() > 0){
                Track track = new Track(trackNumber);
                Slot slot = track.createSlot(SlotType.MORNING);
                addTalksToSlot(slot, talks);
                track.createSlot(SlotType.LUNCH);
                slot = track.createSlot(SlotType.AFTERNON);
                addTalksToSlot(slot, talks);
                track.createSlot(SlotType.NETWORK);
                conference.addTrack(track);
                trackNumber++;
            }
            return conference;
        } catch (IOException e) {
            throw  new ConferenceManagementException("IO exception" , e);
        }
    }

    @Override
    public Supplier<TalkReader> getTalkReaderSupplier() {
        return () -> talkReader;
    }

    @Override
    public Supplier<ConferenceWriter> getConferenceWriterSupplier() {
         return () -> conferenceWriter;
    }

    /**
     * Add talks to slot as event.
     * @param slot
     * @param talks
     */
    public  void addTalksToSlot(Slot slot , SortedSet<Talk> talks){
        Iterator<Talk> talkIterator = talks.iterator();
        while (talkIterator.hasNext()){
            Talk talk = talkIterator.next();
            boolean isTalkAddedToSlot = slot.addEvent(talk.getTitle(),talk.getDurationMunite());
            if(isTalkAddedToSlot){
                talkIterator.remove();
            }
        }
    }


}

package com.kula.conferencetrack.writer;

import com.kula.conferencetrack.constants.ConferenceTrackConstants;
import com.kula.conferencetrack.main.conference.Conference;
import com.kula.conferencetrack.model.Track;
import com.kula.conferencetrack.model.event.Event;
import com.kula.conferencetrack.slot.Slot;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Provide Methods to write events to .txt file
 */
public class TxtEventWriter implements ConferenceWriter {
    private  String outputFileDirectory;

    public TxtEventWriter(String outputFileDirectory){
        this.outputFileDirectory = outputFileDirectory;
    }

    @Override
    public void write(Conference conference) throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFileDirectory))) {
            for(Track track : conference.getTracks()){
                writer.write("=====Track" + track.getTrackNumber()+"===\n");
                for (Slot slot : track.getSlots()){
                    for (Event event:slot.getEvents()){
                        writer.write(event.getStartTime().format(ConferenceTrackConstants.eventTimeFormatter) + " " + event.getTitle()+"\n");
                    }
                }

            }

        }

    }


}

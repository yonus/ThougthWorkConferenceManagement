package com.kula.conferencetrack.main;

import com.kula.conferencetrack.constants.ConferenceTrackConstants;
import com.kula.conferencetrack.exception.ConferenceManagementException;
import com.kula.conferencetrack.main.conference.Conference;
import com.kula.conferencetrack.main.conference.ConferenceManager;
import com.kula.conferencetrack.main.conference.ThoughtWorksConferenceManager;
import com.kula.conferencetrack.reader.TalkReader;
import com.kula.conferencetrack.reader.TxtFileTalkReader;
import com.kula.conferencetrack.writer.ConferenceWriter;
import com.kula.conferencetrack.writer.TxtEventWriter;

import java.time.format.DateTimeFormatter;

public class ConferenceMain {


    public  static void main(String[] args) throws ConferenceManagementException {

     final String inputFileDirectory  = "./src/main/resources/input_talks.txt";
     TalkReader talkReader = new TxtFileTalkReader(inputFileDirectory);

     final String outputEventFileDirectory  = "./src/main/resources/output_events.txt";
     ConferenceWriter conferenceWriter = new TxtEventWriter(outputEventFileDirectory);
     ConferenceManager conferenceManager = new ThoughtWorksConferenceManager(talkReader,conferenceWriter);
     Conference conference = conferenceManager.schedule();
     conferenceManager.writeConference(conference);


    }

    /**
     *
     * @return function for ConferenceWriter  to write console
     */
    public static ConferenceWriter getConsoleConferenceWriter(){
        ConferenceWriter conferenceWriter = (c) ->{
            c.getTracks().forEach(track -> {
                System.out.println("=====Track" + track.getTrackNumber()+"===");
                track.getSlots().forEach(slot -> {

                    slot.getEvents().forEach(event -> {
                        System.out.println(event.getStartTime().format(ConferenceTrackConstants.eventTimeFormatter) + " " + event.getTitle());
                    });
                });
            });
        };

        return conferenceWriter;
    }
}

package com.kula.conferencetrack.main.conference;

import com.kula.conferencetrack.exception.ConferenceManagementException;
import com.kula.conferencetrack.model.talk.Talk;
import com.kula.conferencetrack.reader.TalkReader;
import com.kula.conferencetrack.writer.ConferenceWriter;

import java.io.IOException;
import java.util.SortedSet;
import java.util.function.Supplier;

public interface ConferenceManager {

       Conference schedule() throws ConferenceManagementException;

       Supplier<TalkReader> getTalkReaderSupplier();

       Supplier<ConferenceWriter> getConferenceWriterSupplier();

       default SortedSet<Talk> readTalks() throws IOException {
              return getTalkReaderSupplier().get().read();
       }

       default void writeConference(Conference conference) throws ConferenceManagementException {
              try {
                     getConferenceWriterSupplier().get().write(conference);
              } catch (IOException e) {
                     throw  new ConferenceManagementException("Writing IO error",e);
              }
       }
}

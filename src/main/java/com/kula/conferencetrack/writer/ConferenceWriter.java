package com.kula.conferencetrack.writer;

import com.kula.conferencetrack.main.conference.Conference;

import java.io.IOException;

public interface ConferenceWriter {
      /**
       * Write conference  to related Datasource
       * @param conference
       * @throws IOException
       */
      void write(Conference conference) throws IOException;
}

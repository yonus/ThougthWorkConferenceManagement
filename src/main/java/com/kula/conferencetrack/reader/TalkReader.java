package com.kula.conferencetrack.reader;

import com.kula.conferencetrack.model.talk.Talk;

import java.io.IOException;
import java.util.SortedSet;

public interface TalkReader {

    /**
     *
     * read talks from any datasource like file.
     * and create collection of talks
     * @return list of talks
     */
    SortedSet<Talk> read() throws IOException;

}

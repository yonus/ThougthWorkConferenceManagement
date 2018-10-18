package com.kula.conferencetrack.reader;

import com.kula.conferencetrack.model.talk.Talk;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Set;

public class TxtFileTalkReaderTest {

    @Before
    public void setUp() throws Exception {
    }


    @Test(expected = NoSuchFileException.class)
    public void readFile_withNoSuchtFile() throws IOException {
         String fileDirectory  = "/resource/input.txt";
         TalkReader talkReader = new TxtFileTalkReader(fileDirectory);
         talkReader.read();
    }

    @Test
    public  void readFile_SuccessFully() throws IOException {
        String fileDirectory  = "./src/test/resources/input_talks_test.txt";
        TalkReader talkReader = new TxtFileTalkReader(fileDirectory);
        Set<Talk> talks = talkReader.read();
        Assert.assertEquals(3,talks.size());
    }


}
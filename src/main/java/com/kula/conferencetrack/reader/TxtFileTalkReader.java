package com.kula.conferencetrack.reader;

import com.kula.conferencetrack.constants.ConferenceTrackConstants;
import com.kula.conferencetrack.model.talk.LightningTalk;
import com.kula.conferencetrack.model.talk.Talk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Stream;


/**
 * The class provide  to read  talks from text file
 * and converting into @Talk
 */

public class TxtFileTalkReader implements  TalkReader {

    private  String inputFileDirectory;

    public TxtFileTalkReader(String inputFileDirectory) {
       this.inputFileDirectory = inputFileDirectory;
    }

    @Override
    public SortedSet<Talk> read() throws IOException {

        try(Stream<String> lineStream = Files.lines(Paths.get(inputFileDirectory))) {
            SortedSet<Talk> talks = new TreeSet();
            lineStream.filter(line -> !line.isEmpty()).map(talkConverter()).forEach(talks::add);

            return talks;

        }catch (IOException e){
           throw  e;
        }

    }

    /**
     * return function to convert line to Talk class.
     * @return
     */
    private Function<String,Talk>  talkConverter(){
        return (String line) ->{

            String title = line.substring(0, line.lastIndexOf(" "));
            String talkMinuteInfo = line.substring(line.lastIndexOf(" ") + 1);
            if(ConferenceTrackConstants.LIGHTNING_TALK_MINUTE.equals(talkMinuteInfo)){
              return new LightningTalk(title);
            }else{
                String minutes = talkMinuteInfo.replaceAll("\\D+", "");
                Integer minute = Integer.valueOf(minutes);
                return new Talk(title,minute);
            }

        };
    }
}

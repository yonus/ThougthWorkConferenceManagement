package com.kula.conferencetrack.main.conference;

import com.kula.conferencetrack.model.Track;

import java.util.ArrayList;
import java.util.List;

public class Conference {

    private List<Track> tracks;


    public Conference(){
        this.tracks = new ArrayList<>();
    }


    public boolean addTrack(Track track){
        return tracks.add(track);
    }


    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }




}

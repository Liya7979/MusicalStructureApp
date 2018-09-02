package com.example.liya.musicalstructureapp;

import java.io.Serializable;

public class Song implements Serializable {

    private String name;
    private String audio;


    public Song(String name) {
        this.name = name;
        this.audio = null;
    }

    public Song(String name, int duration, String mediaFile) {
        this.name = name;
        this.audio = mediaFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}

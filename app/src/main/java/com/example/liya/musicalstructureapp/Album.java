package com.example.liya.musicalstructureapp;


import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable {

    private String name;
    private Artist artist;
    private String cover;
    private ArrayList<Song> songs;

    public Album(String name, Artist artist, String cover) {
        this.name = name;
        this.artist = artist;
        this.cover = cover;
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
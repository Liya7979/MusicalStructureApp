package com.example.liya.musicalstructureapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Artist implements Serializable {

    private String name;
    private String image;
    private ArrayList<Album> albums;

    public Artist(String name, String image) {
        this.name = name;
        this.image = image;
        albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }
}

package com.example.liya.musicalstructureapp;

import java.util.ArrayList;
import java.util.List;

public class Content {

    /**
     * Sample content for the app.
     */
    public static final List<Album> ALBUM_LIST = new ArrayList<>();
    public static final List<Artist> ARTIST_LIST = new ArrayList<>();


    static {

        Artist klemenSlakonja = new Artist("Klemen Slakonja", "klemen_slakonja");
        Artist britneySpears = new Artist("Britney Spears", "britney_spears");
        Artist edSheeran = new Artist("Ed Sheeran", "ed_sheeran");


        // Adding songs to albums.

        Album babyOneMoreTime = new Album("Baby One More Time", britneySpears, "baby_one_more_time");
        babyOneMoreTime.addSong(new Song("Sometimes"));
        babyOneMoreTime.addSong(new Song("Soda Pop"));
        babyOneMoreTime.addSong(new Song("Born to Make You Happy"));
        babyOneMoreTime.addSong(new Song("From the Bottom of My Broken Heart"));
        babyOneMoreTime.addSong(new Song("I Will Be There"));
        britneySpears.addAlbum(babyOneMoreTime);

        Album mockingBird = new Album("TheMockingbirdMan project", klemenSlakonja, "mocking_bird");
        mockingBird.addSong(new Song("Putin, Putout"));
        mockingBird.addSong(new Song("Golden Dump (The Trump Hump)"));
        mockingBird.addSong(new Song("Ruf mich Angela"));
        klemenSlakonja.addAlbum(mockingBird);

        Album five = new Album("5. You need me", edSheeran, "five");
        five.addSong(new Song("You Need Me, I Don't Need You"));
        five.addSong(new Song("So"));
        five.addSong(new Song("Be Like You"));
        five.addSong(new Song("The City"));
        five.addSong(new Song("Sunburn"));
        edSheeran.addAlbum(five);

        ALBUM_LIST.add(five);
        ARTIST_LIST.add(edSheeran);
        ALBUM_LIST.add(babyOneMoreTime);
        ARTIST_LIST.add(britneySpears);
        ALBUM_LIST.add(mockingBird);
        ARTIST_LIST.add(klemenSlakonja);

    }
}

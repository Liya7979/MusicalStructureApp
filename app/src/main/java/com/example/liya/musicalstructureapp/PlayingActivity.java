package com.example.liya.musicalstructureapp;

import android.content.Intent;
import android.media.MediaPlayer;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class PlayingActivity extends AppCompatActivity {


    private static final String CURRENT_SONG_POS = "CURRENT_SONG_POS";
    
    private ListView listView;
    private ImageView playPauseImageView;
    private ImageView shuffleImageView;
    private ArrayList<Song> songs;
    private Song currentSong;

    private MediaPlayer mediaPlayer;
    private ImageView payImageView;
    private boolean isPlayingRandom;
    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        shuffleImageView = findViewById(R.id.shuffle);
        playPauseImageView = findViewById(R.id.play_pause);

        ImageView nextImageView = findViewById(R.id.next);
        ImageView backImageView = findViewById(R.id.back);
        ImageView repeatImageView = findViewById(R.id.repeat);
        ImageView coverImageView = findViewById(R.id.cover);
        payImageView = findViewById(R.id.pay);


        final Intent intent = getIntent();
        Album selectedAlbum = (Album) intent.getSerializableExtra(MainActivity.SELECTED_ALBUM);
        Artist selectedArtist = (Artist) intent.getSerializableExtra(MainActivity.SELECTED_ARTIST);

        currentSong = null;
        mediaPlayer = null;

        int currSongPos = 0;
        if (savedInstanceState != null) {
            currSongPos = savedInstanceState.getInt(CURRENT_SONG_POS);
        }

        // Get all the songs
        if (selectedAlbum != null) {
            songs = selectedAlbum.getSongs();
            setTitle(selectedAlbum.getName());
            coverImageView.setImageResource(getResources().getIdentifier(
                    selectedAlbum.getCover(), "drawable", getPackageName()));

        } else if (selectedArtist != null) {
            songs = new ArrayList<>();
            for (Album album : selectedArtist.getAlbums()) {
                songs.addAll(album.getSongs());
            }
            setTitle(selectedArtist.getName());
            coverImageView.setImageResource(getResources().getIdentifier(
                    selectedArtist.getImage(), "drawable", getPackageName()));
        }

        

        listView = findViewById(R.id.list);
        SongAdapter songAdapter = new SongAdapter(this, songs);
        listView.setAdapter(songAdapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        selectSong((Song) listView.getItemAtPosition(currSongPos));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectSong((Song) parent.getItemAtPosition(position));
                view.setSelected(true);
            }
        });

        playPauseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPause();
            }
        });
        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlayingActivity.this, "Next song is playing", Toast.LENGTH_LONG).show();
            }
        });

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlayingActivity.this, "Previous song is playing", Toast.LENGTH_LONG
                ).show();
            }
        });

        repeatImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlayingActivity.this, "This song will be playing again", Toast.LENGTH_LONG
                ).show();
            }
        });

        shuffleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlayingRandom) {
                    shuffleImageView.setImageResource(R.drawable.shuffle);
                    Toast.makeText(PlayingActivity.this, "Shuffle songs", Toast.LENGTH_LONG
                    ).show();
                } else {
                    shuffleImageView.setImageResource(R.drawable.queue);
                    Toast.makeText(PlayingActivity.this, "Unshuffle songs", Toast.LENGTH_LONG
                    ).show();
                }
                isPlayingRandom = !isPlayingRandom;
            }
        });
        payImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlayingActivity.this, PaymentActivity.class);
                startActivity(i);
            }
        });


    }
    private void selectSong(Song selection) {
        currentSong = selection;

        int audio = 0;
        if (currentSong.getAudio() != null) {
            audio = getResources().getIdentifier(currentSong.getAudio(), "raw", getPackageName());
        }

        if (audio == 0) {
            Toast.makeText(this, R.string.noSongFile, Toast.LENGTH_SHORT).show();
        }

        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer = null;
        }
        if (audio != 0) {
            mediaPlayer = MediaPlayer.create(this, audio);
        }

        if (isPlaying) {
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
        }
    }
    private void playPause() {
        if (isPlaying) {
            playPauseImageView.setImageResource(R.drawable.play);
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        } else {
            playPauseImageView.setImageResource(R.drawable.pause);
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
        }
        isPlaying = !isPlaying;
    }

}


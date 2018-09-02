package com.example.liya.musicalstructureapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity
        implements AlbumFragment.OnAlbumSelectedListener, ArtistFragment.OnArtistSelectedListener {

    public static final String SELECTED_ALBUM = "SELECTED_ALBUM";
    public static final String SELECTED_ARTIST = "SELECTED_ARTIST";

    private PageAdapter PageAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates the tabs
        PageAdapter = new PageAdapter(getSupportFragmentManager());
        PageAdapter.setPageTitles(initPagesTitles());

        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(PageAdapter);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private String[] initPagesTitles() {
        String[] pageTitles = new String[2];
        pageTitles[0] = getResources().getString(R.string.albums);
        pageTitles[1] = getResources().getString(R.string.artists);
        return pageTitles;
    }

    /**
     * To allow a Fragment to communicate up to its Activity,
     * an interface is defined in the Fragment class
     * and implemented within the Activity.
     * The Fragment captures the interface implementation
     * during its onAttach() lifecycle method and can then
     * call the Interface methods in order to communicate with the Activity.
     *
     * See the Android Training lesson
     * "https://developer.android.com/training/basics/fragments/communicating"
     * "Communicating with Other Fragments" for more information.
     */
    @Override
    public void onAlbumSelected(Album album) {
        Intent playActivity = new Intent(MainActivity.this, PlayingActivity.class);
        playActivity.putExtra(SELECTED_ALBUM, album);
        startActivity(playActivity);
    }

    @Override
    public void onArtistSelected(Artist artist) {
        Intent playActivity = new Intent(MainActivity.this, PlayingActivity.class);
        playActivity.putExtra(SELECTED_ARTIST, artist);
        startActivity(playActivity);
    }
}

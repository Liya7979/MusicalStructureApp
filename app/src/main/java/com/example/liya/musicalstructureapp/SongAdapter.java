package com.example.liya.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * Constructor
     *
     * @param context The current context.
     * @param songs   The songs to represent in the ListView.
     */
    public SongAdapter(@NonNull Context context, @NonNull List<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list, parent, false);
        }
        Song currentSong = getItem(position);
        if (currentSong != null) {
            TextView nameOfSong = listItemView.findViewById(R.id.name_text_view);
            nameOfSong.setText(currentSong.getName());
        }
        return listItemView;
    }
}
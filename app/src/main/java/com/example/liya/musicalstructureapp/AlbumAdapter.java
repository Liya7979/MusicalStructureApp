package com.example.liya.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class AlbumAdapter extends ArrayAdapter<Album> {

    /**
     * @param context The current context.
     * @param albums  The objects to represent in the ListView.
     */
    public AlbumAdapter(@NonNull Context context, @NonNull List<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_album, parent, false);
        }

        Album currentAlbum = getItem(position);

        if (currentAlbum != null) {
            ImageView cover = listItemView.findViewById(R.id.cover);
            cover.setImageResource(getContext().getResources().getIdentifier(
                    currentAlbum.getCover(), "drawable", getContext().getPackageName()));

            TextView name = listItemView.findViewById(R.id.name_text_view);
            name.setText(currentAlbum.getName());

            TextView artist = listItemView.findViewById(R.id.artist);
            artist.setText(currentAlbum.getArtist().getName());
        }

        return listItemView;
    }
}
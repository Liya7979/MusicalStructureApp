package com.example.liya.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    /**
     * @param context The current context.
     * @param artists The objects to represent in the ListView.
     */
    public ArtistAdapter(@NonNull Context context, @NonNull List<Artist> artists) {
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fragment_artist, parent, false);
        }

        Artist currentArtist = getItem(position);

        if (currentArtist != null) {
            //Find the photo of the artist if it exists
            ImageView photo = listItemView.findViewById(R.id.photo_image_view);
            photo.setImageResource(getContext().getResources().getIdentifier(
                    currentArtist.getImage(), "drawable", getContext().getPackageName()));
            //Get the name of the artist
            TextView name = listItemView.findViewById(R.id.name_text_view);
            name.setText(currentArtist.getName());
        }

        return listItemView;
    }
}

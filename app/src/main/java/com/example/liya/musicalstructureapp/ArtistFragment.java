package com.example.liya.musicalstructureapp;

import android.content.Context;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class ArtistFragment extends Fragment {
    private OnArtistSelectedListener mCallBack;

    public ArtistFragment() {
    }

    public static ArtistFragment newInstance() {
        return new ArtistFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);


        // Create an adapter that gets the data from the Content class.
        ArtistAdapter adapter = new ArtistAdapter(view.getContext(), Content.ARTIST_LIST);

        GridView gridView = view.findViewById(R.id.list);

        gridView.setAdapter(adapter);

        // Pass data to the Activity
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist selectedArtist = Content.ARTIST_LIST.get(position);
                mCallBack.onArtistSelected(selectedArtist);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnArtistSelectedListener) {
            mCallBack = (OnArtistSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnArtistSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
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
    public interface OnArtistSelectedListener {
        void onArtistSelected(Artist artist);
    }
}

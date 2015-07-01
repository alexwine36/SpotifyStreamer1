package com.awts.alexanderwine.spotifystreamer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayAdapter<String> mArtistAdapter;



    public MainActivityFragment() {

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_main, container, false);


        String[] artistArray = {
                "Coldplay",
                "Coheed and Cambria",
                "CoolBeans",
                "Cats Pajamas",
                "Cranberries",
                "Cotton Candy",
                "CranApples",
                "Crawdads"
        };


        List<String> returnedArtists = new ArrayList<String>(
                Arrays.asList(artistArray)
        );

        mArtistAdapter =
                new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.artist_container,
                        R.id.listview_artist_textview,
                        returnedArtists
                );

        View rootView = inflater.inflate(R.layout.fragment_main,container,false);


        ListView listView = (ListView) rootView.findViewById(
                R.id.listview_artist
        );
        listView.setAdapter(mArtistAdapter);

        return rootView;

    }




}

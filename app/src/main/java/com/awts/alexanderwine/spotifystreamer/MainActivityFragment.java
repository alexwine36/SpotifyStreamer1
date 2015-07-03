package com.awts.alexanderwine.spotifystreamer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.Artist;
import kaaes.spotify.webapi.android.models.ArtistsPager;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ArrayAdapter<String> mArtistAdapter;
    private String[] artistArray = new String[10];


    private void performSearch(String query) {
        SpotifyApi api = new SpotifyApi();

        SpotifyService spotify = api.getService();

        spotify.searchArtists(query, new Callback<ArtistsPager>() {
            @Override
            public void success(ArtistsPager artistsPager, Response response) {
                List<Artist> listOfArtists = artistsPager.artists.items;

//                artists = (String[]) listOfArtists.toArray(new String[0]);
                int counter = 0;
                for (Artist element : listOfArtists) {
                    if (counter < 10) {
                        artistArray[counter] = element.name;
                    }
                    String name = element.name;
                    Log.d("Name", name);
                    counter++;
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Artist failure", error.toString());
            }
        });
    }

    public MainActivityFragment() {

    }


    public void setSearch(String search){
        performSearch(search);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_main, container, false);


//        Bundle extras = getActivity().getIntent().getExtras();
//        String[] art = extras.getStringArray("art");
        if (artistArray == null) {
            assert artistArray != null;
            artistArray[0] = "Search for artists";
        }



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

package com.awts.alexanderwine.spotifystreamer;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private EditText searchText;

//    private String[] art = new String[10];

    private MainActivityFragment activityFragment;


//    private void performSearch(String query) {
//        SpotifyApi api = new SpotifyApi();
//
//        SpotifyService spotify = api.getService();
//
//        spotify.searchArtists(query, new Callback<ArtistsPager>() {
//            @Override
//            public void success(ArtistsPager artistsPager, Response response) {
//                List<Artist> listOfArtists = artistsPager.artists.items;
//
////                artists = (String[]) listOfArtists.toArray(new String[0]);
//                int counter = 0;
//                for (Artist element : listOfArtists) {
//                    if(counter < 10) {
//                        art[counter] = element.name;
//                    }
//                    String name = element.name;
//                    Log.d("Name", name);
//                    counter++;
//                }
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Log.d("Artist failure", error.toString());
//            }
//        });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityFragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);


        searchText = (EditText) findViewById(R.id.searchText);

        searchText.addTextChangedListener(searchWatcher);


//        intent = new Intent(this, MainActivityFragment.class);
//        intent.putExtra("art", art);
//        startActivity(intent);

    }

    private final TextWatcher searchWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            activityFragment.setSearch("a");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            performSearch(searchText.getText().toString());
            if (searchText != null) {
                activityFragment.setSearch(searchText.getText().toString());
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
//            if (art != null) {
//                for (String artist : art) {
//                    if (artist == null) {
//                    } else {
//                        Log.d("Artists", artist);
//                    }
//                }
//
//            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void artistClick(View v) {
        TextView textView = (TextView) v;
        Resources res = getResources();
        Context context = getApplicationContext();
        String text = textView.getText().toString();
//        performSearch(text);
    }


}

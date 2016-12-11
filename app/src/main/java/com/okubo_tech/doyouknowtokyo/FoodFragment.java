package com.okubo_tech.doyouknowtokyo;

import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by okubo on 2016/11/20.
 * test
 */

public class FoodFragment extends Fragment {

    public FoodFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.spot_list, container, false);

        // Create a list of Spots
        final ArrayList<Spot> spots = new ArrayList<>();
        spots.add(new Spot(R.string.spot_002_name, R.string.spot_002_desc, R.drawable.kamuse, R.string.spot_002_gio));
        spots.add(new Spot(R.string.spot_002_name, R.string.spot_002_desc, R.drawable.kamuse, R.string.spot_002_gio));
        spots.add(new Spot(R.string.spot_002_name, R.string.spot_002_desc, R.drawable.kamuse, R.string.spot_002_gio));

        SpotAdapter adapter = new SpotAdapter(getActivity(), spots, R.color.category_food);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Spot} object at the given position the user clicked on
                Spot currentSpot = spots.get(position);

                // Get Gio Query String, and parse it.
                Resources res = getResources();
                String gioQueryString = res.getString(currentSpot.getmGioResourceId());
                Uri uri = Uri.parse(gioQueryString);

                // Use intent and show map!
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        return rootView;
    }
}

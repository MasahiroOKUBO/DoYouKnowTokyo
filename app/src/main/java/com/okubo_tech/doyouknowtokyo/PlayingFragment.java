package com.okubo_tech.doyouknowtokyo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;

import static com.google.android.gms.instantapps.InstantApps.getPackageManager;

/**
 * Created by okubo on 2016/11/20.
 *
 */

public class PlayingFragment extends Fragment{


    public PlayingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.spot_list, container, false);

        // Create a list of Spots
        final ArrayList<Spot> spots = new ArrayList<>();
        spots.add(new Spot(R.string.spot_003_name, R.string.spot_003_desc, R.drawable.diver_city, R.string.spot_003_gio));
        spots.add(new Spot(R.string.spot_003_name, R.string.spot_003_desc, R.drawable.diver_city, R.string.spot_003_gio));
        spots.add(new Spot(R.string.spot_003_name, R.string.spot_003_desc, R.drawable.diver_city, R.string.spot_003_gio));

        SpotAdapter adapter = new SpotAdapter(getActivity(), spots, R.color.category_playing);
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
                startActivity(intent);
            }
        });

        return rootView;
    }
}

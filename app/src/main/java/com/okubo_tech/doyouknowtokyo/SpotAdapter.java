package com.okubo_tech.doyouknowtokyo;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by okubo on 2016/11/20.
 *
 */

public class SpotAdapter extends ArrayAdapter<Spot> {

    /** Resource ID for the background color for this list of Spot */
    private int mColorResourceId;

    /**
     * Create a new {@link SpotAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param spots is the list of {@link Spot}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public SpotAdapter(Context context, ArrayList<Spot> spots, int colorResourceId) {
        super(context, 0, spots);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Spot currentSpot = getItem(position);

        // Find the TextView in the list_item.xml layout with the Resource ID spot_name.
        // Set Value to TextView.
        TextView spot_nameTextView = (TextView) listItemView.findViewById(R.id.spot_name);
        spot_nameTextView.setText(currentSpot.getmSpotNameId());

        // Find the TextView in the list_item.xml layout with the Resource ID spot_description.
        // Set Value to TextView.
        TextView spot_descriptionTextView = (TextView) listItemView.findViewById(R.id.spot_description);
        spot_descriptionTextView.setText(currentSpot.getmSpotDescriptionId());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentSpot.getmImageResourceId());


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }


}

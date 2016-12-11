package com.okubo_tech.doyouknowtokyo;

/**
 * Created by okubo on 2016/11/20.
 */

public class Spot {

    /** String resource ID for the Name of the spot */
    private int mSpotNameId;

    /** String resource ID for the Description of the spot */
    private int mSpotDescriptionId;

    /** Image resource ID for the spot */
    private int mImageResourceId;

    /** Gio resource ID for the spot */
    private int mGioResourceId;

    /**
     * Create a new Spot object.
     *
     * @param spotNameId is the string resource ID for the Name of Spot.
     * @param spotDescriptionId is the string resource Id for the Description of Spot.
     * @param imageResourceId is the drawable resource ID for the image associated with the Spot.
     */
    public Spot(int spotNameId, int spotDescriptionId, int imageResourceId) {
        mSpotNameId = spotNameId;
        mSpotDescriptionId = spotDescriptionId;
        mImageResourceId = imageResourceId;
    }

    public Spot(int spotNameId, int spotDescriptionId, int imageResourceId, int gioResourceId) {
        mSpotNameId = spotNameId;
        mSpotDescriptionId = spotDescriptionId;
        mImageResourceId = imageResourceId;
        mGioResourceId = gioResourceId;
    }

    /**
     * Get the string resource ID for the Name of the word.
     */
    public int getmSpotNameId() {
        return mSpotNameId;
    }

    /**
     * Get the string resource ID for the Description of the word.
     */
    public int getmSpotDescriptionId() {
        return mSpotDescriptionId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmGioResourceId() {
        return mGioResourceId;
    }
}

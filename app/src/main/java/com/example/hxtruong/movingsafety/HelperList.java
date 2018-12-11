package com.example.hxtruong.movingsafety;

import android.content.Context;
import android.location.Location;
import android.widget.ArrayAdapter;

import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;
import java.util.Iterator;

public class HelperList {
    private static GoogleMap mMap;
    private ArrayList<Helper> helperArrayList;

    // make array helper
    public HelperList(GoogleMap map) {
        this.mMap = map;
        this.helperArrayList = new ArrayList<Helper>();
        for (int i = 0; i < 5; i++) {
            Location location = new Location("Person_" + Integer.toString(i));
            location.setLatitude(10.7 + i * 0.1);
            location.setLongitude(106.6);
            Helper temp = new Helper("Person_" + Integer.toString(i), location);
            this.helperArrayList.add(temp);
        }
    }

    public void displayAllHelperMarker() {
        for (Helper e : helperArrayList) {
            e.addMarker(mMap);
        }
    }

}

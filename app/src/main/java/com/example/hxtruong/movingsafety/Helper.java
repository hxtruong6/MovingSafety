package com.example.hxtruong.movingsafety;

import android.location.Location;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;

public class Helper implements Serializable {
    private String name;
    private Location location;

    public Helper(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public void updateLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public void addMarker(GoogleMap mMap) {
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(this.location.getLatitude(),this.location.getLongitude()))
                .title(this.name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }
}

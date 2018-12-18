package com.example.hxtruong.movingsafety;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;

public class Helper implements Parcelable {
    private String name;
    private Location location;
    private Marker marker;
    private float[] distanceToCurrentLocation = new float[1];

    public Helper(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public void updateDistanceToCurrentLocation(Location userCurrentLocation ){
        Location.distanceBetween(userCurrentLocation.getLatitude(), userCurrentLocation.getLongitude(),
                location.getLatitude(), location.getLongitude(), distanceToCurrentLocation);
    }

    public void updateLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public void addMarker(GoogleMap mMap) {
        marker = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(this.location.getLatitude(), this.location.getLongitude()))
                .title(this.name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }

    public String getName() {
        return name;
    }

    public Marker getMarker() {
        return marker;
    }

    public float getDistanceToCurrenLocation() {
        return distanceToCurrentLocation[0];
    }

    protected Helper(Parcel in) {
        name = in.readString();
        location = in.readParcelable(Location.class.getClassLoader());
        distanceToCurrentLocation = in.createFloatArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(location, flags);
        dest.writeFloatArray(distanceToCurrentLocation);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Helper> CREATOR = new Creator<Helper>() {
        @Override
        public Helper createFromParcel(Parcel in) {
            return new Helper(in);
        }

        @Override
        public Helper[] newArray(int size) {
            return new Helper[size];
        }

    };


}
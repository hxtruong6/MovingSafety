package com.example.hxtruong.movingsafety;

import android.location.Address;
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
    private String address;
    private String phoneNumber;
    private String avatarLink;
    private int score = 100;

    public Helper(String name, Location location, String address, String phoneNumber, String avatarLink) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.avatarLink = avatarLink;
    }

    public void updateDistanceToCurrentLocation(Location userCurrentLocation) {
        Location.distanceBetween(userCurrentLocation.getLatitude(), userCurrentLocation.getLongitude(),
                location.getLatitude(), location.getLongitude(), distanceToCurrentLocation);
    }

    public void updateLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getScore() {
        return score;
    }

    public String getAvatarLink() {
        return avatarLink;
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

    public void addMarker(GoogleMap mMap) {
        marker = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(this.location.getLatitude(), this.location.getLongitude()))
                .title(this.name).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }

    protected Helper(Parcel in) {
        name = in.readString();
        location = in.readParcelable(Location.class.getClassLoader());
        distanceToCurrentLocation = in.createFloatArray();
        score = in.readInt();
        address = in.readString();
        phoneNumber = in.readString();
        avatarLink = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(location, flags);
        dest.writeFloatArray(distanceToCurrentLocation);
        dest.writeInt(score);
        dest.writeString(address);
        dest.writeString(phoneNumber);
        dest.writeString(avatarLink);
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
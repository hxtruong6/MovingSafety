package com.example.hxtruong.movingsafety;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    public static final String EXTRA_MESSAGE = "com.example.hxtruong.DETAIL_INFO";
    private final View mWindow;
    private final Context mContext;

    public CustomInfoWindowAdapter(Context context) {
        this.mContext = context;
        this.mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
    }

    private void renderWindowText(Marker marker, View view)
    {
        String title = marker.getTitle();
        TextView textView = (TextView) view.findViewById(R.id.nameUser);
        textView.setText(title);
    }
    @Override
    public View getInfoWindow(Marker marker) {
        renderWindowText(marker, mWindow);
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderWindowText(marker, mWindow);
        return null;
    }
}

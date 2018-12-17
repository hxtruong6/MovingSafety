package com.example.hxtruong.movingsafety;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.GoogleMap;

import org.json.JSONObject;

public class DirectionFinder {
    private static final String API_KEY = "AIzaSyBXKVVavalZsryNc4sHYqfpBbQy1DfBJHk";

    private void getDirection(Context context, Location srclocation, Location desLocation, Response.Listener onSuccess) {
        RequestQueue queue = Volley.newRequestQueue(context);
        final String outputFormat = "json";
        final String parameters = String.format("origin=%f,%f&destination=%f,%f&key=%s",
                srclocation.getLatitude(), srclocation.getLongitude(),
                desLocation.getLatitude(), desLocation.getLongitude(),
                API_KEY);
        String url = String.format("https://maps.googleapis.com/maps/api/directions/%s?%s",
                outputFormat, parameters);
        Log.d("xxx", "getDirection: " + url);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                onSuccess, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("xxx", "loi r ne " + error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    public void displayRoute(Context context, GoogleMap mMap, Location srclocation, Location desLocation) {
        Response.Listener onSuccess = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                // parse json

                Log.d("xxx", "onResponse: " + response);
            }
        };

        getDirection(context, srclocation, desLocation, onSuccess);
    }
}

package com.example.jakubwiraszka.lab9;

import com.google.gson.annotations.Expose;

public class Geo {
    @Expose
    private double lat;
    @Expose
    private double lng;

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}

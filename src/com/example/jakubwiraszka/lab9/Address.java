package com.example.jakubwiraszka.lab9;

import com.google.gson.annotations.Expose;

public class Address {
    @Expose
    private String street;
    @Expose
    private String suite;
    @Expose
    private String city;
    @Expose
    private String zipCode;
    @Expose
    private Geo geo;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}

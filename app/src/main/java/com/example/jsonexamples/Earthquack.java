package com.example.jsonexamples;

public class Earthquack {
    double magnitude;
    String location;
    long date;
    String URL;

    public Earthquack(double magnitude, String location, long date, String URL) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.URL = URL;
    }


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}

package com.example.jsonexamples;

public class Earthquack {
    Double magnitude;
    String location;
    long date;
    String URL;

    public Earthquack(Double magnitude, String location, long date, String URL) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.URL = URL;
    }

    public Earthquack(Double magnitude, String location, long date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Double magnitude) {
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

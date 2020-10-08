package com.example.jsonexamples;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquack>> {
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=3";

    public EarthquakeLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<Earthquack> loadInBackground() {
        Log.i("EarquackLoader", " LoadInBacckground Has started");
        return QueryUtils.fetchEarthquakeData(USGS_REQUEST_URL);
    }
}

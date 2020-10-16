package com.example.jsonexamples;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquack>> {
    private static String query;

    public EarthquakeLoader(@NonNull Context context, String Query) {
        super(context);
        query = Query;
    }

    @Nullable
    @Override
    public List<Earthquack> loadInBackground() {
        Log.i("EarquackLoader", " LoadInBacckground Has started");
        return QueryUtils.fetchEarthquakeData(query);
    }
}

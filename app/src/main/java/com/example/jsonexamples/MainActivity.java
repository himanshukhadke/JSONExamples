package com.example.jsonexamples;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<List<Earthquack>> {

    private EarthquackAdapter mAdapter;
    private ListView listView;
    private TextView empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new EarthquackAdapter(this, new ArrayList<Earthquack>());
        listView = findViewById(R.id.list_view);
        empty = findViewById(R.id.empty);
        listView.setEmptyView(empty);
        checkConnection();
        listView.setAdapter(mAdapter);
        getSupportLoaderManager().initLoader(0, null, this).forceLoad();
    }

    private void checkConnection() {
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (!isConnected) {
            empty.setText("No Internet Connection");
            Log.i("checkConnection()", "NO internet Connection");
        } else
            empty.setText("Loading...");
    }

    @NonNull
    @Override
    public Loader<List<Earthquack>> onCreateLoader(int id, @Nullable Bundle args) {
        return new EarthquakeLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Earthquack>> loader, List<Earthquack> data) {
        mAdapter.clear();
        if (data != null) {
            mAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Earthquack>> loader) {
        mAdapter.clear();
    }
}
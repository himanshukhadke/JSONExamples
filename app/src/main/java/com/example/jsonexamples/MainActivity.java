package com.example.jsonexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<Earthquack> adapter= null;
        try {
            adapter = new EarthquackAdapter(this, QueryUtils.extractEarthquakes());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListView listView=findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
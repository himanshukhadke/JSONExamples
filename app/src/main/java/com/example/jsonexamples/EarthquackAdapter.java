package com.example.jsonexamples;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class EarthquackAdapter extends ArrayAdapter<Earthquack> {
    private Context c;

    public EarthquackAdapter(@NonNull Context context, @NonNull List<Earthquack> objects) {
        super(context, 0, objects);
        c = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        if (currentView == null) {
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.detail_view, parent, false);
        }
        final Earthquack obj = getItem(position);
        currentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(obj.getURL()));
                c.startActivity(intent);
            }
        });
        TextView mag = currentView.findViewById(R.id.magnitude);
        mag.setText(fomatedMag(obj.getMagnitude()));
        TextView offset_location = currentView.findViewById(R.id.location_offset);
        TextView primary_location = currentView.findViewById(R.id.location_primary);
        int status = obj.getLocation().indexOf("of");
        if (status == -1) {
            offset_location.setText("Near the");
            primary_location.setText(obj.getLocation());
        } else {
            String[] arr = obj.getLocation().split("of");
            offset_location.setText(arr[0]);
            primary_location.setText(arr[1]);
        }
        long dateInMilli = obj.getDate();
        Date date = new Date(dateInMilli);
        TextView t = currentView.findViewById(R.id.date);
        t.setText(formatedDate(date));
        t = currentView.findViewById(R.id.time);
        t.setText(formatedTime(date));

        //changing the background of magnitude
        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();
        int magnitudeColor = getMagnitudeColor(obj.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        return currentView;
    }

    private String fomatedMag(Double magnitude) {
        DecimalFormat f = new DecimalFormat("0.0");
        return f.format(magnitude);
    }

    public String formatedDate(Date date) {
        SimpleDateFormat s = new SimpleDateFormat("LLL dd, yyyy");
        return s.format(date);
    }

    public String formatedTime(Date date) {
        SimpleDateFormat s = new SimpleDateFormat("h:mm a");
        return s.format(date);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}

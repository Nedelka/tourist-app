package com.example.touristapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private LocationManager locationManager;
    private LocationListener locationListener;


    // Create each location by setting it's lat and lon. ( Eventually move to 'Destination Screen' activity later. )
    public Location LocationFactory(float lat, float lon){
        Location destination = new Location("");
        destination.setLatitude(lat);
        destination.setLongitude(lon);

        return destination;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons onclick events
        Button btn = findViewById(R.id.DestinationsBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        // ( Eventually move to 'Destination Screen' activity later. )
        Location sofia = LocationFactory(42.691283f,23.318975f );
        Location plovdiv = LocationFactory(42.144228f,24.736051f );
        Location nearPlovdiv = LocationFactory(42.144300f, 24.750146f );

        float distanceInMeters = sofia.distanceTo(plovdiv);

        if( distanceInMeters <= 5000 ){
            Log.i(TAG, "Within distance");
            // System.out.println("Destination is within radius");
        }
        else{
            //System.out.println("Destination out of radius");
            Log.i(TAG, "Out of radius");
        }
    } // onCreate Method
}  // Class

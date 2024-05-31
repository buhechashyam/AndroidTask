package com.example.googlemapandroid.map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.googlemapandroid.R;
import com.example.googlemapandroid.databinding.ActivityCustomMarkBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class CustomMarkActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    private GoogleMap mMap;
    private ActivityCustomMarkBinding binding;

    LatLng mAhmadabad = new LatLng(23.03532444750626, 72.56599535980953);
    LatLng mRajkot = new LatLng(22.30269205635917, 70.79760349421038);
    LatLng mSurat = new LatLng(21.172306858492078, 72.82812912413733);


    private LatLng mFirstPoint = new LatLng(23.075972979143, 72.52437972508848);
    private LatLng mSecondPoint = new LatLng(23.077226511328387, 72.526997560799);
    private LatLng mThirdPoint = new LatLng(23.075183346571226, 72.52686345036301);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCustomMarkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Set a custom Icon To Mark
        LatLng mLocation = new LatLng(23.07591357914299, 72.52652509625356);
        mMap.addMarker(new MarkerOptions().position(mLocation).title("Marker in Moon TechnoLabs").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mLocation));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLocation, 16f));

        //Add Circle around specific LatLng
        mMap.addCircle(new CircleOptions().center(mLocation).radius(350).fillColor(R.color.light_blue).strokeColor(R.color.black).clickable(true));
        //Add Polygon around specific LatLng
        mMap.addPolygon(new PolygonOptions().add(mFirstPoint, mSecondPoint, mThirdPoint).fillColor(R.color.light_red).strokeColor(R.color.black));
        //Add Polyline
        mMap.addPolyline(new PolylineOptions().add(mRajkot, mAhmadabad, mSurat, mRajkot).width(5.0f).color(Color.RED).geodesic(true));


        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // if permission is granted than location is enable
            mMap.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
        }
    }


    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();

        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "My Location : " + location, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Access Fine Location Permission is granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Access Fine Location Permission is Denied", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Access Coarse Location Location Permission is granted", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Access Coarse Location Location Permission is denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
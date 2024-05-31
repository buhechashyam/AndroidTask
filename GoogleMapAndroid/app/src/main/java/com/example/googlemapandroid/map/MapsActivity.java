package com.example.googlemapandroid.map;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.googlemapandroid.R;
import com.example.googlemapandroid.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnPoiClickListener, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng mMoonTechnoLab = new LatLng(23.07590370876011, 72.52653582508844);
        mMap.addMarker(new MarkerOptions().title("Moon Technolabs").position(mMoonTechnoLab));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mMoonTechnoLab, 16f));


        LatLng mStatueOFUnity = new LatLng(21.83803829787909, 73.71907279622808);
        mMap.addMarker(new MarkerOptions().position(mStatueOFUnity).title("Statue OF Unity"));

        mMap.setOnPoiClickListener(this);
        mMap.setOnMarkerClickListener(this);


    }

    @Override
    public void onPoiClick(@NonNull PointOfInterest pointOfInterest) {
        String str = "Id: " + pointOfInterest.placeId + "\n Name:" + pointOfInterest.name + "\n Letlog:" + pointOfInterest.latLng;
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {

        marker.showInfoWindow();
        Intent intent = new Intent(this, DestinationActivity.class);
        intent.putExtra("data", "ID : " + marker.getId() + "\n" + "Title: " + marker.getTitle() + "Latitude: " + marker.getPosition().latitude + "Longitude: " + marker.getPosition().longitude);
        startActivity(intent);
        return false;
    }
}
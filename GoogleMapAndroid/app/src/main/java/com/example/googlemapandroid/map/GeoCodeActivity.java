package com.example.googlemapandroid.map;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.googlemapandroid.R;
import com.example.googlemapandroid.databinding.ActivityGeoCodeBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;

public class GeoCodeActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityGeoCodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGeoCodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        //GeoCoding - Address to Latitude and Longitude
        String mCityName = "Ahmedabad";
        Geocoder geocoder = new Geocoder(this);
        try {
            ArrayList<Address> mCities = (ArrayList<Address>) geocoder.getFromLocationName(mCityName,1);
            Address city = mCities.get(0);
            LatLng latLng = new LatLng(city.getLatitude(),city.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title(mCityName));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,16f));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Reverse GeoCoding- Latitude and Longitude to Address
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                Geocoder geocoder = new Geocoder(GeoCodeActivity.this);
                try {
                    ArrayList<Address> mListAddress = (ArrayList<Address>) geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    Address address = mListAddress.get(0);
                    mMap.addMarker(new MarkerOptions().title(address.getAddressLine(0)).position(new LatLng(address.getLatitude(), address.getLongitude())));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
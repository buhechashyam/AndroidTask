package com.example.googlemapandroid.map;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.example.googlemapandroid.R;
import com.example.googlemapandroid.databinding.ActivityAdvancedMarkerBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.AdvancedMarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapCapabilities;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.PinConfig;

public class AdvancedMarkerActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityAdvancedMarkerBinding binding;

    LatLng mAhmadabad = new LatLng(23.027294596642864, 72.50741939860531);
    LatLng mRajkot = new LatLng(22.30269205635917, 70.79760349421038);
    LatLng mSurat = new LatLng(21.172306858492078, 72.82812912413733);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdvancedMarkerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);


        MapCapabilities mapCapabilities = mMap.getMapCapabilities();

        //Check Advanced Marker Option capability
        Log.d("MAIN", String.valueOf(mapCapabilities.isAdvancedMarkersAvailable()));

        PinConfig.Builder pinConfigBuilder = PinConfig.builder();
        pinConfigBuilder.setBorderColor(Color.BLACK)
                .setBackgroundColor(Color.YELLOW);

        //Set Glyph
        PinConfig.Glyph glyph = new PinConfig.Glyph("A");
        pinConfigBuilder.setGlyph(glyph);

        PinConfig pinConfig = pinConfigBuilder.build();

        Marker marker = mMap.addMarker(new AdvancedMarkerOptions().position(mAhmadabad).icon(BitmapDescriptorFactory.fromPinConfig(pinConfig)).title("Ahmadabad").snippet("This is an Ahmadabad City"));
        marker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mAhmadabad, 16f));

        // Add Ground OverLay
        mMap.addGroundOverlay(new GroundOverlayOptions().position(mAhmadabad,400,300).image(BitmapDescriptorFactory.fromResource(R.drawable.ic_ahmadabad)));


    }
}
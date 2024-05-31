package com.example.googlemapandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.googlemapandroid.databinding.ActivityMapWithIntentsBinding;

public class MapWithIntentsActivity extends AppCompatActivity {

    ActivityMapWithIntentsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapWithIntentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Open Google Map using Intents
        binding.btnGoToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:23.076022153306994, 72.52652509625356");
                Intent iGoTOMap = new Intent(Intent.ACTION_VIEW,uri);
                iGoTOMap.setPackage("com.google.android.apps.maps");
                startActivity(iGoTOMap);
            }
        });

        //Find Restaurant using intent
        binding.btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0,0?q=restaurants");
                Intent iGoTOMap = new Intent(Intent.ACTION_VIEW,uri);
                iGoTOMap.setPackage("com.google.android.apps.maps");
                startActivity(iGoTOMap);
            }
        });

        binding.btnTrackTwoRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("google.navigation:q=Ahmedabad,+Gandhinagar");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);

            }
        });
    }
}
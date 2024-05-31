package com.example.googlemapandroid.map;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.googlemapandroid.R;
import com.example.googlemapandroid.databinding.ActivityDestinationBinding;

public class DestinationActivity extends AppCompatActivity {
    ActivityDestinationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDestinationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textReceiveData.setText(getIntent().getStringExtra("data"));

    }
}
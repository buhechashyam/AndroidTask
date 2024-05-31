package com.example.ecommerceapp_webservice.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.databinding.ActivityProductBinding;

public class ProductActivity extends AppCompatActivity {

    ActivityProductBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Glide.with(this).load( getIntent().getStringExtra("image_url")).into(binding.imageProduct);
        binding.textProductDesc.setText( getIntent().getStringExtra("desc"));
        binding.textProductName.setText( getIntent().getStringExtra("name"));
        binding.textProductPrice.setText( "$." +  getIntent().getStringExtra("price"));


    }
}
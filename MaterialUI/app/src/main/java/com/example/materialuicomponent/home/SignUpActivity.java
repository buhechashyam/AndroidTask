package com.example.materialuicomponent.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.materialuicomponent.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}
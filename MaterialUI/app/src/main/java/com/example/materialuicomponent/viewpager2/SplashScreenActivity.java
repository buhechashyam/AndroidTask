package com.example.materialuicomponent.viewpager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.materialuicomponent.PracticeActivity;
import com.example.materialuicomponent.R;

public class SplashScreenActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spash_screen);

        lottieAnimationView = findViewById(R.id.lottie_animation);

        lottieAnimationView.playAnimation();

        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
        boolean isShown = sharedPreferences.getBoolean("isShown", false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isShown) {
                    Intent i = new Intent(SplashScreenActivity.this, PracticeActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(SplashScreenActivity.this, OnBoardingActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 3000);
    }
}
package com.example.materialuicomponent.animations;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.materialuicomponent.R;

public class AnimationActivity extends AppCompatActivity {

    Button btnFadeInAnim, btnFadeOutAnim, btnBlinkAnim, btnZoomInAnim, btnZoomOutAnim, btnRotateAnim, btnMoveAnim, btnSlideUpAnim, btnSlideDownAnim, btnBounceAnim;
    TextView textAnimation;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        initView();

        btnFadeInAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                textAnimation.startAnimation(animation);
            }
        });

        btnFadeOutAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                textAnimation.startAnimation(animation);
            }
        });

        btnBlinkAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                textAnimation.startAnimation(animation);
            }
        });

        btnZoomInAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                textAnimation.startAnimation(animation);
            }
        });

        btnZoomOutAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
                textAnimation.startAnimation(animation);
            }
        });

        btnRotateAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                textAnimation.startAnimation(animation);
            }
        });
        btnMoveAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation moveAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                textAnimation.startAnimation(moveAnim);
            }
        });

        btnSlideUpAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation slideUpAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                textAnimation.startAnimation(slideUpAnim);
            }
        });


        btnSlideDownAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation slideDownAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                textAnimation.startAnimation(slideDownAnim);
            }
        });

        btnBounceAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation bounceAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                textAnimation.startAnimation(bounceAnimation);
            }
        });
    }

    private void initView() {
        textAnimation = findViewById(R.id.text_name);
        btnFadeInAnim = findViewById(R.id.btn_fade_in);
        btnFadeOutAnim = findViewById(R.id.btn_fade_out);
        btnBlinkAnim = findViewById(R.id.btn_blink);
        btnZoomInAnim = findViewById(R.id.btn_zoom_in);
        btnZoomOutAnim = findViewById(R.id.btn_zoom_out);
        btnRotateAnim = findViewById(R.id.btn_rotate);
        btnMoveAnim = findViewById(R.id.btn_move);
        btnSlideUpAnim = findViewById(R.id.btn_slide_up);
        btnSlideDownAnim = findViewById(R.id.btn_slide_down);
        btnBounceAnim = findViewById(R.id.btn_bounce);
        img = findViewById(R.id.img);
    }
}
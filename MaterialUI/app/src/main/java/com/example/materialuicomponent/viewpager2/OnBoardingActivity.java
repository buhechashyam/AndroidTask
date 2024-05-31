package com.example.materialuicomponent.viewpager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.materialuicomponent.PracticeActivity;
import com.example.materialuicomponent.R;

import java.util.ArrayList;

public class OnBoardingActivity extends AppCompatActivity {

    private OnBoardingAdapter adapter;
    Button btnNext, btnStart;
    TextView btnSkip;
    ViewPager viewPager2;
    int position = 0;
    ArrayList<ScreenItemModel> screenDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_on_boarding);

        initView();
        screenDatas = new ArrayList<ScreenItemModel>();
        screenDatas = getData();

        adapter = new OnBoardingAdapter(screenDatas, OnBoardingActivity.this);

        viewPager2.setAdapter(adapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = viewPager2.getCurrentItem();

                if (position < screenDatas.size() - 1) {
                    //for first 2 screens
                    position++;
                    viewPager2.setCurrentItem(position);
                } else {
                    //for last screen
                    loadLastScreen();
                }
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isShown", true);
                editor.apply();
                startActivity(new Intent(OnBoardingActivity.this, PracticeActivity.class));
                finish();
            }
        });

    }

    private void loadLastScreen() {
        btnStart.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
    }

    private void initView() {
        btnNext = findViewById(R.id.btn_next);
        btnStart = findViewById(R.id.btn_start);
        btnSkip = findViewById(R.id.btn_skip);
        viewPager2 = findViewById(R.id.viewpager2);
    }

    private ArrayList<ScreenItemModel> getData() {
        ArrayList<ScreenItemModel> list = new ArrayList<ScreenItemModel>();

        list.add(new ScreenItemModel(R.drawable.ic_ob_1, getString(R.string.text_ob_title_1), getString(R.string.text_ob_1)));
        list.add(new ScreenItemModel(R.drawable.ic_ob_2, getString(R.string.text_ob_title_2), getString(R.string.text_ob_2)));
        list.add(new ScreenItemModel(R.drawable.ic_ob_3, getString(R.string.text_ob_title_3), getString(R.string.text_ob_3)));

        return list;
    }


}
package com.example.uicomponents.tablayout;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.uicomponents.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tab_layout);

        viewPager2 = findViewById(R.id.viewpager2);
        tabLayout = findViewById(R.id.tab_layout);

        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2,(tab, i) -> {
            switch (i) {
                case 0: tab.setText("Chat");
                break;
                case 1: tab.setText("Status");
                break;
                case 2: tab.setText("Call");
                break;
            }
        }).attach();

    }
}
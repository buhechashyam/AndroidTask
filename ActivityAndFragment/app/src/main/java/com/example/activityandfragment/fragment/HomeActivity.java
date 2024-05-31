package com.example.activityandfragment.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.activityandfragment.R;
import com.google.android.material.button.MaterialButton;

public class HomeActivity extends AppCompatActivity {

    MaterialButton mButtonFirst, mButtonSecond, mButtonThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        mButtonFirst = findViewById(R.id.btn_first);
        mButtonSecond = findViewById(R.id.btn_second);
        mButtonThird = findViewById(R.id.btn_third);


        //First add Fragment to Container
        loadFragment(new FirstFragment(), 0);

        
        mButtonFirst.setOnClickListener(v -> loadFragment(new FirstFragment(), 0));
        mButtonSecond.setOnClickListener(v -> loadFragment(new SecondFragment(), 1));
        mButtonThird.setOnClickListener(v -> loadFragment(new ThirdFragment(), 1));
    }

    public void loadFragment(Fragment fragment, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag == 0) {
            ft.add(R.id.fragment_container_view, fragment);
            //when we back to first fragment and that time all previous fragment are pop.
            fm.popBackStack("ROOT_FRAGMENT_TAG", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack("ROOT_FRAGMENT_TAG");
        } else {
            ft.setCustomAnimations(
                    R.anim.slide_up, R.anim.slide_down
            ).replace(R.id.fragment_container_view, fragment);
            ft.addToBackStack(null);
        }
        ft.commit();
    }
}
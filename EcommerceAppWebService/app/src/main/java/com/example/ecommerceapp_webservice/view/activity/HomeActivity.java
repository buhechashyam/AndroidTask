package com.example.ecommerceapp_webservice.view.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ecommerceapp_webservice.R;
import com.example.ecommerceapp_webservice.view.fragments.CartFragment;
import com.example.ecommerceapp_webservice.view.fragments.CategoryFragment;
import com.example.ecommerceapp_webservice.view.fragments.HomeFragment;
import com.example.ecommerceapp_webservice.view.fragments.LoginFragment;
import com.example.ecommerceapp_webservice.view.fragments.SettingFragment;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar mToolbar;
   // ViewFlipper viewFlipper;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView mNavigationView;
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(HomeActivity.this, mDrawerLayout, mToolbar, R.string.txt_open, R.string.txt_close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);


    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToolbar = findViewById(R.id.toolbar);
        mNavigationView = findViewById(R.id.navigation_view);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        menuItem.setChecked(true);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Fragment fragment = null;

        int id = menuItem.getItemId();

        if (id == R.id.menu_home){
            fragment = new HomeFragment();
        } else if (id == R.id.menu_category) {
            fragment = new CategoryFragment();
        }else if (id == R.id.menu_cart) {
            fragment = new CartFragment();
        }else if (id == R.id.menu_setting) {
            fragment = new SettingFragment();
        }else if (id == R.id.menu_login) {
            fragment = new LoginFragment();
        }

        assert fragment != null;
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();

        mDrawerLayout.closeDrawers();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
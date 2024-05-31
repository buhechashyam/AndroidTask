package com.example.materialuicomponent.home;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.materialuicomponent.R;
import com.example.materialuicomponent.databinding.ActivityNavDrawerBinding;
import com.example.materialuicomponent.tablayout.fragments.CallFragment;
import com.example.materialuicomponent.tablayout.fragments.ChatFragment;
import com.example.materialuicomponent.tablayout.fragments.StatusFragment;
import com.google.android.material.navigation.NavigationView;

public class NavDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityNavDrawerBinding binding;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        binding.toolbar.setTitle("Home");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Home");

        toggle = new ActionBarDrawerToggle(this, binding.navDrawer, R.string.open, R.string.close);
        binding.navDrawer.addDrawerListener(toggle);
        toggle.syncState();

        binding.navigationView.setNavigationItemSelectedListener(this);
    }

    //For Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_nav_drawer, menu);
        return true;
    }


    //For Nav Drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        //first set a checked
        menuItem.setChecked(true);

        int id = menuItem.getItemId();

        Fragment fragment = null;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (id == R.id.menu_item1) {
            fragment = new ChatFragment();
        } else if (id == R.id.menu_item2) {
            fragment = new StatusFragment();
        } else if (id == R.id.menu_item3) {
            fragment = new CallFragment();
        } else if (id == R.id.menu_item4) {
            fragment = new ChatFragment();
        } else if (id == R.id.menu_item5) {
            fragment = new StatusFragment();
        } else if (id == R.id.menu_item6) {
            fragment = new CallFragment();
        }

        fragmentTransaction.replace(R.id.frame_layout, fragment).commit();
        binding.navDrawer.closeDrawers();

        return true;
    }

    //For both Nav drawer and Toolbar
    // Allow toggle to handle item selected event
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //write for toolbar item click

        //write for nav drawer item click
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Restore state when screen is rotation
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    //pass the new configuration changes
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }
}














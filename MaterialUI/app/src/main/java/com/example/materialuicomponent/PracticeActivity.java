package com.example.materialuicomponent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.materialuicomponent.databinding.ActivityPracticeBinding;
import com.google.android.material.navigation.NavigationView;

public class PracticeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActionBarDrawerToggle toggle;
    ActivityPracticeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPracticeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle = new ActionBarDrawerToggle(this,binding.drawerlayout,binding.toolbar,R.string.open,R.string.close);

        binding.drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.activity_home,menu);
       return true;
    }
    //For Toolbar

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();

       if (id == R.id.menu_search){
           Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
       }else if (id==R.id.menu_share){
           Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
       }else if (id == R.id.menu_setting){
           Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
       }
        return true;
    }

    //For Nav Drawer

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.menu_item1){

        }
        binding.drawerlayout.closeDrawers();
        return true;
    }
}
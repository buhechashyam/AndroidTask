package com.example.materialuicomponent.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.materialuicomponent.R;
import com.example.materialuicomponent.toolbar.ToolBarActivity;
import com.example.materialuicomponent.toolbar.SecondActivity;

public class HomeActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        ConstraintLayout main = findViewById(R.id.main);
        main.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ToolBarActivity.class);
            startActivity(intent);
        });

    }
    //create a menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_home, menu);

        //get a search item id
        MenuItem searchItem = menu.findItem(R.id.menu_search);

        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int searchId = R.id.menu_search;
        int shareId = R.id.menu_share;
        int settingId = R.id.menu_setting;

        int itemId = item.getItemId();

        if (itemId == searchId) {
            Toast.makeText(HomeActivity.this, "SEARCH",Toast.LENGTH_SHORT).show();
        } else if (itemId == shareId) {
            startActivity(new Intent(this, SecondActivity.class));
        } else if (itemId == settingId) {
            Toast.makeText(HomeActivity.this, "SETTING", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(HomeActivity.this, "SHARE", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
package com.example.androiddatabase.view.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androiddatabase.helper.SQLiteDBHelper;
import com.example.androiddatabase.adapter.UsersAdapter;
import com.example.androiddatabase.databinding.ActivityUsersBinding;
import com.example.androiddatabase.model.User;

import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {

    ActivityUsersBinding binding;
    SQLiteDBHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("All Users");

        mDbHelper = new SQLiteDBHelper(this);

        ArrayList<User> mUserList = mDbHelper.getAllUsers();

        binding.recyclerviewUsers.setLayoutManager(new LinearLayoutManager(this));

        binding.recyclerviewUsers.setAdapter(new UsersAdapter(mUserList,this));

        binding.btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UsersActivity.this, AddUserActivity.class));
            }
        });
    }
}
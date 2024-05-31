package com.example.androiddatabase.view.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androiddatabase.databinding.ActivityAddUserBinding;
import com.example.androiddatabase.helper.SQLiteDBHelper;

public class AddUserActivity extends AppCompatActivity {

    ActivityAddUserBinding binding;
    SQLiteDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ADD USER");
        dbHelper = new SQLiteDBHelper(this);


        binding.btnWriteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.addUserToTable(binding.etFirstName.getText().toString(), binding.etLastName.getText().toString());
                Toast.makeText(AddUserActivity.this, "Data is insert", Toast.LENGTH_SHORT).show();

                binding.etFirstName.setText("");
                binding.etLastName.setText("");
            }
        });

        binding.btnReadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = new Intent(AddUserActivity.this, UsersActivity.class);
                startActivity(mIntent);
            }
        });

    }
}
package com.example.androiddatabase.view.sqlite;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androiddatabase.databinding.ActivityUpdateUserBinding;
import com.example.androiddatabase.helper.SQLiteDBHelper;

public class UpdateUserActivity extends AppCompatActivity {

    ActivityUpdateUserBinding binding;
    SQLiteDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Update USER");

        dbHelper = new SQLiteDBHelper(this);

        String mFirstName = getIntent().getStringExtra("firstname");
        String mLastName = getIntent().getStringExtra("lastname");
        String mId = getIntent().getStringExtra("id");

        binding.etFirstName.setText(mFirstName);
        binding.etLastName.setText(mLastName);

        binding.btnUpdateData.setOnClickListener(v -> {
            dbHelper.updateUser(mId, binding.etFirstName.getText().toString(), binding.etLastName.getText().toString());
            startActivity(new Intent(UpdateUserActivity.this, UsersActivity.class));
        });

        binding.btnDeleteData.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Are you sure to delete records?")
                    .setCancelable(true)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        dbHelper.deleteUser(mId);
                        startActivity(new Intent(UpdateUserActivity.this, UsersActivity.class));
                    })
                    .setNegativeButton("No", (dialog, which) -> {
                        dialog.dismiss();
                    });
            AlertDialog dialog = builder.create();
            dialog.show();

        });
    }
}
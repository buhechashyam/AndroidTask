package com.example.activityandfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.activityandfragment.launcher.ResultLauncherActivity;

public class SecondActivity extends AppCompatActivity {

    Button mButtonSendUsername;
    EditText mEditTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toast.makeText(this, "onCreate- B", Toast.LENGTH_SHORT).show();

//        Bundle BUNDLE = getIntent().getBundleExtra("user");
//        Log.d("Main",BUNDLE.getString("name"));

        mButtonSendUsername = findViewById(R.id.btn_send_username);
        mEditTextUsername = findViewById(R.id.et_username);

        mButtonSendUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ResultLauncherActivity.class);
                intent.putExtra("username",mEditTextUsername.getText().toString());

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart- B", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume- B", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause- B", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop- B", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart- B", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy- B", Toast.LENGTH_SHORT).show();
    }
}
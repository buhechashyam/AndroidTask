package com.example.activityandfragment.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.activityandfragment.R;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        String data = getIntent().getStringExtra("data");

        TextView mTextViewReceive = findViewById(R.id.text_receive_data);
        mTextViewReceive.setText(data);

    }
}
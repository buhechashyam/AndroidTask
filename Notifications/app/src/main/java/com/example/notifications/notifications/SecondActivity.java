package com.example.notifications.notifications;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notifications.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //for simple notification - get data from intent and print it in textview
        binding.textReceiveData.setText("Receive Data : " + getIntent().getStringExtra("data"));

        //for Direct Reply notification - get reply text and print in textview
        Intent intent = getIntent();
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            String mStringReply = String.valueOf(remoteInput.get(NotificationActivity.KEY_TEXT_REPLY));
            binding.textReceiveData.setText(mStringReply);
        }
    }
}
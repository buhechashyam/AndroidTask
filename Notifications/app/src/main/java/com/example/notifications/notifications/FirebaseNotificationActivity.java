package com.example.notifications.notifications;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.notifications.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class FirebaseNotificationActivity extends AppCompatActivity {


    ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
        @Override
        public void onActivityResult(Boolean isGranted) {
            if (isGranted) {
                //Post Notification
                Toast.makeText(FirebaseNotificationActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();

            }else {
                //Not Post Permission
                Toast.makeText(FirebaseNotificationActivity.this, "Permission Not Granted", Toast.LENGTH_SHORT).show();

            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_notification);

        TextView mTextViewTitle = findViewById(R.id.text_title);
        if (getIntent().getStringExtra("title") != null) {
            mTextViewTitle.setText(getIntent().getStringExtra("title"));

        }else {
            mTextViewTitle.setText("Title");
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
            }
        }

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {

                if (task.isSuccessful()){
                    Toast.makeText(FirebaseNotificationActivity.this, task.getResult(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FirebaseNotificationActivity.this, "Token Not Found", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
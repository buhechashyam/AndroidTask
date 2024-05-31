package com.example.notifications.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;

import com.example.notifications.R;
import com.example.notifications.databinding.ActivityScheduleNotificationBinding;

public class PracticeNotificationActivity extends AppCompatActivity {

    ActivityScheduleNotificationBinding binding;
    public static final String CHANNEL_ID = "CH_3";
    public static final String REMOTE_INPUT_KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScheduleNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnScheduleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });
    }

    public void createNotification() {

        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 100, new Intent[]{intent}, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Schedule Notification")
                .setContentText("This is schedule notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSmallIcon(R.drawable.ic_whatsapp)
                .setAutoCancel(true)
                .addAction(R.drawable.ic_whatsapp, "Schedule", pendingIntent);

        String CHANNEL_NAME = "Schedule Notifications";
        String CHANNEL_DESCRIPTION = "This All Are Schedule Notifications";
        int IMPORTANCE = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel notificationChannel;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, IMPORTANCE);
            notificationChannel.setDescription(CHANNEL_DESCRIPTION);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

            notificationManager.notify(1, builder.build());

        }
    }

    public void createReplyNotification() {

        String CHANNEL_ID = "CH_2";

        RemoteInput remoteInput = new RemoteInput.Builder(REMOTE_INPUT_KEY).setLabel("Reply").build();

        Intent intent = new Intent(this, SecondActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, new Intent[]{intent}, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_whatsapp, "Reply", pendingIntent)
                .addRemoteInput(remoteInput)
                .build();

        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_ID);
        notification.setContentTitle("Direct Reply Notification")
                .setContentText("This is a Direct Reply Notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .addAction(action)
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Video Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("this channel for new video notification");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

            notificationManager.notify(122, notification.build());
        }
    }
}

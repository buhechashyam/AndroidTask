package com.example.notifications.notifications;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;

import com.example.notifications.R;
import com.example.notifications.databinding.ActivityNotificationBinding;


public class NotificationActivity extends AppCompatActivity {
    ActivityNotificationBinding binding;
    public static final String KEY_TEXT_REPLY = "key_text_reply";
    static final String CHANNEL_ID = "CH_1";
    int NOTIFICATION_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkNotificationPermission();

        binding.btnSimpleNotification.setOnClickListener(v -> createSimpleNotification());

        binding.btnDirectReplyNotification.setOnClickListener(v -> createDirectReplyNotification());

        binding.btnCustomNotification.setOnClickListener(v -> createCustomNotification());
    }

    private void createCustomNotification(){

        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivities(this,100,new Intent[]{intent},PendingIntent.FLAG_MUTABLE);

        //Direct Reply
        RemoteInput remoteInput = new RemoteInput.Builder("KEY")
                .setLabel("Message Reply")
                .build();

        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_notification,"Direct Reply", pendingIntent)
                .addRemoteInput(remoteInput)
                .build();
        //Create Remote View For Costume Layouts
        RemoteViews smallRemoteView = new RemoteViews(getPackageName(),R.layout.item_small_notification);
        RemoteViews bigRemoteView = new RemoteViews(getPackageName(),R.layout.item_big_notification);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Custom Notification")
                .setSmallIcon(R.drawable.ic_whatsapp)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(smallRemoteView)
                .setCustomBigContentView(bigRemoteView)
                .addAction(action)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setAutoCancel(true);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"MESSAGES",NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("This Channel for Messages");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            notificationManager.notify(123,builder.build());
        }
    }

    private void createSimpleNotification() {
        //Create a PendingIntent for the perform tap action on notification
        Intent intent1 = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent1 = PendingIntent.getActivities(this, 0, new Intent[]{intent1}, PendingIntent.FLAG_IMMUTABLE);

        //PendingIntent for button in notification
        Intent intent2 = new Intent(this, SecondActivity.class);
        intent2.putExtra("data", "Welcome To Duo");
        PendingIntent pendingIntent2 = PendingIntent.getActivities(this, 1, new Intent[]{intent2}, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
        notificationBuilder.setContentTitle("Hi! It's Duo.")
                .setContentText("Make your screen time count.Take a quick English lesson now!")
                .setSmallIcon(R.drawable.ic_notification)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent1)
                .setAutoCancel(true)
                .addAction(R.drawable.ic_notification, "SEND DATA", pendingIntent2);

        //notification channel library support in API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String CHANNEL_NAME = "Chats";
            String CHANNEL_DESCRIPTION = "All 'Chats' notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            //Create Notification Channel
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            notificationChannel.setDescription(CHANNEL_DESCRIPTION);

            //Register the channel with the System
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
            NOTIFICATION_ID++;
        }
    }

    private void createDirectReplyNotification(){
        String CHANNEL_ID = "CH_2";

        Intent intent = new Intent(this, SecondActivity.class);

        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel("Reply")
                .build();

        PendingIntent replyPendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE);

        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_whatsapp, "Reply", replyPendingIntent)
                .addRemoteInput(remoteInput)
                .build();

        //large image convert to bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ic_large_image);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_whatsapp)
                .setContentTitle("Whatsapp")
                .setContentText("1 new message")
                .addAction(action)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap))
                //  .setStyle(new NotificationCompat.BigTextStyle().bigText("Nature is the ultimate source of our living. Both living and non-living things include nature, and everyone is interdependent, which helps maintain the ecosystem. Plants, animals, and humans all depend on nature for their survival."))
                .build();

        String CHANNEL_NAME = "Whatsapp Chat";
        String CHANNEL_DESCRIPTION = "Chats reply notification";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
            notificationChannel.setDescription(CHANNEL_DESCRIPTION);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.notify(NOTIFICATION_ID, builder.build());
            NOTIFICATION_ID++;
        }
    }
    private void checkNotificationPermission() {
        if (ContextCompat.checkSelfPermission(NotificationActivity.this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(NotificationActivity.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 100);
        } else {
            Toast.makeText(NotificationActivity.this, "Permission already Granted", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(NotificationActivity.this,"Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(NotificationActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
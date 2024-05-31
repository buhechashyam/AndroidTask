package com.example.activityandfragment.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction() != null && BroadCastActivity.CUSTOM_ACTION.equals(intent.getAction())) {

            String data = intent.getStringExtra("data");
            if (data != null) {
                Toast.makeText(context, "Data send : " + intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();

                Intent switchIntent = new Intent(context, NextActivity.class);
                switchIntent.putExtra("data", data);
                switchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(switchIntent);
            }
        }
    }
}

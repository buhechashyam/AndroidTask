package com.example.activityandfragment.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyAirPlaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0) {
            Toast.makeText(context, "AirPlane mode ON", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "AirPlane mode OFF", Toast.LENGTH_LONG).show();
        }
    }
}

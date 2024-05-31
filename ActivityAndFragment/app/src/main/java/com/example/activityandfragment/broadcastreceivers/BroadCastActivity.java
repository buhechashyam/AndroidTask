package com.example.activityandfragment.broadcastreceivers;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activityandfragment.R;

public class BroadCastActivity extends AppCompatActivity {

    BatteryStateReceiver batteryStateReceiver = new BatteryStateReceiver();
    MyAirPlaneModeReceiver airPlaneModeReceiver = new MyAirPlaneModeReceiver();

    CustomBroadcastReceiver customBroadcastReceiver = new CustomBroadcastReceiver();

    public static  final String CUSTOM_ACTION = "android.intent.action.CUSTOM";
    EditText mEditTextData;
    Button mButtonSendData;

    @Override
    protected void onStart() {
        super.onStart();
        //Register a BroadCast Receiver
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        registerReceiver(batteryStateReceiver, filter);

        IntentFilter filter1 = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airPlaneModeReceiver, filter1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            BroadCastActivity.this.registerReceiver(customBroadcastReceiver, new IntentFilter(CUSTOM_ACTION), Context.RECEIVER_EXPORTED);
        }else {
            BroadCastActivity.this.registerReceiver(customBroadcastReceiver, new IntentFilter(CUSTOM_ACTION));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_broad_cast);

        mEditTextData = findViewById(R.id.et_text_data);
        mButtonSendData = findViewById(R.id.btn_send_data);

        mButtonSendData.setOnClickListener(v -> {

            Intent intent = new Intent();
            intent.setAction(CUSTOM_ACTION);
            intent.putExtra("data", mEditTextData.getText().toString());
            sendBroadcast(intent);

        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BroadCastActivity.this.unregisterReceiver(batteryStateReceiver);
        BroadCastActivity.this.unregisterReceiver(airPlaneModeReceiver);
        BroadCastActivity.this.unregisterReceiver(customBroadcastReceiver);
    }
}
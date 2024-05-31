package com.example.uicomponents.widgets;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uicomponents.R;

public class DialogActivity extends AppCompatActivity {

    private Button mButtonAlertDialog, mButtonCustomDialog, mButtonChronometer;
    private ViewFlipper viewFlipper;
    private TextView mHtmlText, mTextViewCountDown;
    private Chronometer mChronometer;
    private AutoCompleteTextView mAutoCompleteTextViewName;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dialog);

        initView();

        performHtmlText();

        mButtonAlertDialog.setOnClickListener(v -> showAlertDialog());

        mButtonCustomDialog.setOnClickListener(v -> showCustomAlertDialog());

        viewFlipper();

        countDownTimer();


        mButtonChronometer.setOnClickListener(v -> {

            if (isRunning) {
                mButtonChronometer.setText("Start");
                isRunning = false;
                mChronometer.stop();
            } else {
                mButtonChronometer.setText("Stop");
                isRunning = true;
                mChronometer.start();
            }
        });

        String[] names = {"Shyam", "Sagar", "Darshan", "Ram", "Axay", "Pratik"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,names);
        mAutoCompleteTextViewName.setAdapter(adapter);
        mAutoCompleteTextViewName.setThreshold(1);
    }

    private void countDownTimer() {
        new CountDownTimer(100000, 1000) {

            @SuppressLint("DefaultLocale")
            @Override
            public void onTick(long millisUntilFinished) {
                mTextViewCountDown.setText(String.format("Remaining : %d", millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(DialogActivity.this, "CountDownCompleted", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void performHtmlText() {
        String htmlCode = "<h2>HTML Text</h2>";
        mHtmlText.setText(Html.fromHtml(htmlCode, Html.FROM_HTML_MODE_COMPACT));
    }

    private void viewFlipper() {
        //
    }

    private void showCustomAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Let's Start a Game");

        final View customAlertDialog = getLayoutInflater().inflate(R.layout.custom_dialog_layout, null);

        alertDialog.setView(customAlertDialog);
        alertDialog.setPositiveButton("Start", (dialog, which) -> {
            EditText etUsername = customAlertDialog.findViewById(R.id.et_username);
            showToast(etUsername.getText().toString());
        });
        alertDialog.setNegativeButton("Cancel", (dialog, which) -> {
            dialog.cancel();
        });
        alertDialog.create();
        alertDialog.show();
    }

    private void showToast(String username) {
        Toast.makeText(this, "game start by" + username, Toast.LENGTH_SHORT).show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("This is Open Browser")
                .setCancelable(true)
                .setIcon(R.drawable.ic_google)
                .setPositiveButton("Yes", (dialog1, which) -> {
                    //
                })
                .setNegativeButton("No", (dialog1, which) -> {
                    dialog1.cancel();
                });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    private void initView() {
        mButtonAlertDialog = findViewById(R.id.btn_alert_dialog);
        mButtonCustomDialog = findViewById(R.id.btn_custom_dialog);
        viewFlipper = findViewById(R.id.view_flipper);
        mHtmlText = findViewById(R.id.tvHtmlText);
        mTextViewCountDown = findViewById(R.id.txt_count_down_timer);
        mChronometer = findViewById(R.id.chronometer);
        mButtonChronometer = findViewById(R.id.btn_chronometer);
        mAutoCompleteTextViewName = findViewById(R.id.autoCompleteTextView);
    }
}
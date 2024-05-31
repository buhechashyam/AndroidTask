package com.example.uicomponents.bars;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uicomponents.R;

public class BarsActivity extends AppCompatActivity {
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private Button btnProgress,btnShowAlert;
    private ProgressBar progressBar;
    private TextView mTextViewRating, mTextViewSeekBarScore;

    Boolean isVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars);

        initView();

        performRatingBar();
        performSeekBar();

        performProgressBar();
        showAlertDialog();
    }

    private void showAlertDialog() {

        btnShowAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(BarsActivity.this);
                alertDialog.setMessage("Are you sure for exit?");
                alertDialog.setIcon(R.drawable.ic_check);
                alertDialog.setCancelable(true);
                alertDialog.setPositiveButton("YES",(dialog, which) -> {
                    finish();
                });
                alertDialog.setNegativeButton("NO", (dialog, which) -> {
                    dialog.cancel();
                });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });
    }

    private void performProgressBar() {
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isVisible) {
                    progressBar.setVisibility(View.GONE);
                    isVisible = false;
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    isVisible = true;
                }
            }
        });
    }

    private void performRatingBar() {
        ratingBar.setNumStars(5);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mTextViewRating.setText(String.valueOf(rating));
            }
        });
    }

    private void performSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextViewSeekBarScore.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initView(){
        ratingBar = findViewById(R.id.ratingBar);
        mTextViewRating = findViewById(R.id.text_show_rating);
        mTextViewSeekBarScore = findViewById(R.id.text_show_seekbar);
        seekBar = findViewById(R.id.seekBar);
        btnProgress = findViewById(R.id.btn_progress);
        progressBar = findViewById(R.id.progressBar);
        btnShowAlert = findViewById(R.id.btn_show_alert_dialog);
    }
}
package com.example.uicomponents.dialog;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.uicomponents.R;

public class ScheduleMeetingActivity extends AppCompatActivity {

    private TextView mTextViewTaskName;
    private Button mButtonCreateMeeting;
    private CardView mButtonSetTime, mButtonSetDate;
    private TextView mTextViewMeetingDate, mTextViewMeetingTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_meeting);

        initView();

        mButtonSetDate.setOnClickListener(v -> openDatePicker());

        mButtonSetTime.setOnClickListener(v -> openTimePicker());

        mButtonCreateMeeting.setOnClickListener(v -> Toast.makeText(ScheduleMeetingActivity.this, "Meeting Created Successfully!", Toast.LENGTH_SHORT).show());
    }

    private void openTimePicker() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                setTimeToCard(hourOfDay, minute);
            }
        }, 11, 30, false);
        timePickerDialog.create();
        timePickerDialog.show();
    }

    @SuppressLint("SetTextI18n")
    private void setTimeToCard(int hour, int minute) {
        if (hour > 12) {
            hour = hour - 12;
            mTextViewMeetingTime.setText(hour + ":" + minute + "PM");
        } else {
            mTextViewMeetingTime.setText(hour + ":" + minute + "AM");
        }
    }

    private void openDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int selectedMonth = month + 1;
                setDateToCard(dayOfMonth, selectedMonth, year);
            }
        }, 2024, 3, 12);
        datePickerDialog.show();
    }

    private void setDateToCard(int dayOfMonth, int month, int year) {
        mTextViewMeetingDate.setText(dayOfMonth + "/" + month + "/" + year);
    }

    private void initView() {
        mButtonCreateMeeting = findViewById(R.id.btn_create_meeting);
        mButtonSetDate = findViewById(R.id.card_set_date);
        mButtonSetTime = findViewById(R.id.card_set_time);
        mTextViewMeetingDate = findViewById(R.id.tv_meeting_date);
        mTextViewMeetingTime = findViewById(R.id.tv_meeting_time);
    }
}
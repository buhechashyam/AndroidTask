package com.example.uicomponents.dialog;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import com.example.uicomponents.R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;

public class CalenderActivity extends AppCompatActivity {

    private CalendarView mCalendarView;
    private Button mButtonSetEvent, mButtonSetDateRange;
    private TextView mTextViewDate, mTextViewDateRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        mCalendarView = findViewById(R.id.calendarView);
        mButtonSetEvent = findViewById(R.id.btn_set_event);
        mTextViewDate = findViewById(R.id.tv_date);
        mTextViewDateRange = findViewById(R.id.tv_date_range);
        mButtonSetDateRange = findViewById(R.id.btn_select_date_range);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                mTextViewDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        });

        mButtonSetDateRange.setOnClickListener(v -> selectDateRange());

        mButtonSetEvent.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.S)
            @Override
            public void onClick(View v) {
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2024, 4, 22);

                Calendar endTime = Calendar.getInstance();
                endTime.set(2024, 5, 23);

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
                intent.putExtra(CalendarContract.Events.TITLE, "Holi Celebration");
                intent.putExtra(CalendarContract.Events.DESCRIPTION, "Happy Holi, Shyam, ..........");
                intent.putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY);
                intent.putExtra(Intent.EXTRA_EMAIL, "shyam@gmail.com");
                startActivity(intent);
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void selectDateRange(){
        MaterialDatePicker.Builder<Pair<Long, Long>> mMaterialDatePicker = MaterialDatePicker.Builder.dateRangePicker();
        mMaterialDatePicker.setTitleText("SELECT DATE RANGE");

        MaterialDatePicker materialDatePicker = mMaterialDatePicker.build();

        materialDatePicker.addOnPositiveButtonClickListener(o -> mTextViewDateRange.setText("Selected Date Range: " + materialDatePicker.getHeaderText()));

        materialDatePicker.show(getSupportFragmentManager(),"Material DatePicker");

    }
}
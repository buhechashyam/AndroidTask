package com.example.androiddatabase.view.sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androiddatabase.R;
import com.example.androiddatabase.helper.StudentSqliteHelper;
import com.example.androiddatabase.model.Student;

public class StudentActivity extends AppCompatActivity {

    StudentSqliteHelper sqliteHelper;
    int mCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        sqliteHelper = new StudentSqliteHelper(this);


        findViewById(R.id.btn_add_student).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqliteHelper.addStudent("student-"+ mCount, 20+ mCount);
                mCount++;
                Toast.makeText(StudentActivity.this, "Data is delete", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
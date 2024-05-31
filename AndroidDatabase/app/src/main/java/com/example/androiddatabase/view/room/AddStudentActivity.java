package com.example.androiddatabase.view.room;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.androiddatabase.R;
import com.example.androiddatabase.roomdb.NameDatabase;
import com.example.androiddatabase.roomdb.entity.NameEntity;
import com.example.androiddatabase.roomdb.entity.StudentEntity;
import com.example.androiddatabase.viewmodel.MainViewModel;

public class AddStudentActivity extends AppCompatActivity {

    MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_student);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        StudentEntity mFirstStudent = new StudentEntity("Jay","80");
        StudentEntity mSecondStudent = new StudentEntity("TEJ","85");

        viewModel.addStudent(mFirstStudent);
        viewModel.addStudent(mSecondStudent);

        NameEntity mFirstName= new NameEntity("SHYAM","BUHECHA",22);
        NameDatabase.getInstance(this).namesDao().addName(mFirstName);

    }
}
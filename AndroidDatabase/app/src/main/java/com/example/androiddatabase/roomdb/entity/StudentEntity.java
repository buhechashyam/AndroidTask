package com.example.androiddatabase.roomdb.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class StudentEntity {

    @PrimaryKey(autoGenerate = true)
    public int rollNumber;

    @ColumnInfo(name = "student_name")
    public String mStudentName;
    @ColumnInfo(name = "student_marks")
    public String mStudentMarks;

    public StudentEntity(String mStudentName, String mStudentMarks) {
        this.mStudentName = mStudentName;
        this.mStudentMarks = mStudentMarks;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getmStudentName() {
        return mStudentName;
    }

    public void setmStudentName(String mStudentName) {
        this.mStudentName = mStudentName;
    }

    public String getmStudentMarks() {
        return mStudentMarks;
    }

    public void setmStudentMarks(String mStudentMarks) {
        this.mStudentMarks = mStudentMarks;
    }
}

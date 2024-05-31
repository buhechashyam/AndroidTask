package com.example.androiddatabase.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androiddatabase.roomdb.entity.StudentEntity;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addStudent(StudentEntity student);

    @Update
    void updateStudent(StudentEntity student);
    @Query("SELECT * FROM students")
    List<StudentEntity> getAllStudents();
}

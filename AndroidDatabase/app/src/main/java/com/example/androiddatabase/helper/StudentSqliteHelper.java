package com.example.androiddatabase.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.androiddatabase.model.Student;

import java.util.ArrayList;


public class StudentSqliteHelper extends SQLiteOpenHelper {
    private static final String DB_STUDENT = "db";
    private static final String TABLE_STUDENT = "students";
    private static final int DB_VERSION = 1;

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "student_name";
    private static final String COLUMN_AGE = "student_age";

    public StudentSqliteHelper(@Nullable Context context) {
        super(context, DB_STUDENT, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = "CREATE TABLE " + TABLE_STUDENT + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AGE + " INTEGER)";
        db.execSQL(query);
    }

    public void addStudent(String name, int age) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_AGE, age);

        database.insert(TABLE_STUDENT,null,contentValues);

    }
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> mListStudent = new ArrayList<>();

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_STUDENT, null);

        if (cursor.moveToFirst()) {
            do {
                mListStudent.add(new Student(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
            } while (cursor.moveToNext());
        }
        return mListStudent;
    }

    public void updateStudentDetails(String id, String name, int age) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_AGE,age);

        database.update(TABLE_STUDENT,values,"id=?", new String[] {id});
    }

    public void deleteStudent(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_STUDENT,"id=?",new String[] {id});

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);
    }
}

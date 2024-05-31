package com.example.androiddatabase.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.androiddatabase.model.User;

import java.util.ArrayList;

public class SQLiteDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "users_db";
    private static final String TABLE_NAME = "users";
    private static final int DB_VERSION = 1;
    private static final String ID_COLUMN = "id";
    private static final String FIRST_NAME_COLUMN = "firstname";
    private static final String LAST_NAME_COLUMN = "lastname";

    public SQLiteDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIRST_NAME_COLUMN + " TEXT,"
                + LAST_NAME_COLUMN + " TEXT)";

        //this method is use to execute sql query
        db.execSQL(query);
    }

    //INSERT DATA INTO TABLE
    public void addUserToTable(String mFirstName, String mLastName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME_COLUMN, mFirstName);
        contentValues.put(LAST_NAME_COLUMN, mLastName);

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    //READ DATABASE
    public ArrayList<User> getAllUsers() {

        ArrayList<User> mUsers = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        //Execute query and its return result and store in Cursor
        Cursor cursorUser = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);

        if (cursorUser.moveToFirst()) {
            do {
                mUsers.add(new User(cursorUser.getInt(0),
                        cursorUser.getString(1),
                        cursorUser.getString(2)));
            }while (cursorUser.moveToNext());
        }

        cursorUser.close();

        return mUsers;
    }

    public void updateUser(String id, String mFirstName, String mLastName) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME_COLUMN,mFirstName);
        contentValues.put(LAST_NAME_COLUMN,mLastName);

        SQLiteDatabase db = this.getWritableDatabase();

        db.update(TABLE_NAME,contentValues,"id=?",new String[]{id});
        db.close();
    }

    public void deleteUser(String mId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id=?", new String[]{mId});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

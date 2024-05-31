package com.example.androiddatabase.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androiddatabase.roomdb.dao.ProductDao;
import com.example.androiddatabase.roomdb.dao.StudentDao;
import com.example.androiddatabase.roomdb.entity.ProductEntity;
import com.example.androiddatabase.roomdb.entity.StudentEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ProductEntity.class, StudentEntity.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDao productDao();
    public abstract StudentDao studentDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "productsdb").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }



}
package com.example.androiddatabase.roomdb;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.androiddatabase.roomdb.dao.NamesDao;
import com.example.androiddatabase.roomdb.entity.NameEntity;

@Database(entities = {NameEntity.class}, version = 3, exportSchema = false)
public abstract class NameDatabase extends RoomDatabase {

    public abstract NamesDao namesDao();

    public static volatile NameDatabase INSTANCE;

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE names ADD COLUMN age INTEGER NOT NULL DEFAULT 0");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE names ADD COLUMN surname TEXT");
        }
    };
    public static NameDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            synchronized (NameDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, NameDatabase.class, "name-db")
                            .allowMainThreadQueries()
                            .addMigrations(MIGRATION_1_2,MIGRATION_2_3)
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}

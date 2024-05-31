package com.example.androiddatabase.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.androiddatabase.roomdb.entity.NameEntity;

@Dao
public interface NamesDao {

    @Insert
    public void addName(NameEntity name);
}

package com.example.androiddatabase.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User {
    private int id;
    private String mFirstName;
    private String mLastName;

    public User(int id, String mFirstName, String mLastName) {
        this.id = id;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }
}

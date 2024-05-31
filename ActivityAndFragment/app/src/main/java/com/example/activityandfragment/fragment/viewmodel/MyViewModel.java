package com.example.activityandfragment.fragment.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private final MutableLiveData<String> data = new MutableLiveData<String>();
    public LiveData<String> getData() {
        return data;
    }

    public void setData(String str) {
        data.setValue(str);
    }
}

package com.sda.projet.navigation;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public HomeViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.mText = mutableLiveData;
        mutableLiveData.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return this.mText;
    }
}


/*
 *  Created by TVB Ledoux on 10/07/22 22:19
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 10/07/22 22:15
 */

package com.sda.projet.navigation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MenuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MenuViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.mText = mutableLiveData;
        mutableLiveData.setValue("This is menu fragment");
    }

    public LiveData<String> getText() {
        return this.mText;
    }
}

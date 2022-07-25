/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 06:00
 */

package com.sda.HymnesAdventiste.database;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class DbPersistence extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}

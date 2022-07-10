/*
 *  Created by TVB Ledoux on 10/07/22 22:19
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 10/07/22 22:15
 */

package com.sda.projet.database;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class DbPersistence extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}

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

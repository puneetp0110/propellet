package com.example.medicationapp.activities;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class App extends Application {
/*
    * Stetho is used to debug local database.
 */
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}

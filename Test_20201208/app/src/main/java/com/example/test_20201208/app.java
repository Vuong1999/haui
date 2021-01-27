package com.example.test_20201208;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class app  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}

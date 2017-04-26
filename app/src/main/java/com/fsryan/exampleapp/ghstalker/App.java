package com.fsryan.exampleapp.ghstalker;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;

import io.fabric.sdk.android.Fabric;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.FABRIC_ENABLED) {
            Fabric.with(this, new Crashlytics(), new Answers());
        }
    }
}

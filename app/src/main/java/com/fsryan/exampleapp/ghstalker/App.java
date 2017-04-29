package com.fsryan.exampleapp.ghstalker;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;

import static com.fsryan.exampleapp.ghstalker.ComponentsLoader.loadComponentsOf;

public class App extends Application {

    /*package*/ Components components;

    public static Components components(Context context) {
        return ((App) context.getApplicationContext()).components;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        if (BuildConfig.LEAK_CANARY_ENABLED) {
            LeakCanary.install(this);
        }

        startFabric(this);

        components = loadComponentsOf(this);
    }

    private static void startFabric(App app) {
        List<Kit> kits = new ArrayList<>();
        if (BuildConfig.CRASHLYTICS_ENABLED) {
            kits.add(new Crashlytics());
        }
        if (BuildConfig.ANSWERS_ENABLED) {
            kits.add(new Answers());
        }
        if (kits.isEmpty()) {
            return;
        }
        Fabric.with(app, kits.toArray(new Kit[0]));
    }
}

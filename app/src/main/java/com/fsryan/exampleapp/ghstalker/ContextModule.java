package com.fsryan.exampleapp.ghstalker;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context appContext;

    public ContextModule(Context context) {
        appContext = context.getApplicationContext();
    }

    @Provides
    @AppScope
    Context appContext() {
        return appContext;
    }
}

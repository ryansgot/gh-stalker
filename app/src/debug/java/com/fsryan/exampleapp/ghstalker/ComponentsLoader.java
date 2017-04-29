package com.fsryan.exampleapp.ghstalker;

import android.util.Log;

public abstract class ComponentsLoader {
    public static Components loadComponentsOf(App app) {
        try {
            return (Components) Class.forName("com.fsryan.exampleapp.ghstalker.MockDependencyInjector").newInstance();
        } catch (Exception e) {
            Log.e(ComponentsLoader.class.getSimpleName(), "failed to loadComponentsOf mock dependency injector", e);
        }

        return new DependencyInjector(app);
    }
}

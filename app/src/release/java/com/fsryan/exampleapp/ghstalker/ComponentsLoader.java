package com.fsryan.exampleapp.ghstalker;

public abstract class ComponentsLoader {
    public static Components loadComponentsOf(App app) {
        return new DependencyInjector(app);
    }
}

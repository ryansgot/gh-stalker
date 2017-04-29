package com.fsryan.exampleapp.ghstalker.stalker;

import com.fsryan.exampleapp.ghstalker.AppComponent;

import dagger.Component;

@StalkerActivityScope
@Component(modules = StalkerActivityModule.class, dependencies = AppComponent.class)
public interface StalkerActivityComponent {
    void inject(StalkerActivity stalkerActivity);
}

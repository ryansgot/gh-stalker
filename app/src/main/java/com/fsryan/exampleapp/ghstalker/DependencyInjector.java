package com.fsryan.exampleapp.ghstalker;

import com.fsryan.exampleapp.ghstalker.stalker.DaggerStalkerActivityComponent;
import com.fsryan.exampleapp.ghstalker.stalker.StalkerActivity;
import com.fsryan.exampleapp.ghstalker.stalker.StalkerActivityComponent;
import com.fsryan.exampleapp.ghstalker.stalker.StalkerActivityModule;

/*package*/ class DependencyInjector implements Components {

    private final AppComponent appComponent;

    public DependencyInjector(App app) {
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(app))
                .build();
    }

    @Override
    public AppComponent app() {
        return appComponent;
    }

    @Override
    public StalkerActivityComponent stalkerActivity(StalkerActivity stalkerActivity) {
        return DaggerStalkerActivityComponent.builder()
                .appComponent(appComponent)
                .stalkerActivityModule(new StalkerActivityModule(stalkerActivity))
                .build();
    }
}

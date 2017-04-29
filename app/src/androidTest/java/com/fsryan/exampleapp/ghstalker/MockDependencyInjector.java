package com.fsryan.exampleapp.ghstalker;

import com.fsryan.exampleapp.ghstalker.stalker.MockStalkerActivityComponent;
import com.fsryan.exampleapp.ghstalker.stalker.StalkerActivity;


import static android.support.test.InstrumentationRegistry.getTargetContext;

public class MockDependencyInjector implements Components {

    private final AppComponent appComponent;

    public MockDependencyInjector() {
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(getTargetContext()))
                .build();
    }


    @Override
    public AppComponent app() {
        return appComponent;
    }

    @Override
    public MockStalkerActivityComponent stalkerActivity(final StalkerActivity stalkerActivity) {
        return new MockStalkerActivityComponent(stalkerActivity);
    }
}

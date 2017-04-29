package com.fsryan.exampleapp.ghstalker.stalker;

import dagger.Module;
import dagger.Provides;

@Module
public class StalkerActivityModule {

    private final StalkerActivity stalkerActivity;

    public StalkerActivityModule(StalkerActivity stalkerActivity) {
        this.stalkerActivity = stalkerActivity;
    }

    @Provides
    @StalkerActivityScope
    StalkerActivity stalkerActivity() {
        return stalkerActivity;
    }

    @Provides
    @StalkerActivityScope
    Stalker.Presenter stalkerPresenter() {
        return new StalkerPresenterImpl();
    }
}

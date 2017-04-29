package com.fsryan.exampleapp.ghstalker.stalker;

import android.app.Activity;
import android.support.test.runner.lifecycle.ActivityLifecycleCallback;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;

import java.lang.reflect.Field;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;

public class MockStalkerActivityComponent implements StalkerActivityComponent {

    public static final Stalker.Presenter MOCK_STALKER_PRESENTER = mock(Stalker.Presenter.class);

    public MockStalkerActivityComponent(final StalkerActivity stalkerActivity) {
        ActivityLifecycleMonitorRegistry.getInstance().addLifecycleCallback(new ActivityLifecycleCallback() {
            @Override
            public void onActivityLifecycleChanged(Activity activity, Stage stage) {
                if (activity != stalkerActivity || stage != Stage.DESTROYED) {
                    return;
                }
                reset(MOCK_STALKER_PRESENTER);
                ActivityLifecycleMonitorRegistry.getInstance().removeLifecycleCallback(this);
            }
        });
    }

    @Override
    public void inject(StalkerActivity stalkerActivity) {
        try {
            Field presenter = stalkerActivity.getClass().getDeclaredField("presenter");
            presenter.setAccessible(true);
            presenter.set(stalkerActivity, MOCK_STALKER_PRESENTER);
        } catch (Exception e) {
            throw new IllegalArgumentException("The StalkerActivity class must have an accessible member of type " + Stalker.Presenter.class + " called \"presenter\"", e);
        }
    }
}

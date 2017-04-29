package com.fsryan.exampleapp.ghstalker.stalker;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BaseStalkerActivityTest {

    @Rule
    public ActivityTestRule<StalkerActivity> activityTestRule = new ActivityTestRule<StalkerActivity>(StalkerActivity.class) {
        @Override
        protected void beforeActivityLaunched() {
            // Configure the MOCK_STALKER_PRESENTER here
        }
    };

    @Test
    public void shouldNotCrash() {

    }
}

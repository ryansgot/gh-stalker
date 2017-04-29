package com.fsryan.exampleapp.ghstalker.stalker;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.fsryan.exampleapp.ghstalker.R;
import com.fsryan.exampleapp.ghstalker.stalker.events.FindFollowersUserEvent;
import com.fsryan.exampleapp.ghstalker.stalker.events.GHUserUpdateEvent;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.Observable;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.fsryan.exampleapp.ghstalker.stalker.MockStalkerActivityComponent.MOCK_STALKER_PRESENTER;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class StalkerActivityTest {

    @Rule
    public ActivityTestRule<StalkerActivity> activityTestRule = new ActivityTestRule<StalkerActivity>(StalkerActivity.class) {
        @Override
        protected void beforeActivityLaunched() {
            // TODO: extend this
            when(MOCK_STALKER_PRESENTER.registerGHUserUpdateEvents())
                    .thenReturn(Observable.just(new GHUserUpdateEvent()));
        }
    };

    @Test
    public void shouldCallPresenterFindFollowersMethodOnGoButtonClick() {
        final String ghUserName = "test gh username";
        onView(withId(R.id.gh_username_entry_text)).perform(typeText(ghUserName));
        onView(withId(R.id.go_button)).perform(click());
        verify(MOCK_STALKER_PRESENTER).findFollowers(eq(FindFollowersUserEvent.make(ghUserName)));
    }
}

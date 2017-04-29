package com.fsryan.exampleapp.ghstalker.stalker;

import com.fsryan.exampleapp.ghstalker.stalker.events.FindFollowersUserEvent;
import com.fsryan.exampleapp.ghstalker.stalker.events.GHUserUpdateEvent;

import io.reactivex.Observable;

/*package*/ class StalkerPresenterImpl implements Stalker.Presenter {

    @Override
    public Observable<GHUserUpdateEvent> registerGHUserUpdateEvents() {
        // TODO
        return null;
    }

    @Override
    public void findFollowers(FindFollowersUserEvent event) {

    }
}

package com.fsryan.exampleapp.ghstalker.stalker;

import com.fsryan.exampleapp.ghstalker.stalker.events.FindFollowersUserEvent;
import com.fsryan.exampleapp.ghstalker.stalker.events.GHUserUpdateEvent;

import io.reactivex.Observable;

public interface Stalker {
    interface View {

    }

    interface Presenter {
        Observable<GHUserUpdateEvent> registerGHUserUpdateEvents();

        void findFollowers(FindFollowersUserEvent event);
    }

    interface Interactor {

    }
}

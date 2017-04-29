package com.fsryan.exampleapp.ghstalker.stalker.events;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class FindFollowersUserEvent {
    public static FindFollowersUserEvent make(@NonNull String ghUserName) {
        return new AutoValue_FindFollowersUserEvent(ghUserName);
    }
    public abstract String getGhUsername();
}

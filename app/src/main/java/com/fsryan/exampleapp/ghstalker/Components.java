package com.fsryan.exampleapp.ghstalker;

import com.fsryan.exampleapp.ghstalker.stalker.StalkerActivity;
import com.fsryan.exampleapp.ghstalker.stalker.StalkerActivityComponent;

public interface Components {
    AppComponent app();
    StalkerActivityComponent stalkerActivity(StalkerActivity stalkerActivity);
}

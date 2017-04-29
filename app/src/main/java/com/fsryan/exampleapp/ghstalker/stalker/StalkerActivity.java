package com.fsryan.exampleapp.ghstalker.stalker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fsryan.exampleapp.ghstalker.App;
import com.fsryan.exampleapp.ghstalker.R;

import javax.inject.Inject;

public class StalkerActivity extends AppCompatActivity {

    @Inject
    Stalker.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stalker);

        App.components(this).stalkerActivity(this).inject(this);
    }
}

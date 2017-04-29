package com.fsryan.exampleapp.ghstalker.stalker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.fsryan.exampleapp.ghstalker.App;
import com.fsryan.exampleapp.ghstalker.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StalkerActivity extends AppCompatActivity {

    @Inject
    Stalker.Presenter presenter;

    @BindView(R.id.gh_username_entry_text)
    EditText ghUsernameEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stalker);

        App.components(this).stalkerActivity(this).inject(this);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.go_button)
    public void findFollowers(Button goButton) {
        // TODO
    }
}

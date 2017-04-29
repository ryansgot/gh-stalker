package com.fsryan.exampleapp.ghstalker.stalker;

import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.widget.Button;
import android.widget.EditText;

import com.fsryan.exampleapp.ghstalker.App;
import com.fsryan.exampleapp.ghstalker.R;
import com.fsryan.exampleapp.ghstalker.stalker.events.FindFollowersUserEvent;
import com.fsryan.exampleapp.ghstalker.stalker.events.GHUserUpdateEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;

public class StalkerActivity extends RxAppCompatActivity {

    @BindView(R.id.gh_username_entry_text)
    EditText ghUsernameEntry;

    @Inject
    Stalker.Presenter presenter;

    @VisibleForTesting
    Observer<GHUserUpdateEvent> userUpdateEventObserver = new Observer<GHUserUpdateEvent>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onNext(@NonNull GHUserUpdateEvent ghUserUpdateEvent) {
            // TODO
        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stalker);

        App.components(this).stalkerActivity(this).inject(this);

        ButterKnife.bind(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.registerGHUserUpdateEvents()
                .compose(this.<GHUserUpdateEvent>bindToLifecycle())
                .subscribeOn(mainThread())
                .subscribe(userUpdateEventObserver);
    }

    @OnClick(R.id.go_button)
    public void findFollowers(Button goButton) {
        presenter.findFollowers(FindFollowersUserEvent.make(ghUsernameEntry.getText().toString()));
    }
}

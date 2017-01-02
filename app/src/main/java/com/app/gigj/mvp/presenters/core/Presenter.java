package com.app.gigj.mvp.presenters.core;


import com.app.gigj.mvp.views.core.View;

public interface Presenter {
    void onStart();

    void onStop();

    void onPause();

    void attachView(View v);

    void onCreate();
}

package com.app.gigj.injector.modules;


import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.repository.Repository;
import com.app.gigj.support.rest.RestDataSource;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by duanlei on 2016/5/9.
 */
@Module
public class AppModule {

    private final MyApplication mMyApplication;

    public AppModule(MyApplication myApplication) {
        this.mMyApplication = myApplication;
    }

    @Provides
    @Singleton
    MyApplication provideMyApplicationContext() {
        return mMyApplication;
    }

    @Provides
    @Singleton
    Repository provideGoodsRepository() {
        return new RestDataSource(mMyApplication);
    }

    @Provides @Named("executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.io();
    }

    @Provides @Named("ui_thread")
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }

    @Provides @Named("gson")
    Gson provideGson() {
        return new Gson();
    }
}

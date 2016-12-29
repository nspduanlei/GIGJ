package com.app.gigj.injector.components;


import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.repository.Repository;
import com.app.gigj.injector.modules.AppModule;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import rx.Scheduler;

/**
 * Created by duanlei on 2016/5/9.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    MyApplication app();

    Repository goodsRepository();

    @Named("ui_thread")
    Scheduler uiThread();

    @Named("executor_thread")
    Scheduler executorThread();

    @Named("gson")
    Gson gson();
}

package com.app.gigj.injector.components;

import android.content.Context;

import com.app.gigj.injector.Activity;
import com.app.gigj.injector.modules.ActivityModule;

import dagger.Component;

/**
 * Created by duanlei on 2016/5/9.
 */
@Activity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Context context();
}

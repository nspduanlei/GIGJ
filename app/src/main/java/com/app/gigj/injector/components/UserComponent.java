package com.app.gigj.injector.components;


import com.app.gigj.injector.Activity;
import com.app.gigj.injector.modules.ActivityModule;
import com.app.gigj.injector.modules.UserModule;

import dagger.Component;

/**
 * Created by duanlei on 16/9/27.
 */
@Activity
@Component(dependencies = AppComponent.class, modules = {UserModule.class, ActivityModule.class})
public interface UserComponent extends ActivityComponent {

//    void inject(LoginActivity loginActivity);

    //登录
//    LoginUseCase loginUseCase();


}

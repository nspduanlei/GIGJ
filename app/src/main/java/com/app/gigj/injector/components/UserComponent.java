package com.app.gigj.injector.components;


import com.app.gigj.domin.usecase.AddAddressUseCase;
import com.app.gigj.domin.usecase.AppSelectUseCase;
import com.app.gigj.domin.usecase.LoginUseCase;
import com.app.gigj.domin.usecase.SendCodeUseCase;
import com.app.gigj.injector.Activity;
import com.app.gigj.injector.modules.ActivityModule;
import com.app.gigj.injector.modules.UserModule;
import com.app.gigj.views.activities.LoginActivity;
import com.app.gigj.views.activities.RegisterActivity;
import com.app.gigj.views.activities.shipper.AddAddressActivity;
import com.app.gigj.views.fragments.SelectAddressFragment;

import dagger.Component;

/**
 * Created by duanlei on 16/9/27.
 */
@Activity
@Component(dependencies = AppComponent.class, modules = {UserModule.class, ActivityModule.class})
public interface UserComponent extends ActivityComponent {

    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);
    void inject(SelectAddressFragment selectAddressFragment);
    void inject(AddAddressActivity addAddressActivity);

    AppSelectUseCase appSelectUseCase();
    SendCodeUseCase sendCodeUseCase();
    LoginUseCase loginUseCase();
    AddAddressUseCase addAddressUseCase();


}

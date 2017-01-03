package com.app.gigj.domin.usecase;


import com.app.gigj.domin.model.request.Login;
import com.app.gigj.domin.model.request.LoginRequestBody;
import com.app.gigj.domin.model.request.core.RequestEnvelope;
import com.app.gigj.domin.model.response.login.LoginResponseEnvelope;
import com.app.gigj.domin.repository.Repository;
import com.app.gigj.domin.usecase.core.UseCase;
import com.app.gigj.utils.MD5Util;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by duanlei on 2016/5/16.
 * 登录
 */
public class LoginUseCase extends UseCase<LoginResponseEnvelope> {

    private final Repository mRepository;
    private final Scheduler mUiThread;
    private final Scheduler mExecutorThread;
    private RequestEnvelope mRequestEnvelope;

    @Inject
    public LoginUseCase(Repository repository,
                        @Named("ui_thread") Scheduler uiThread,
                        @Named("executor_thread") Scheduler executorThread,
                        RequestEnvelope requestEnvelope) {
        mRepository = repository;
        mUiThread = uiThread;
        mExecutorThread = executorThread;
        mRequestEnvelope = requestEnvelope;
    }

    public void setLoginData(String phone, String password) {
        setData(phone, password);
    }

    private void setData(String phone, String password) {
        LoginRequestBody requestBody = new LoginRequestBody();
        Login login = new Login();

        login.setPhoneVer(MD5Util.getMd5UserId(phone));
        login.setPhone(phone);
        login.setPasswordMd5(MD5Util.getMd5Password(password));
        login.setApp("APP");

        requestBody.setLogin(login);
        mRequestEnvelope.setBody(requestBody);
    }

    @Override
    public Observable<LoginResponseEnvelope> buildObservable() {
        return mRepository.login(mRequestEnvelope)
                .observeOn(mUiThread)
                .subscribeOn(mExecutorThread);
    }
}

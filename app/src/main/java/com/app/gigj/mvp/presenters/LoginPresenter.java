package com.app.gigj.mvp.presenters;

import com.app.gigj.domin.entities.User;
import com.app.gigj.domin.entities.func.Result;
import com.app.gigj.domin.model.response.login.LoginResponseEnvelope;
import com.app.gigj.domin.usecase.LoginUseCase;
import com.app.gigj.mvp.presenters.core.Presenter;
import com.app.gigj.mvp.views.LoginView;
import com.app.gigj.mvp.views.core.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by duanlei on 17/1/2.
 */

public class LoginPresenter implements Presenter {

    LoginUseCase mLoginUseCase;
    LoginView mLoginView;

    Gson mGson;

    @Inject
    public LoginPresenter(LoginUseCase loginUseCase,
                          @Named("gson") Gson gson) {
        mLoginUseCase = loginUseCase;
        mGson = gson;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void attachView(View v) {
        mLoginView = (LoginView) v;
    }

    @Override
    public void onCreate() {

    }

    public void login(String phone, String password) {
        mLoginView.showLoadingView();

        mLoginUseCase.setLoginData(phone, password);
        mLoginUseCase.execute().subscribe(this::onLoginReceived, this::manageError);
    }

    private void manageError(Throwable throwable) {
        mLoginView.hideLoadingView();
    }

    private void onLoginReceived(LoginResponseEnvelope responseEnvelope) {
        mLoginView.hideLoadingView();

        String json = responseEnvelope.getBody().getResponse().getResult();
        User result = mGson.fromJson(json, User.class);

        if (result.getState().equals("true")) {
            mLoginView.onLoginSuccess(result);
        } else {
            mLoginView.onError("0", result.getError());
        }

    }
}

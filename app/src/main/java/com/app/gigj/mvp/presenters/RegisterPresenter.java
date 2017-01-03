package com.app.gigj.mvp.presenters;

import com.app.gigj.domin.entities.Address;
import com.app.gigj.domin.entities.Company;
import com.app.gigj.domin.entities.func.ResultList;
import com.app.gigj.domin.model.response.appselect.AppSelectResponseEnvelope;
import com.app.gigj.domin.model.response.sendver.SendCodeResponseEnvelope;
import com.app.gigj.domin.usecase.AppSelectUseCase;
import com.app.gigj.domin.usecase.SendCodeUseCase;
import com.app.gigj.mvp.presenters.core.Presenter;
import com.app.gigj.mvp.views.RegisterView;
import com.app.gigj.mvp.views.core.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by duanlei on 16/12/31.
 */
public class RegisterPresenter implements Presenter {

    AppSelectUseCase mAppSelectUseCase;
    SendCodeUseCase mSendCodeUseCase;

    RegisterView mRegisterView;

    Gson mGson;

    @Inject
    public RegisterPresenter(AppSelectUseCase appSelectUseCase,
                             SendCodeUseCase sendCodeUseCase,
                             @Named("gson") Gson gson) {
        mAppSelectUseCase = appSelectUseCase;
        mSendCodeUseCase = sendCodeUseCase;
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
        mRegisterView = (RegisterView) v;
    }

    @Override
    public void onCreate() {

    }

    /**
     * 获取省
     */
    public void getProvince() {
        mRegisterView.showLoadingView();

        mAppSelectUseCase.setProvinceData();
        mAppSelectUseCase.execute().subscribe(this::onGetProvinceReceived, this::manageError);
    }

    private void manageError(Throwable throwable) {
        mRegisterView.hideLoadingView();
    }

    private void onGetProvinceReceived(AppSelectResponseEnvelope responseEnvelope) {
        mRegisterView.hideLoadingView();

        String json = responseEnvelope.getBody().getResponse().getResult();
        Type type = new TypeToken<ResultList<Address>>(){}.getType();
        ResultList<Address> resultList = mGson.fromJson(json, type);

        if (resultList.getState().equals("true")) {
            mRegisterView.onProvinceSuccess(resultList.getRow01());
        } else {
            mRegisterView.onError(resultList.getError(),
                    "");
        }
    }

    /**
     * 获取市
     */
    public void getCity(String pName) {
        mRegisterView.showLoadingView();

        mAppSelectUseCase.setCityData(pName);
        mAppSelectUseCase.execute().subscribe(this::onGetCityReceived, this::manageError);
    }

    private void onGetCityReceived(AppSelectResponseEnvelope responseEnvelope) {
        mRegisterView.hideLoadingView();

        String json = responseEnvelope.getBody().getResponse().getResult();
        Type type = new TypeToken<ResultList<Address>>(){}.getType();
        ResultList<Address> resultList = mGson.fromJson(json, type);

        if (resultList.getState().equals("true")) {
            mRegisterView.onCitySuccess(resultList.getRow01());
        } else {
            mRegisterView.onError(resultList.getError(),
                    "");
        }
    }

    /**
     * 获取公司
     */
    public void getCompany() {
        mRegisterView.showLoadingView();

        mAppSelectUseCase.setCompanyData();
        mAppSelectUseCase.execute().subscribe(this::onGetCompanyReceived, this::manageError);
    }

    private void onGetCompanyReceived(AppSelectResponseEnvelope responseEnvelope) {
        mRegisterView.hideLoadingView();

        String json = responseEnvelope.getBody().getResponse().getResult();
        Type type = new TypeToken<ResultList<Company>>(){}.getType();
        ResultList<Company> resultList = mGson.fromJson(json, type);

        if (resultList.getState().equals("true")) {
            mRegisterView.onCompanySuccess(resultList.getRow01());
        } else {
            mRegisterView.onError(resultList.getError(),
                    "");
        }
    }


    public void sendCode(String phone) {
        mRegisterView.showLoadingView();

        mSendCodeUseCase.setSendCodeData(phone);
        mSendCodeUseCase.execute().subscribe(this::onSendCodeReceived, this::manageError);

    }

    private void onSendCodeReceived(SendCodeResponseEnvelope responseEnvelope) {
        mRegisterView.hideLoadingView();

//        String json = responseEnvelope.getBody().getGetAreaResponse().getGetConnectionResult();
//        Type type = new TypeToken<ResultList<Company>>(){}.getType();
//        ResultList<Company> resultList = mGson.fromJson(json, type);
//
//        if (resultList.getState().equals("true")) {
//            mRegisterView.onCompanySuccess(resultList.getRow01());
//        } else {
//            mRegisterView.onError(resultList.getError(),
//                    "");
//        }
    }


}

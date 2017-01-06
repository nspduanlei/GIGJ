package com.app.gigj.mvp.presenters;

import com.app.gigj.domin.model.response.appselect.AppSelectResponseEnvelope;
import com.app.gigj.domin.model.response.login.LoginResponseEnvelope;
import com.app.gigj.domin.usecase.AddAddressUseCase;
import com.app.gigj.domin.usecase.AppSelectUseCase;
import com.app.gigj.mvp.presenters.core.Presenter;
import com.app.gigj.mvp.views.AddAddrView;
import com.app.gigj.mvp.views.core.View;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by duanlei on 2017/1/6.
 */

public class AddAddrPresenter implements Presenter {

    AddAddressUseCase mAddAddressUseCase;
    AppSelectUseCase mAppSelectUseCase;

    AddAddrView mAddAddrView;

    Gson mGson;

    @Inject
    public AddAddrPresenter(AddAddressUseCase addAddressUseCase,
                            AppSelectUseCase appSelectUseCase,
                            @Named("gson") Gson gson) {
        mAddAddressUseCase = addAddressUseCase;
        mAppSelectUseCase = appSelectUseCase;
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
        mAddAddrView = (AddAddrView) v;
    }

    @Override
    public void onCreate() {

    }

    /**
     * 添加地址
     *
     * @param areaId
     * @param detail
     * @param userId
     * @param password
     */
    public void addAddr(String areaId, String detail, String userId, String password) {
        mAddAddrView.showLoadingView();

        mAddAddressUseCase.setAddData(areaId, detail, userId, password);
        mAddAddressUseCase.execute().subscribe(this::onAddReceived, this::manageError);
    }

    private void onAddReceived(LoginResponseEnvelope loginResponseEnvelope) {
        mAddAddrView.hideLoadingView();
    }

    private void manageError(Throwable throwable) {
        mAddAddrView.hideLoadingView();
    }

    /**
     * 获取行政区域
     *
     * @param userId
     * @param password
     */
    public void getArea(String userId, String password) {
        mAddAddrView.showLoadingView();

        mAppSelectUseCase.setAddProData(userId, password);
        mAppSelectUseCase.execute().subscribe(this::onGetAreaReceived, this::manageError);
    }

    private void onGetAreaReceived(AppSelectResponseEnvelope appSelectResponseEnvelope) {
        mAddAddrView.hideLoadingView();

    }
}

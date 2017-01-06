package com.app.gigj.views.activities.shipper;

import android.os.Bundle;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.injector.components.DaggerUserComponent;
import com.app.gigj.injector.modules.ActivityModule;
import com.app.gigj.mvp.presenters.AddAddrPresenter;
import com.app.gigj.mvp.views.AddAddrView;
import com.app.gigj.mvp.views.core.View;
import com.app.gigj.utils.SPUtils;
import com.app.gigj.views.activities.core.BaseActivity;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by duanlei on 2017/1/6.
 */

public class AddAddressActivity extends BaseActivity implements AddAddrView {

    @Inject
    AddAddrPresenter mAddAddrPresenter;

    String mUserId, mPassword;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_add_address, R.string.title_address_mana);
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {

        mUserId = (String) SPUtils.get(this, SPUtils.USER_NO, "");
        mPassword = (String) SPUtils.get(this, SPUtils.PASSWORD, "");

        mAddAddrPresenter.addAddr("", "地址详情", mUserId, mPassword);
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {
        DaggerUserComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(application.getAppComponent())
                .build().inject(this);
    }

    @Override
    protected void initPresenter() {
        mAddAddrPresenter.attachView(this);
        mAddAddrPresenter.onCreate();
    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    public void onError(String errorCode, String errorMsg) {

    }

    /**
     * 选择省
     * @param view
     */
    @OnClick(R.id.fl_pro)
    void onProClicked(View view) {
        mAddAddrPresenter.getArea(mUserId, mPassword);
    }

    /**
     * 选择市
     * @param view
     */
    @OnClick(R.id.fl_city)
    void onCityClicked(View view) {


    }

    /**
     * 选择区
     * @param view
     */
    @OnClick(R.id.fl_area)
    void onAreaClicked(View view) {


    }
}

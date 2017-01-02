package com.app.gigj.views.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.entities.Address;
import com.app.gigj.domin.entities.Company;
import com.app.gigj.domin.entities.func.MenuEntity;
import com.app.gigj.injector.components.DaggerUserComponent;
import com.app.gigj.injector.modules.ActivityModule;
import com.app.gigj.mvp.presenters.RegisterPresenter;
import com.app.gigj.mvp.views.RegisterView;
import com.app.gigj.utils.MyUtils;
import com.app.gigj.utils.StringUtils;
import com.app.gigj.utils.T;
import com.app.gigj.views.activities.core.BaseActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by duanlei on 2016/12/29.
 */

public class RegisterActivity extends BaseActivity implements RegisterView {

    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_pw)
    EditText mEtPw;
    @BindView(R.id.et_nick_name)
    EditText mEtNickName;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;

    @BindView(R.id.tv_province)
    TextView mTvProvince;
    @BindView(R.id.tv_city)
    TextView mTvCity;
    @BindView(R.id.tv_company)
    TextView mTvCompany;

    @Inject
    RegisterPresenter mRegisterPresenter;

    String mProvinceName, mCityName;
    int mCompanyCode;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_register, R.string.title_register);
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
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
        mRegisterPresenter.attachView(this);
        mRegisterPresenter.onCreate();
    }

    /**
     * 提交
     *
     * @param view
     */
    @OnClick(R.id.btn_submit)
    void onSubmitClicked(View view) {

    }

    /**
     * 获取验证码
     *
     * @param view
     */
    @OnClick(R.id.btn_get_code)
    void onGetCodeClicked(View view) {
        String phone = mEtPhone.getText().toString().trim();
        String msg = StringUtils.checkMobile(phone);
        if (!msg.equals("")) {
            T.showShort(this, msg);
            return;
        }

        mRegisterPresenter.sendCode(phone);

    }

    /**
     * 选择地址
     *
     * @param view
     */
    @OnClick(R.id.tv_province)
    void onSelectProvince(View view) {
        mRegisterPresenter.getProvince();
    }

    @OnClick(R.id.tv_city)
    void onSelectCity(View view) {
        if (mProvinceName == null) {
            T.showShort(this, "请先选择省");
            return;
        }
        mRegisterPresenter.getCity(mProvinceName);
    }

    @OnClick(R.id.tv_company)
    void onSelectCompany(View view) {
        mRegisterPresenter.getCompany();
    }

    @Override
    public void showLoadingView() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingView() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void onError(String errorCode, String errorMsg) {

    }

    @Override
    public void onProvinceSuccess(ArrayList<Address> addresses) {

        ArrayList<MenuEntity> menuEntities = new ArrayList<>();
        for (int i = 0; i < addresses.size(); i++) {
            menuEntities.add(new MenuEntity(i, addresses.get(i).getSHENG()));
        }

        MyUtils.showListDialog(this, menuEntities, (dialog, item, view, position) -> {
            mProvinceName = menuEntities.get(position).getName();
            mTvProvince.setText(mProvinceName);
            dialog.dismiss();
        });
    }

    @Override
    public void onCitySuccess(ArrayList<Address> addresses) {
        ArrayList<MenuEntity> menuEntities = new ArrayList<>();
        for (int i = 0; i < addresses.size(); i++) {
            menuEntities.add(new MenuEntity(i, addresses.get(i).getSHI()));
        }

        MyUtils.showListDialog(this, menuEntities, (dialog, item, view, position) -> {
            mCityName = menuEntities.get(position).getName();
            mTvCity.setText(mCityName);
            dialog.dismiss();
        });
    }

    @Override
    public void onCompanySuccess(ArrayList<Company> companies) {
        ArrayList<MenuEntity> menuEntities = new ArrayList<>();
        for (int i = 0; i < companies.size(); i++) {
            menuEntities.add(new MenuEntity(companies.get(i).getID(), companies.get(i).getGSMC()));
        }

        MyUtils.showListDialog(this, menuEntities, (dialog, item, view, position) -> {
            mCompanyCode = menuEntities.get(position).getResId();
            mTvCompany.setText(menuEntities.get(position).getName());
            dialog.dismiss();
        });
    }
}

package com.app.gigj.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.entities.User;
import com.app.gigj.injector.components.DaggerUserComponent;
import com.app.gigj.injector.modules.ActivityModule;
import com.app.gigj.mvp.presenters.LoginPresenter;
import com.app.gigj.mvp.views.LoginView;
import com.app.gigj.utils.StringUtils;
import com.app.gigj.utils.T;
import com.app.gigj.views.activities.core.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by duanlei on 2016/12/28.
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    LoginPresenter mLoginPresenter;

    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_login, R.string.title_login);
        setMenuText("注册", v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
        //test
        mEtPassword.setText("123456");
        mEtPhone.setText("15826508722");

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
        mLoginPresenter.attachView(this);
        mLoginPresenter.onCreate();
    }

    @OnClick(R.id.btn_login)
    void onLoginClicked(View view) {

        String phone = mEtPhone.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        String msgPhone = StringUtils.checkMobile(phone);

        if (StringUtils.isNullOrEmpty(phone)) {
            T.showShort(this, "密码不能为空");
            return;
        }

        if (!msgPhone.equals("")) {
            T.showShort(this, msgPhone);
            return;
        }

        mLoginPresenter.login(phone, password);
//        Intent intent = new Intent(this, UserInfoActivity.class);
//        startActivity(intent);
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
        T.showShort(this, errorMsg);
    }

    @Override
    public void onLoginSuccess(User user) {

        T.showShort(this, "登录成功");
    }
}

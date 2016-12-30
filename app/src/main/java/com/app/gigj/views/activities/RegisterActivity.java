package com.app.gigj.views.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by duanlei on 2016/12/29.
 */

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_pw)
    EditText mEtPw;
    @BindView(R.id.et_nick_name)
    EditText mEtNickName;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.et_company)
    EditText mEtCompany;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_register, R.string.title_register);
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {

    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }

    /**
     * 提交
     * @param view
     */
    @OnClick(R.id.btn_submit)
    void onSubmitClicked(View view) {

    }

    /**
     * 获取验证码
     * @param view
     */
    @OnClick(R.id.btn_get_code)
    void onGetCodeClicked(View view) {


    }

    /**
     * 选择地址
     * @param view
     */
    @OnClick(R.id.tv_address)
    void onSelectAddress(View view) {

    }
}

package com.app.gigj.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.utils.SPUtils;
import com.app.gigj.views.activities.core.BaseActivity;

import butterknife.OnClick;

/**
 * Created by duanlei on 2016/12/29.
 * 用户资料
 */

public class UserInfoActivity extends BaseActivity {

    private String mUserId;
    private boolean mIsShow = false;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_user_info, R.string.title_user_info);

        mUserId = (String) SPUtils.get(this, SPUtils.USER_NO, "");
        if (!mUserId.equals("")) {
            setMenuText("修改密码", v -> {

            });

            mIsShow = true;
        }
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {

        if (mIsShow) {
            //获取用户信息，填充

        }

    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }

    @OnClick(R.id.btn_submit)
    void onSubmitClicked(View view) {
        Intent intent = new Intent(this, SelectRoleActivity.class);
        startActivity(intent);
    }
}

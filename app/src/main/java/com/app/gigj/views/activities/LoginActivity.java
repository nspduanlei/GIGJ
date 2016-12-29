package com.app.gigj.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseActivity;

import butterknife.OnClick;

/**
 * Created by duanlei on 2016/12/28.
 */

public class LoginActivity extends BaseActivity {
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

    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }

    @OnClick(R.id.btn_login)
    void onLoginClicked(View view) {
        Intent intent = new Intent(this, UserInfoActivity.class);
        startActivity(intent);

    }

}

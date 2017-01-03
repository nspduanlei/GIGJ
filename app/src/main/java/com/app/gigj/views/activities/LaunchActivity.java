package com.app.gigj.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.app.gigj.app.MyApplication;
import com.app.gigj.utils.SPUtils;
import com.app.gigj.utils.StringUtils;
import com.app.gigj.views.activities.core.BaseActivity;
import com.app.gigj.views.activities.shipper.MainActivity;

/**
 * Created by duanlei on 2016/12/29.
 */

public class LaunchActivity extends BaseActivity {
    @Override
    protected void setUpContentView() {
        setContentView(-1, -1, MODE_NONE);
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {

        //隐藏状态栏 和 导航栏
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);


        pageIntent();
    }

    private void pageIntent() {

        new Handler().postDelayed(() -> {

            //如果第一次进入页面去引导页
            if (!(Boolean) SPUtils.get(this, SPUtils.IS_FIRST_LAUNCH, false)) {
                Intent intent = new Intent(this, GuideActivity.class);
                startActivity(intent);

                SPUtils.put(this, SPUtils.IS_FIRST_LAUNCH, true);
            } else {

                //如果没有登录去登录
                if (StringUtils.isNullOrEmpty((String) SPUtils.get(this, SPUtils.USER_NO, ""))) {
                    Intent intent = new Intent(LaunchActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            this.finish();
        }, 2000);
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}

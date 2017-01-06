package com.app.gigj.views.activities.admin;

import android.os.Bundle;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseActivity;

/**
 * Created by duanlei on 2016/12/30.
 */

public class AboutUsActivity extends BaseActivity {

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_about_us, R.string.title_about_us);
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
}

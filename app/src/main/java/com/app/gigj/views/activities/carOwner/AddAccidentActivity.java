package com.app.gigj.views.activities.carOwner;

import android.os.Bundle;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseActivity;

/**
 * Created by duanlei on 2017/1/5.
 */

public class AddAccidentActivity extends BaseActivity {
    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_accident_add, R.string.title_accident_add);
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
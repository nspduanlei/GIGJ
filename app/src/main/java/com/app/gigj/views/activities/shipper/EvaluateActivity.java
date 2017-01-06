package com.app.gigj.views.activities.shipper;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseFragmentActivity;
import com.app.gigj.views.fragments.shipper.EvaluateFragment;

/**
 * Created by duanlei on 2017/1/6.
 */

public class EvaluateActivity extends BaseFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new EvaluateFragment();
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle("查看评价");
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}

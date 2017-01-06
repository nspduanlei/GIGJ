package com.app.gigj.views.activities.shipper;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseTabActivity;
import com.app.gigj.views.fragments.shipper.MyChitFragment;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/6.
 */

public class MyChitActivity extends BaseTabActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "车辆保单", "货物保单"
    };


    @Override
    protected OnTabSelectListener getTabSelectListener() {
        return null;
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle("我的保单");

        mFragments.add(new MyChitFragment());
        mFragments.add(new MyChitFragment());

        initPage(mFragments, mTitles);
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}

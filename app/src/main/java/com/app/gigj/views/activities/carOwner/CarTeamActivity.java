package com.app.gigj.views.activities.carOwner;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseTabActivity;
import com.app.gigj.views.fragments.carOwner.MyCarsFragment;
import com.app.gigj.views.fragments.carOwner.MyDriversFragment;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/4.
 * 我的车队
 */
public class CarTeamActivity extends BaseTabActivity {


    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "我的司机", "我的车队"
    };

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle("我的车队");

        mFragments.add(new MyDriversFragment());
        mFragments.add(new MyCarsFragment());
        initPage(mFragments, mTitles);
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected OnTabSelectListener getTabSelectListener() {
        return null;
    }
}

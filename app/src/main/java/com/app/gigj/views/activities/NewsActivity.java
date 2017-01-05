package com.app.gigj.views.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseTabActivity;
import com.app.gigj.views.fragments.NewsFragment;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/4.
 */

public class NewsActivity extends BaseTabActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "行业新闻", "政治新闻", "通知公告"
    };

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle("新闻通知");

        mFragments.add(new NewsFragment());
        mFragments.add(new NewsFragment());
        mFragments.add(new NewsFragment());
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

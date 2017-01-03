package com.app.gigj.views.activities.core;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.app.gigj.R;
import com.app.gigj.views.adapter.MyPagerAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by duanlei on 2017/1/3.
 */

public abstract class BaseTabActivity extends BaseActivity {

    @BindView(R.id.tl_top)
    SlidingTabLayout mTlTop;
    @BindView(R.id.vp_content)
    ViewPager mVpContent;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles;

    private MyPagerAdapter mAdapter;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_g_manage);

    }

    protected void initPage() {
        setFragments(mFragments);
        setTitles(mTitles);

        mAdapter = new MyPagerAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mVpContent.setAdapter(mAdapter);

        mTlTop.setViewPager(mVpContent);

        mTlTop.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    protected abstract void setFragments(ArrayList<Fragment> fragments);
    protected abstract void setTitles(String[] titles);



}

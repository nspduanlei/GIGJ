package com.app.gigj.views.fragments.core;

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

public abstract class BaseTabFragment extends BaseFragment {

    @BindView(R.id.tl_top)
    SlidingTabLayout mTlTop;
    @BindView(R.id.vp_content)
    ViewPager mVpContent;

    private ArrayList<Fragment> mFragments;
    private String[] mTitles;

    private MyPagerAdapter mAdapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_g_manage;
    }

    protected void initPage(ArrayList<Fragment> fragments, String[] titles) {
        setFragments(fragments);
        setTitles(titles);

        mAdapter = new MyPagerAdapter(getFragmentManager(), mFragments, mTitles);
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

    protected void setFragments(ArrayList<Fragment> fragments) {
        mFragments = fragments;
    }
    protected void setTitles(String[] titles) {
        mTitles = titles;
    }



}

package com.app.gigj.views.activities.driver;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseActivity;
import com.app.gigj.views.adapter.MyPagerAdapter;
import com.app.gigj.views.fragments.driver.AddGasolineCard;
import com.app.gigj.views.fragments.driver.AddGasolineRecord;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by duanlei on 2017/1/3.
 */

public class AddGasolineActivity extends BaseActivity {

    @BindView(R.id.tl_top)
    SlidingTabLayout mTlTop;
    @BindView(R.id.vp_content)
    ViewPager mVpContent;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "加油记录", "加油卡"
    };
    private MyPagerAdapter mAdapter;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_g_manage, R.string.title_g_manage);
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
        mFragments.add(new AddGasolineRecord());
        mFragments.add(new AddGasolineCard());

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

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}

package com.app.gigj.views.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/3.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments;
    private String[] mTitles;


    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments,
                          String[] titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

//列表更新
//    @Override
//    public int getItemPosition(Object object) {
//        if (object instanceof GasolineRecordFragment) {
//            ((GasolineRecordFragment) object).updateData();
//        } else if (object instanceof AboutFragment) {
//            ((AboutFragment) object).updateData();
//        }
//        return super.getItemPosition(object);
//    }
}

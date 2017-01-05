package com.app.gigj.views.activities.carOwner;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseTabActivity;
import com.app.gigj.views.fragments.carOwner.LawServiceFragment;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/5.
 * 法律服务
 */

public class LawServiceActivity extends BaseTabActivity {


    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "法务知识", "安全常识查询", "安全事项提醒", "法律申请"
    };

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle("法律服务");

        mFragments.add(new LawServiceFragment());
        mFragments.add(new LawServiceFragment());
        mFragments.add(new LawServiceFragment());
        mFragments.add(new LawServiceFragment());
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

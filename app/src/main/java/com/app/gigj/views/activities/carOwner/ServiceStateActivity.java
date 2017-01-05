package com.app.gigj.views.activities.carOwner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseTabActivity;
import com.app.gigj.views.fragments.carOwner.ServiceStateFragment;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/5.
 * 维修状态
 */

public class ServiceStateActivity extends BaseTabActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "全部", "正在维修", "已经维修", "已取消"
    };

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle("维修状态");
        setMenuText("添加记录", v -> {
            Intent intent = new Intent(this, AddServiceCarActivity.class);
            startActivity(intent);
        });

        mFragments.add(new ServiceStateFragment());
        mFragments.add(new ServiceStateFragment());
        mFragments.add(new ServiceStateFragment());
        mFragments.add(new ServiceStateFragment());
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
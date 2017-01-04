package com.app.gigj.views.activities.shipper;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseTabActivity;
import com.app.gigj.views.fragments.shipper.OrdersFragment;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/4.
 */

public class OrdersActivity extends BaseTabActivity {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "待审核", "已审核", "运输中", "运输完成", "已取消"
    };

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle("我的订单");

        mFragments.add(new OrdersFragment());
        mFragments.add(new OrdersFragment());
        mFragments.add(new OrdersFragment());
        mFragments.add(new OrdersFragment());
        mFragments.add(new OrdersFragment());
        initPage(mFragments, mTitles);
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}

package com.app.gigj.views.activities.shipper;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseTabActivity;
import com.app.gigj.views.fragments.shipper.OrdersFragment;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/4.
 */

public class OrdersActivity extends BaseTabActivity {
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    //货主
    private final String[] mTitles = {
            "待审核", "已审核", "运输中", "运输完成", "已取消"
    };

    //司机
    private final String[] mTitlesDriver = {
            "待审核", "已接单", "运输中", "运输完成", "已取消"
    };

    public static final String ARG_TYPE = "arg_type";

    /**
     * 0:货主
     * 1:车主
     */
    private int mType;

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle("我的订单");
        mType = getIntent().getIntExtra(ARG_TYPE, 0);
        mFragments.add(new OrdersFragment());
        mFragments.add(new OrdersFragment());
        mFragments.add(new OrdersFragment());
        mFragments.add(new OrdersFragment());
        mFragments.add(new OrdersFragment());

        switch (mType) {
            case 0:
                initPage(mFragments, mTitles);
                break;
            case 1:
                initPage(mFragments, mTitlesDriver);
                break;
            default:
                initPage(mFragments, mTitles);
                break;
        }
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

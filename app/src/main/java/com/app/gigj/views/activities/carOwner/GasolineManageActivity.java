package com.app.gigj.views.activities.carOwner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseTabActivity;
import com.app.gigj.views.fragments.carOwner.GasolineCardFragment;
import com.app.gigj.views.fragments.carOwner.GasolineRecordFragment;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/3.
 * 加油管理
 */
public class GasolineManageActivity extends BaseTabActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "加油记录", "加油卡"
    };

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle(R.string.title_g_manage);
        setMenuText("添加记录", v -> {
            Intent intent = new Intent(this, AddGasolineActivity.class);
            startActivity(intent);
        });

        mFragments.add(new GasolineRecordFragment());
        mFragments.add(new GasolineCardFragment());
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

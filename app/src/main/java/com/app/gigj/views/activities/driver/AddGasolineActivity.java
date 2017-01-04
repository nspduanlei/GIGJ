package com.app.gigj.views.activities.driver;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseTabActivity;
import com.app.gigj.views.fragments.driver.AddGasolineCard;
import com.app.gigj.views.fragments.driver.AddGasolineRecord;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/3.
 */

public class AddGasolineActivity extends BaseTabActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "加油记录", "加油卡"
    };

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle(R.string.title_g_manage);

        mFragments.add(new AddGasolineRecord());
        mFragments.add(new AddGasolineCard());
        initPage(mFragments, mTitles);
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}

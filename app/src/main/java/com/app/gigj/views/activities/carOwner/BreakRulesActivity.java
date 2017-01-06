package com.app.gigj.views.activities.carOwner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseActivity;
import com.app.gigj.views.fragments.carOwner.BreakRulesFragment;
import com.app.gigj.views.fragments.carOwner.CarCheckFragment;

/**
 * Created by duanlei on 2017/1/5.
 */

public class BreakRulesActivity extends BaseActivity {

    public static final String ARG_TYPE = "arg_type";

    Fragment mFragment;
    /**
     * 0: 违章信息
     * 1: 年检信息
     */
    private int mType;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_break_rules, R.string.title_break_rules);

        mType = getIntent().getIntExtra(ARG_TYPE, 0);

        setMenuText("添加", v -> {
            if (mType == 0) {
                Intent intent = new Intent(BreakRulesActivity.this, AddBreakRulesActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(BreakRulesActivity.this, AddCarCheckActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {

        if (mType == 0) {
            mFragment = new BreakRulesFragment();
        } else {
            mFragment = new CarCheckFragment();
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mFragment)
                .commit();
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}

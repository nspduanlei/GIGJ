package com.app.gigj.views.activities;

import android.os.Bundle;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseActivity;
import com.app.gigj.views.fragments.SelectAddressFragment;
import com.app.gigj.views.fragments.core.BaseListFragment;

/**
 * Created by duanlei on 17/1/1.
 */

public class SelectListActivity extends BaseActivity {


    public static final int TYPE_ADDRESS = 1;
    public static final int TYPE_COMPANY = 2;

    private int mType = 1;
    public static final String ARG_TYPE = "arg_type";

    private BaseListFragment mBaseListFragment;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_select_list, R.string.title_select_address);
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
        mType = getIntent().getIntExtra(ARG_TYPE, TYPE_ADDRESS);
        switch (mType) {
            case TYPE_ADDRESS:
                setUpTitle(R.string.title_select_address);

                mBaseListFragment = new SelectAddressFragment();

                break;
            case TYPE_COMPANY:
                setUpTitle(R.string.title_select_company);
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mBaseListFragment)
                .commit();
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}

package com.app.gigj.views.activities.core;

import android.support.v4.app.Fragment;

import com.app.gigj.R;

/**
 * Created by duanlei on 2017/1/6.
 */

public abstract class BaseFragmentActivity extends BaseActivity {
    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_fragment);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, getFragment())
                .commit();
    }

    protected abstract Fragment getFragment();
}

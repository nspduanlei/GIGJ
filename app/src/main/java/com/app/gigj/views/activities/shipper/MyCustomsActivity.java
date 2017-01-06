package com.app.gigj.views.activities.shipper;

import android.os.Bundle;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseActivity;
import com.app.gigj.views.fragments.shipper.MyCustomsFragment;

/**
 * Created by duanlei on 2017/1/6.
 */

public class MyCustomsActivity extends BaseActivity {
    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_my_customs, R.string.title_my_customs);
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new MyCustomsFragment())
                .commit();
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}

package com.app.gigj.views.activities.shipper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseFragmentActivity;
import com.app.gigj.views.fragments.shipper.AddressManaFragment;

/**
 * Created by duanlei on 2017/1/6.
 */

public class AddressManaActivity extends BaseFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new AddressManaFragment();
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {
        setUpTitle("我的常用路线");
        setMenuText("添加", v -> {
            Intent intent = new Intent(AddressManaActivity.this, AddAddressActivity.class);
            startActivity(intent);
        });

    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }
}

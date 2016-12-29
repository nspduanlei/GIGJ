package com.app.gigj.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseActivity;
import com.app.gigj.views.activities.shipper.AuthCenterActivity;
import com.app.gigj.views.activities.shipper.MainActivity;

import org.eclipse.jdt.internal.compiler.batch.Main;

import butterknife.OnClick;

/**
 * Created by duanlei on 2016/12/29.
 * 选择角色
 */

public class SelectRoleActivity extends BaseActivity {
    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_select_role, R.string.title_select_role);
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {

    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }

    @OnClick(R.id.btn_shipper)
    void onShipperClicked(View view) {
        Intent intent = new Intent(this, AuthCenterActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_driver)
    void onDriverClicked(View view) {

    }
    @OnClick(R.id.btn_car_owner)
    void onCarOwnerClicked(View view) {

    }
    @OnClick(R.id.btn_admin)
    void onAdminClicked(View view) {

    }
}

package com.app.gigj.views.activities.shipper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.views.activities.core.BaseActivity;
import com.app.gigj.views.widget.listView.CommonAdapter;
import com.app.gigj.views.widget.listView.MyViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by duanlei on 2016/12/29.
 * 货主认证
 */
public class AuthCenterActivity extends BaseActivity {

    @BindView(R.id.gv_ids)
    GridView mGvIds;

    ArrayList<String> mTitles;

    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_auth_center, R.string.title_auth_center);
    }

    @Override
    protected void initUi(Bundle savedInstanceState) {

        mTitles = new ArrayList<>();
        mTitles.add("身份证正面");
        mTitles.add("身份证反面");
        mTitles.add("本人持身份证照");
        mTitles.add("本人正面照");

        mGvIds.setAdapter(new CommonAdapter<String>(this, mTitles, R.layout.item_auth_id) {
            @Override
            public void convert(MyViewHolder holder, String s) {
                holder.setText(R.id.tv_title, s);
            }
        });
    }

    @Override
    protected void initDependencyInjector(MyApplication application) {

    }

    @Override
    protected void initPresenter() {

    }

    @OnClick(R.id.btn_submit)
    void onSubmitClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

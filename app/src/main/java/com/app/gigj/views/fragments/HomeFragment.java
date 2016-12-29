package com.app.gigj.views.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.GridView;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.entities.MenuEntity;
import com.app.gigj.views.activities.shipper.AuthCenterActivity;
import com.app.gigj.views.fragments.core.BaseFragment;
import com.app.gigj.views.widget.listView.CommonAdapter;
import com.app.gigj.views.widget.listView.MyViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by duanlei on 2016/12/29.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.gv_buttons)
    GridView mGvIds;

    ArrayList<MenuEntity> mMenuEntities;

    @Override
    protected void initUI(View view) {

        mMenuEntities = new ArrayList<>();
        mMenuEntities.add(new MenuEntity(R.drawable.btn_home1, "我的发货订单"));
        mMenuEntities.add(new MenuEntity(R.drawable.btn_home2, "我的配送订单"));
        mMenuEntities.add(new MenuEntity(R.drawable.btn_home3, "加油管理"));
        mMenuEntities.add(new MenuEntity(R.drawable.btn_home4, "车辆维修管理"));
        mMenuEntities.add(new MenuEntity(R.drawable.btn_home5, "新闻通知"));
        mMenuEntities.add(new MenuEntity(R.drawable.btn_home6, "事故管理"));


        mGvIds.setAdapter(new CommonAdapter<MenuEntity>(getActivity(), mMenuEntities,
                R.layout.item_home_button) {
            @Override
            public void convert(MyViewHolder holder, MenuEntity menuEntity) {
                holder.setText(R.id.tv_title, menuEntity.getName())
                        .setImageResource(R.id.iv_image, menuEntity.getResId());
            }
        });


    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initDependencyInjector(MyApplication myApplication) {

    }

    @Override
    protected void initPresenter() {

    }

    @OnClick(R.id.btn_my_safe)
    void onMySafeClicked(View view) {


    }

    @OnClick(R.id.btn_auth_center)
    void onAuthCenterClicked(View view) {
        Intent intent = new Intent(getActivity(), AuthCenterActivity.class);
        startActivity(intent);
    }
}

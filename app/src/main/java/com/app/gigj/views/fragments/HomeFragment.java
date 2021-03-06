package com.app.gigj.views.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.entities.func.MenuEntity;
import com.app.gigj.utils.SPUtils;
import com.app.gigj.views.activities.NewsActivity;
import com.app.gigj.views.activities.carOwner.AccidentManaActivity;
import com.app.gigj.views.activities.carOwner.GasolineManageActivity;
import com.app.gigj.views.activities.carOwner.ServiceStateActivity;
import com.app.gigj.views.activities.shipper.AuthCenterActivity;
import com.app.gigj.views.activities.shipper.MyChitActivity;
import com.app.gigj.views.activities.shipper.OrdersActivity;
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
    GridView mGvButtons;
    @BindView(R.id.ll_top)
    LinearLayout mLlTop;

    @Override
    protected void initUI(View view) {
        initMenu();

        String role = (String) SPUtils.get(getActivity(), SPUtils.USER_ROLE, "");
        if (role.charAt(2) == '1' || role.charAt(4) == '1') {
            //车主或司机隐藏view
            mLlTop.setVisibility(View.GONE);
        }
    }

    private void initMenu() {
        ArrayList<MenuEntity> menuEntities;
        menuEntities = new ArrayList<>();
        menuEntities.add(new MenuEntity(R.drawable.btn_home1, "我的发货订单"));
        menuEntities.add(new MenuEntity(R.drawable.btn_home2, "我的配送订单"));
        menuEntities.add(new MenuEntity(R.drawable.btn_home3, "加油管理"));
        menuEntities.add(new MenuEntity(R.drawable.btn_home4, "车辆维修管理"));
        menuEntities.add(new MenuEntity(R.drawable.btn_home5, "新闻通知"));
        menuEntities.add(new MenuEntity(R.drawable.btn_home6, "事故管理"));

        CommonAdapter adapter = new CommonAdapter<MenuEntity>(getActivity(), menuEntities,
                R.layout.item_home_button, mGvButtons) {
            @Override
            public void convert(MyViewHolder holder, MenuEntity menuEntity) {
                holder.setText(R.id.tv_title, menuEntity.getName())
                        .setImageResource(R.id.iv_image, menuEntity.getResId());
            }
        };

        adapter.setOnItemClickListener((data, position) -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(getActivity(), OrdersActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(getActivity(), OrdersActivity.class);
                    intent.putExtra(OrdersActivity.ARG_TYPE, 1);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(getActivity(), GasolineManageActivity.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(getActivity(), ServiceStateActivity.class);
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(getActivity(), NewsActivity.class);
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(getActivity(), AccidentManaActivity.class);
                    startActivity(intent);
                    break;
            }
        });

        mGvButtons.setAdapter(adapter);
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
        Intent intent = new Intent(getActivity(), MyChitActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_auth_center)
    void onAuthCenterClicked(View view) {
        Intent intent = new Intent(getActivity(), AuthCenterActivity.class);
        startActivity(intent);
    }
}

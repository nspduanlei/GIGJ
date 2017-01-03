package com.app.gigj.views.fragments;

import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.entities.func.MenuEntity;
import com.app.gigj.utils.T;
import com.app.gigj.views.fragments.core.BaseFragment;
import com.app.gigj.views.widget.listView.CommonAdapter;
import com.app.gigj.views.widget.listView.MyViewHolder;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by duanlei on 2016/12/29.
 */

public class MeFragment extends BaseFragment {

    @BindView(R.id.lv_menu)
    ListView mLvMenu;

    @BindView(R.id.gv_menu)
    GridView mGvMenu;

    @Override
    protected void initUI(View view) {
        initLv();
        initGv();
    }

    private void initLv() {
        ArrayList<MenuEntity> titles = new ArrayList<>();
        titles.add(new MenuEntity(R.drawable.icon_me_lv1, "我的发货订单", 2));
        titles.add(new MenuEntity(R.drawable.icon_me_lv2, "是否上班", 3));
        titles.add(new MenuEntity(R.drawable.icon_me_lv3, "我的钱包", 1));
        titles.add(new MenuEntity(R.drawable.icon_me_lv4, "我的车队", 1));
        titles.add(new MenuEntity(R.drawable.icon_me_lv5, "我的报关", 1));
        titles.add(new MenuEntity(R.drawable.icon_me_lv6, "地址管理", 1));
        titles.add(new MenuEntity(R.drawable.icon_me_lv7, "评价查看", 1));
        titles.add(new MenuEntity(R.drawable.icon_me_lv8, "关于我们", 1));

        CommonAdapter adapter = new CommonAdapter<MenuEntity>(getActivity(),
                titles, R.layout.item_me_list, mLvMenu) {
            @Override
            public void convert(MyViewHolder holder, MenuEntity menuEntity) {
                holder.setText(R.id.tv_title, menuEntity.getName())
                        .setImageResource(R.id.iv_image, menuEntity.getResId());

                switch (menuEntity.getType()) {
                    case 1:
                        holder.setVisibility(R.id.iv_arrow, View.VISIBLE)
                                .setVisibility(R.id.switch_work, View.GONE)
                                .setVisibility(R.id.tv_hint, View.GONE);
                        break;
                    case 2:
                        holder.setVisibility(R.id.iv_arrow, View.VISIBLE)
                                .setVisibility(R.id.switch_work, View.GONE)
                                .setVisibility(R.id.tv_hint, View.VISIBLE);
                        break;
                    case 3:
                        holder.setVisibility(R.id.iv_arrow, View.GONE)
                                .setVisibility(R.id.switch_work, View.VISIBLE)
                                .setVisibility(R.id.tv_hint, View.GONE);
                        break;
                    default:
                        break;
                }
            }
        };

        adapter.setOnItemClickListener((data, position) -> {
            T.showShort(getActivity(), position+"");
        });

        mLvMenu.setAdapter(adapter);

    }

    private void initGv() {
        ArrayList<MenuEntity> titles = new ArrayList<>();
        titles.add(new MenuEntity(R.drawable.icon_me_gv1, "我的配送订单"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv2, "事故处理"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv3, "违章信息管理"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv4, "年检信息"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv5, "车贷管理"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv6, "加油管理"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv7, "车辆维修管理"));
        titles.add(new MenuEntity(R.drawable.icon_me_gv8, "我的保单"));

        CommonAdapter adapter = new CommonAdapter<MenuEntity>(getActivity(),
                titles, R.layout.item_me_button, mGvMenu) {
            @Override
            public void convert(MyViewHolder holder, MenuEntity menuEntity) {
                holder.setText(R.id.tv_title, menuEntity.getName())
                        .setImageResource(R.id.iv_image, menuEntity.getResId());

            }
        };

        adapter.setOnItemClickListener((data, position) -> {
            T.showShort(getActivity(), position+"");
        });

        mGvMenu.setAdapter(adapter);


    }



    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initDependencyInjector(MyApplication myApplication) {

    }

    @Override
    protected void initPresenter() {

    }
}

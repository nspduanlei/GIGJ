package com.app.gigj.views.fragments.shipper;

import android.view.View;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.entities.GasolineRecord;
import com.app.gigj.domin.entities.func.MenuEntity;
import com.app.gigj.views.fragments.core.BaseListFragment;
import com.app.gigj.views.widget.listView.CommonAdapter;
import com.app.gigj.views.widget.recyclerView.CommonRecyclerAdapter;
import com.app.gigj.views.widget.recyclerView.MyViewHolder;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/4.
 */

public class OrdersFragment extends BaseListFragment {
    @Override
    protected CommonRecyclerAdapter getAdapter() {
        hideHead();
        CommonRecyclerAdapter adapter = new CommonRecyclerAdapter<GasolineRecord>(getActivity(),
                R.layout.item_shipper_order,
                new ArrayList<>()) {
            @Override
            public void convert(MyViewHolder holder, GasolineRecord gasolineRecord, int position) {

                holder.setOnItemClickListener(v -> {

                });

                ArrayList<MenuEntity> menuEntities = new ArrayList<>();
                menuEntities.add(new MenuEntity(1, "新增", 1, true));
                menuEntities.add(new MenuEntity(2, "运费确认", 2, true));
                menuEntities.add(new MenuEntity(3, "用户确认", 2, true));
                menuEntities.add(new MenuEntity(4, "已收费", 2, false));
                menuEntities.add(new MenuEntity(5, "进入调度", 3, false));
                menuEntities.add(new MenuEntity(6, "完成调度", 1, false));
                menuEntities.add(new MenuEntity(7, "确认运输", 2, false));
                menuEntities.add(new MenuEntity(8, "到达起点", 2, false));
                menuEntities.add(new MenuEntity(9, "确认上货", 2, false));
                menuEntities.add(new MenuEntity(10, "到达终点", 3, false));

                holder.setGridView(R.id.gv_pro, new CommonAdapter<MenuEntity>(getActivity(),
                        menuEntities, R.layout.item_progress) {
                    @Override
                    public void convert(com.app.gigj.views.widget.listView.MyViewHolder holder,
                                        MenuEntity menuEntity) {
                        switch (menuEntity.getType()) {
                            case 1:
                                holder.setVisibility(R.id.view_white_l, View.VISIBLE);
                                holder.setVisibility(R.id.view_white_r, View.GONE);
                                break;
                            case 2:
                                holder.setVisibility(R.id.view_white_r, View.GONE);
                                holder.setVisibility(R.id.view_white_l, View.GONE);
                                break;
                            case 3:
                                holder.setVisibility(R.id.view_white_r, View.VISIBLE);
                                holder.setVisibility(R.id.view_white_l, View.GONE);
                                break;
                        }

                        holder.setText(R.id.tv_text, menuEntity.getName());

                        if (menuEntity.isSelect()) {
                            holder.setBackground(R.id.view_1, R.drawable.shape_progress_sel);
                        }
                    }
                });

            }
        };
        return adapter;
    }

    @Override
    protected void initDependencyInjector(MyApplication myApplication) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void loadFirstPage() {
        ArrayList<GasolineRecord> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new GasolineRecord());
        }

        onRefreshComplete(data);
    }

    @Override
    protected void loadOtherPage() {

    }
}

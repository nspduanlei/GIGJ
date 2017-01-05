package com.app.gigj.views.fragments.carOwner;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.entities.GasolineRecord;
import com.app.gigj.views.fragments.core.BaseListFragment;
import com.app.gigj.views.widget.recyclerView.CommonRecyclerAdapter;
import com.app.gigj.views.widget.recyclerView.MyViewHolder;

import java.util.ArrayList;

/**
 * Created by duanlei on 2017/1/5.
 */

public class LawServiceFragment extends BaseListFragment {
    @Override
    protected CommonRecyclerAdapter getAdapter() {
        CommonRecyclerAdapter adapter = new CommonRecyclerAdapter<GasolineRecord>(getActivity(),
                R.layout.item_law_service,
                new ArrayList<>()) {
            @Override
            public void convert(MyViewHolder holder, GasolineRecord gasolineRecord, int position) {

                holder.setOnItemClickListener(v -> {

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

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_list_msg_find;
    }
}

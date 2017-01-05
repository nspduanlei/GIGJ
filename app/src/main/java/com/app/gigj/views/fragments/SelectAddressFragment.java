package com.app.gigj.views.fragments;

import android.os.Bundle;

import com.app.gigj.R;
import com.app.gigj.app.MyApplication;
import com.app.gigj.domin.entities.Address;
import com.app.gigj.injector.components.DaggerUserComponent;
import com.app.gigj.injector.modules.ActivityModule;
import com.app.gigj.mvp.presenters.SelectAddressPresenter;
import com.app.gigj.mvp.views.SelectAddressView;
import com.app.gigj.utils.T;
import com.app.gigj.views.fragments.core.BaseListFragment;
import com.app.gigj.views.widget.recyclerView.CommonRecyclerAdapter;
import com.app.gigj.views.widget.recyclerView.MyViewHolder;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by duanlei on 17/1/1.
 */

public class SelectAddressFragment extends BaseListFragment implements SelectAddressView {

    @Inject
    SelectAddressPresenter mSelectAddressPresenter;

    public static final String ARG_TYPE = "arg_type";

    public static SelectAddressFragment newInstance(int type) {
        SelectAddressFragment newFragment = new SelectAddressFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_TYPE, type);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    protected CommonRecyclerAdapter getAdapter() {
        setIsRefresh(false);
        CommonRecyclerAdapter adapter = new CommonRecyclerAdapter<Address>(getActivity(),
                R.layout.item_text_list,
                new ArrayList<>()) {
            @Override
            public void convert(MyViewHolder holder, Address address, int position) {

                holder.setText(R.id.tv_title, address.getSHENG())
                        .setOnItemClickListener(v -> {

                        });

            }
        };
        return adapter;
    }

    @Override
    protected void initDependencyInjector(MyApplication myApplication) {
        DaggerUserComponent.builder()
                .activityModule(new ActivityModule(getActivity()))
                .appComponent(myApplication.getAppComponent())
                .build().inject(this);
    }

    @Override
    protected void initPresenter() {
        mSelectAddressPresenter.attachView(this);
        mSelectAddressPresenter.onCreate();
    }

    @Override
    protected void loadFirstPage() {
        mSelectAddressPresenter.refresh();
    }

    @Override
    protected void loadOtherPage() {
        mSelectAddressPresenter.loadMore();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_list;
    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    public void onLoadMoreSuccess(ArrayList data) {
        onLoadMoreComplete(data);
    }

    @Override
    public void onRefreshSuccess(ArrayList data) {
        if (data.size() == 0) {
            setEmptyText(getString(R.string.list_empty));
            showEmpty();
        } else {
            hideEmpty();
        }
        onRefreshComplete(data);
    }

    @Override
    public void onNoMore() {
        T.showShort(getActivity(), "没有更多数据");
        onDataEnd();
    }

    @Override
    public void onError(String errorCode, String errorMsg) {
        onLoadError();
    }

    public void update(int type) {
//        if (filterCustomBean != null) {
//            mCustomListPresenter.setFilter(filterCustomBean);
//        }
        initiateRefresh();
    }
}

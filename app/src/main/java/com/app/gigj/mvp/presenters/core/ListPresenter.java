package com.app.gigj.mvp.presenters.core;

/**
 * Created by duanlei on 17/1/1.
 */


public abstract class ListPresenter {

    //每页显示数量
    protected static final String LIST_ITEM_COUNT = "20";

    //总数量
    protected int totalNumber = 0;

    //总页数
    protected int totalPage = 10;

    //当前页
    protected int mCurrentPage = 0;

    public void refresh() {
        mCurrentPage = 0;
        doRefresh();
    }

    public void loadMore() {
        mCurrentPage++;
        if (mCurrentPage > totalPage) {
            onNoMore();
            return;
        }
        doLoadMore();
    }

    protected abstract void doRefresh();

    protected abstract void doLoadMore();

    protected abstract void onNoMore();

}


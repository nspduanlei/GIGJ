package com.app.gigj.mvp.presenters;

import com.app.gigj.domin.model.response.appselect.AppSelectResponseEnvelope;
import com.app.gigj.domin.usecase.AppSelectUseCase;
import com.app.gigj.mvp.presenters.core.ListPresenter;
import com.app.gigj.mvp.presenters.core.Presenter;
import com.app.gigj.mvp.views.SelectAddressView;
import com.app.gigj.mvp.views.core.View;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by duanlei on 16/12/31.
 */
public class SelectAddressPresenter extends ListPresenter implements Presenter {

    AppSelectUseCase mGetAreaUserCase;
    SelectAddressView mSelectAddressView;

    Gson mGson;

    @Inject
    public SelectAddressPresenter(AppSelectUseCase appSelectUseCase,
                                  @Named("gson") Gson gson) {
        mGetAreaUserCase = appSelectUseCase;
        mGson = gson;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void attachView(View v) {
        mSelectAddressView = (SelectAddressView) v;
    }

    @Override
    public void onCreate() {

    }

    private void manageError(Throwable throwable) {
        mSelectAddressView.hideLoadingView();
        mSelectAddressView.onError("0", "");
    }

    @Override
    protected void doRefresh() {
        //mGetAreaUserCase.setData(mCurrentPage);
        mGetAreaUserCase.execute().subscribe(this::onRefreshReceived, this::manageError);
    }

    private void onLoadMoreReceived(AppSelectResponseEnvelope responseEnvelope) {

//        String json = responseEnvelope.getBody().getGetAreaResponse().getGetConnectionResult();
//        Type type = new TypeToken<ResultList<Address>>(){}.getType();
//        ResultList<Address> resultList = mGson.fromJson(json, type);
//
//        if (resultList.getState().equals("true")) {
//            mSelectAddressView.onLoadMoreSuccess(resultList.getRow01());
//        } else {
//            mSelectAddressView.onError(resultList.getError(),
//                    "");
//        }
    }

    @Override
    protected void doLoadMore() {
        //mGetAreaUserCase.setData(mCurrentPage);
        mGetAreaUserCase.execute().subscribe(this::onLoadMoreReceived, this::manageError);
    }

    private void onRefreshReceived(AppSelectResponseEnvelope responseEnvelope) {

//        String json = responseEnvelope.getBody().getGetAreaResponse().getGetConnectionResult();
//        Type type = new TypeToken<ResultList<Address>>(){}.getType();
//        ResultList<Address> resultList = mGson.fromJson(json, type);
//
//        if (resultList.getState().equals("true")) {
//            //totalPage = listPageResult.getData().getPageCount();
//            //totalNumber = listPageResult.getData().getTotalElements();
//            mSelectAddressView.onRefreshSuccess(resultList.getRow01());
//        } else {
//            mSelectAddressView.onError(resultList.getError(),
//                    "");
//        }
    }

    @Override
    protected void onNoMore() {
        mSelectAddressView.onNoMore();
    }
}

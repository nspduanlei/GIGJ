package com.app.gigj.domin.usecase;


import com.app.gigj.config.Constants;
import com.app.gigj.domin.model.request.GetArea;
import com.app.gigj.domin.model.request.GetAreaRequestBody;
import com.app.gigj.domin.model.request.core.RequestEnvelope;
import com.app.gigj.domin.model.response.appselect.AppSelectResponseEnvelope;
import com.app.gigj.domin.repository.Repository;
import com.app.gigj.domin.usecase.core.UseCase;
import com.app.gigj.utils.MD5Util;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by duanlei on 2016/5/16.
 * 查询
 */
public class AppSelectUseCase extends UseCase<AppSelectResponseEnvelope> {

    private final Repository mRepository;
    private final Scheduler mUiThread;
    private final Scheduler mExecutorThread;
    private RequestEnvelope mRequestEnvelope;

    @Inject
    public AppSelectUseCase(Repository repository,
                            @Named("ui_thread") Scheduler uiThread,
                            @Named("executor_thread") Scheduler executorThread,
                            RequestEnvelope requestEnvelope) {
        mRepository = repository;
        mUiThread = uiThread;
        mExecutorThread = executorThread;
        mRequestEnvelope = requestEnvelope;
    }

    public void setProvinceData() {
        setData("{busiid:\"10100110\",userid:\"" + Constants.USER_ID +
                "\",opens:\"APP\",pages:\"0\",rows:\"0\",sqlcnt:\"1\",xml01:[{CXTJ:\"1=1\"}]}");
    }

    public void setCityData(String provinceName) {
        setData("{busiid:\"10100111\",userid:\"" + Constants.USER_ID +
                "\",opens:\"APP\",pages:\"0\",rows:\"0\",sqlcnt:\"1\",xml01:[{KYBZ:\"0\",SHENG:\""
                + provinceName + "\"}]}");
    }

    public void setCompanyData() {
        setData("{busiid:\"10100032\",userid:\"" + Constants.USER_ID +
                "\",opens:\"APP\",pages:\"0\",rows:\"0\",sqlcnt:\"1\",xml01:[{CXTJ:\"1=1\"}]}");
    }

    /**
     * 添加地址获取行政区域， 省
     */
    public void setAddProData(String userId, String password) {
        setData("{busiid:\"10100052\",userid:\"" + userId +
                "\",opens:\"APP\",pages:\"0\",rows:\"0\",sqlcnt:\"1\",xml01:[{KYBZ:\"0\"}]}",
                password);
    }

    private void setData(String jsonData, String password) {
        GetAreaRequestBody requestBody = new GetAreaRequestBody();
        GetArea baseRequest = new GetArea();

        baseRequest.setUserIdMd5(MD5Util.getMd5UserId(Constants.USER_ID));
        baseRequest.setPasswordMd5(password);
        baseRequest.setUserId(Constants.USER_ID);
        baseRequest.setJsonData(jsonData);

        requestBody.setGetArea(baseRequest);
        mRequestEnvelope.setBody(requestBody);
    }

    private void setData(String jsonData) {
        GetAreaRequestBody requestBody = new GetAreaRequestBody();
        GetArea baseRequest = new GetArea();

        baseRequest.setUserIdMd5(MD5Util.getMd5UserId(Constants.USER_ID));
        baseRequest.setPasswordMd5(MD5Util.getMd5Password(Constants.PASSWORD));
        baseRequest.setUserId(Constants.USER_ID);
        baseRequest.setJsonData(jsonData);

        requestBody.setGetArea(baseRequest);
        mRequestEnvelope.setBody(requestBody);
    }

    @Override
    public Observable<AppSelectResponseEnvelope> buildObservable() {
        return mRepository.appSelect(mRequestEnvelope)
                .observeOn(mUiThread)
                .subscribeOn(mExecutorThread);
    }
}

package com.app.gigj.domin.usecase;


import com.app.gigj.domin.model.request.AddAddress;
import com.app.gigj.domin.model.request.AddAddressRequestBody;
import com.app.gigj.domin.model.request.core.RequestEnvelope;
import com.app.gigj.domin.model.response.login.LoginResponseEnvelope;
import com.app.gigj.domin.repository.Repository;
import com.app.gigj.domin.usecase.core.UseCase;
import com.app.gigj.utils.MD5Util;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by duanlei on 2016/5/16.
 * 添加常用地址
 */
public class AddAddressUseCase extends UseCase<LoginResponseEnvelope> {

    private final Repository mRepository;
    private final Scheduler mUiThread;
    private final Scheduler mExecutorThread;
    private RequestEnvelope mRequestEnvelope;

    @Inject
    public AddAddressUseCase(Repository repository,
                             @Named("ui_thread") Scheduler uiThread,
                             @Named("executor_thread") Scheduler executorThread,
                             RequestEnvelope requestEnvelope) {
        mRepository = repository;
        mUiThread = uiThread;
        mExecutorThread = executorThread;
        mRequestEnvelope = requestEnvelope;
    }

    /**
     * @param areaId 区id
     * @param detail 详细地址
     */
    public void setAddData(String areaId, String detail, String userId, String password) {
        setData(areaId, detail, userId, password);
    }

    private void setData(String areaId, String detail, String userId, String password) {
        AddAddressRequestBody requestBody = new AddAddressRequestBody();
        AddAddress addAddress = new AddAddress();

        addAddress.setArg0(MD5Util.getMd5UserId(userId));
        addAddress.setArg1("102");
        addAddress.setArg2(userId);
        addAddress.setArg3(password);
        addAddress.setArg4("APPCLIENT");
        addAddress.setArg5("his_center");
        addAddress.setArg6("20100080");
        addAddress.setArg7("1");
        addAddress.setArg8("{\"arg1\":\"\",\"arg2\":\"\",\"arg3\":\"\",\"arg4\":\"\",\"arg5\":\"\",\"arg6\":\"\"," +
                "\"xml1\":[{YHID:\"" + userId + "\",QHID:\"" + areaId + "\",XXDZ:\"" + detail + "\",\"XPOS\":\"0.0\",\"YPOS\":\"0.0\"}]}");

        requestBody.setAddAddress(addAddress);
        mRequestEnvelope.setBody(requestBody);
    }

    @Override
    public Observable<LoginResponseEnvelope> buildObservable() {
        return mRepository.login(mRequestEnvelope)
                .observeOn(mUiThread)
                .subscribeOn(mExecutorThread);
    }
}

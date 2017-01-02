package com.app.gigj.domin.usecase;


import com.app.gigj.domin.model.request.core.RequestEnvelope;
import com.app.gigj.domin.model.request.SendCode;
import com.app.gigj.domin.model.request.SendCodeRequestBody;
import com.app.gigj.domin.model.response.sendver.SendCodeResponseEnvelope;
import com.app.gigj.domin.repository.Repository;
import com.app.gigj.domin.usecase.core.UseCase;
import com.app.gigj.utils.MD5Util;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by duanlei on 2016/5/16.
 * 发送验证码
 */
public class SendCodeUseCase extends UseCase<SendCodeResponseEnvelope> {

    private final Repository mRepository;
    private final Scheduler mUiThread;
    private final Scheduler mExecutorThread;
    private RequestEnvelope mRequestEnvelope;

    @Inject
    public SendCodeUseCase(Repository repository,
                           @Named("ui_thread") Scheduler uiThread,
                           @Named("executor_thread") Scheduler executorThread,
                           RequestEnvelope requestEnvelope) {
        mRepository = repository;
        mUiThread = uiThread;
        mExecutorThread = executorThread;
        mRequestEnvelope = requestEnvelope;
    }

    public void setSendCodeData(String phone) {
        setData(phone);
    }

    private void setData(String phone) {
        SendCodeRequestBody requestBody = new SendCodeRequestBody();
        SendCode sendCode = new SendCode();

        sendCode.setPhoneVer(MD5Util.getMd5UserId(phone));
        sendCode.setPhone(phone);

        requestBody.setSendCode(sendCode);
        mRequestEnvelope.setBody(requestBody);
    }

    @Override
    public Observable<SendCodeResponseEnvelope> buildObservable() {
        return mRepository.sendCode(mRequestEnvelope)
                .observeOn(mUiThread)
                .subscribeOn(mExecutorThread);
    }
}

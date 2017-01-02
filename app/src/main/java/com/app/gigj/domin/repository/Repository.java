package com.app.gigj.domin.repository;


import com.app.gigj.domin.model.request.core.RequestEnvelope;
import com.app.gigj.domin.model.response.login.LoginResponseEnvelope;
import com.app.gigj.domin.model.response.appselect.AppSelectResponseEnvelope;
import com.app.gigj.domin.model.response.sendver.SendCodeResponseEnvelope;

import rx.Observable;

/**
 * Created by duanlei on 2016/5/10.
 */
public interface Repository {
    Observable<AppSelectResponseEnvelope> appSelect(RequestEnvelope requestEnvelope);

    Observable<SendCodeResponseEnvelope> sendCode(RequestEnvelope requestEnvelope);

    Observable<LoginResponseEnvelope> login(RequestEnvelope requestEnvelope);

}
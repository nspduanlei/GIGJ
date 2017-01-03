package com.app.gigj.support.wsdl;

import com.app.gigj.domin.model.request.core.RequestEnvelope;
import com.app.gigj.domin.model.response.login.LoginResponseEnvelope;
import com.app.gigj.domin.model.response.appselect.AppSelectResponseEnvelope;
import com.app.gigj.domin.model.response.sendver.SendCodeResponseEnvelope;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by duanlei on 16/12/31.
 */

public interface GIGJApi {

    //@Headers({"SOAPAction: appselect"})
    @POST("AppWs?wsdl")
    Observable<AppSelectResponseEnvelope> appselect(@Body RequestEnvelope request_envelope);

    @POST("AppWs?wsdl")
    Observable<SendCodeResponseEnvelope> sendVerifacation(@Body RequestEnvelope request_envelope);

    @POST("AppWs?wsdl")
    Observable<LoginResponseEnvelope> login(@Body RequestEnvelope request_envelope);

}

package com.app.gigj.domin.model.request;

import com.app.gigj.domin.model.request.core.RequestBody;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by duanlei on 2016/12/30.
 */

@Root(name = "soapenv:Body", strict = false)
public class SendCodeRequestBody extends RequestBody {
    @Element(name = "ihis:SendVerification", required = false)
    private  SendCode sendCode;

    public SendCode getSendCode() {
        return sendCode;
    }

    public void setSendCode(SendCode sendCode) {
        this.sendCode = sendCode;
    }
}
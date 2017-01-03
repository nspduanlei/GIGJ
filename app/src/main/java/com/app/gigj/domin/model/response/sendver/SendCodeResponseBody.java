package com.app.gigj.domin.model.response.sendver;

import com.app.gigj.domin.model.response.login.LoginResponse;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by duanlei on 2016/12/30.
 */

//// AppSelectResponseBody
@NamespaceList(
        @Namespace(reference = "http://ihis.pub.app", prefix = "ns1")
)
@Root(name = "Body")
public class SendCodeResponseBody {

    @Element(name = "SendVerificationResponse", required = false)
    private LoginResponse response;

    public LoginResponse getResponse() {
        return response;
    }

    public void setResponse(LoginResponse response) {
        this.response = response;
    }
}
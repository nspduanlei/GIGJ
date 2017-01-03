package com.app.gigj.domin.model.response.login;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by duanlei on 2016/12/30.
 */

// Envelope
@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/encoding/", prefix = "enc"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soapenv")
//        @Namespace(reference = "http://schemas.xmlsoap.org/wsdl/soap/", prefix = "soap")
})
public class LoginResponseEnvelope {
    @Element(name = "Body")
    private LoginResponseBody body;

    public LoginResponseBody getBody() {
        return body;
    }

    public void setBody(LoginResponseBody body) {
        this.body = body;
    }
}
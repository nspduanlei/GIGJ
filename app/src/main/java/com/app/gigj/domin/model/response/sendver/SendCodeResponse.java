package com.app.gigj.domin.model.response.sendver;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by duanlei on 2016/12/30.
 */
@Root(name = "SendVerificationResponse")
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/encoding/", prefix = "enc"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope", prefix = "env"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/encoding/", prefix = "encodingStyle"),
})
public class SendCodeResponse {
    @Element(name = "return")
    private String getConnectionResult;

    // getter and setter...


    public String getGetConnectionResult() {
        return getConnectionResult;
    }

    public void setGetConnectionResult(String getConnectionResult) {
        this.getConnectionResult = getConnectionResult;
    }
}
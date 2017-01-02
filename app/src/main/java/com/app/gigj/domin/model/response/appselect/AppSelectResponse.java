package com.app.gigj.domin.model.response.appselect;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by duanlei on 2016/12/30.
 */
@Root(name = "appselectResponse")
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/encoding/", prefix = "enc"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope", prefix = "env"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/encoding/", prefix = "encodingStyle"),
})
public class AppSelectResponse {
    @Element(name = "return")
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
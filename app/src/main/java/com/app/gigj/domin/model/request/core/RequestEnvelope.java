package com.app.gigj.domin.model.request.core;

import com.app.gigj.domin.model.request.GetAreaRequestBody;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;


/**
 * Created by duanlei on 2016/12/30.
 */
@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/encoding/", prefix = "enc"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soapenv"),
        @Namespace(reference = "http://ihis.pub.app", prefix = "ihis")
})
public class RequestEnvelope {
    @Element(name = "soapenv:Body", required = false)
    private RequestBody body;

    @Element(name = "soapenv:Header", required = false)
    private RequestHead header;

    public RequestBody getBody() {
        return body;
    }

    public void setBody(RequestBody body) {
        this.body = body;
    }

    public RequestHead getHeader() {
        return header;
    }

    public void setHeader(RequestHead header) {
        this.header = header;
    }
}


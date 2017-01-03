package com.app.gigj.domin.model.response.appselect;

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
public class AppSelectResponseBody {

    @Element(name = "appselectResponse", required = false)
    private AppSelectResponse response;

    public AppSelectResponse getResponse() {
        return response;
    }

    public void setResponse(AppSelectResponse response) {
        this.response = response;
    }
}
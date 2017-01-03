package com.app.gigj.domin.model.request;

import com.app.gigj.domin.model.request.core.RequestBody;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by duanlei on 2016/12/30.
 */

@Root(name = "soapenv:Body", strict = false)
public class GetAreaRequestBody extends RequestBody {
    @Element(name = "ihis:appselect", required = false)
    private GetArea getArea;

    public GetArea getGetArea() {
        return getArea;
    }

    public void setGetArea(GetArea getArea) {
        this.getArea = getArea;
    }

}
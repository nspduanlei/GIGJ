package com.app.gigj.domin.model.request;

import com.app.gigj.domin.model.request.core.RequestBody;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by duanlei on 2016/12/30.
 */

@Root(name = "soapenv:Body", strict = false)
public class AddAddressRequestBody extends RequestBody {
    @Element(name = "ihis:busijson", required = false)
    private AddAddress mAddAddress;

    public AddAddress getAddAddress() {
        return mAddAddress;
    }

    public void setAddAddress(AddAddress addAddress) {
        mAddAddress = addAddress;
    }
}
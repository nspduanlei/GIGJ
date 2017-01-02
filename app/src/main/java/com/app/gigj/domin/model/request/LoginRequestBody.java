package com.app.gigj.domin.model.request;

import com.app.gigj.domin.model.request.core.RequestBody;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by duanlei on 2016/12/30.
 */

@Root(name = "soapenv:Body", strict = false)
public class LoginRequestBody extends RequestBody {
    @Element(name = "ihis:applogin", required = false)
    private  Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
package com.app.gigj.domin.model.request;

import org.simpleframework.xml.Element;

/**
 * Created by duanlei on 2016/12/30.
 */

public class Login {

    @Element(name = "arg0")
    private String phoneVer;
    @Element(name = "arg1")
    private String phone;
    @Element(name = "arg2")
    private String passwordMd5;

    @Element(name = "arg3")
    private String app;

    public String getPhoneVer() {
        return phoneVer;
    }

    public void setPhoneVer(String phoneVer) {
        this.phoneVer = phoneVer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
}
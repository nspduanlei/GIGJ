package com.app.gigj.domin.model.request;

import org.simpleframework.xml.Element;

/**
 * Created by duanlei on 2016/12/30.
 */

public class SendCode {

    @Element(name = "arg0")
    private String phoneVer;
    @Element(name = "arg1")
    private String phone;


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
}
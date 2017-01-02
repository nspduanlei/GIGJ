package com.app.gigj.domin.model.request;

import org.simpleframework.xml.Element;

/**
 * Created by duanlei on 2016/12/30.
 */

public class GetArea {

    @Element(name = "arg0")
    private String userIdMd5;
    @Element(name = "arg1")
    private String userId;
    @Element(name = "arg2")
    private String passwordMd5;

    @Element(name = "arg3")
    private String jsonData;


    // getters and setters...


    public String getUserIdMd5() {
        return userIdMd5;
    }

    public void setUserIdMd5(String userIdMd5) {
        this.userIdMd5 = userIdMd5;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
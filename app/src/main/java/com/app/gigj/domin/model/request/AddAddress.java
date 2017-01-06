package com.app.gigj.domin.model.request;

import org.simpleframework.xml.Element;

/**
 * Created by duanlei on 2016/12/30.
 */

public class AddAddress {

//    <arg0>a93d71004c18504a（用户ID：登陆之后的返回的A01+($_$)Glgj($_$)的MD5）</arg0>
//    <arg1>固定值：102</arg1>
//    <arg2>用户ID，如：10000009</arg2>
//    <arg3>（密码+ $$ht_zx$$进行MD5）</arg3>
//    <arg4>固定值：APPCLIENT </arg4>
//    <arg5>固定值：his_center</arg5>
//    <arg6>固定值：20100080</arg6>
//    <arg7>固定值：1</arg7>
//    <arg8>{"arg1":"","arg2":””,"arg3":"","arg4":"","arg5":"","arg6":"","xml1":[{YHID:”用户ID”,QHID:"区划ID",XXDZ: "详细地址"}]}</arg8>

    @Element(name = "arg0")
    private String arg0;
    @Element(name = "arg1")
    private String arg1;
    @Element(name = "arg2")
    private String arg2;

    @Element(name = "arg3")
    private String arg3;

    @Element(name = "arg4")
    private String arg4;

    @Element(name = "arg5")
    private String arg5;

    @Element(name = "arg6")
    private String arg6;

    @Element(name = "arg7")
    private String arg7;

    @Element(name = "arg8")
    private String arg8;

    public String getArg0() {
        return arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public String getArg4() {
        return arg4;
    }

    public void setArg4(String arg4) {
        this.arg4 = arg4;
    }

    public String getArg5() {
        return arg5;
    }

    public void setArg5(String arg5) {
        this.arg5 = arg5;
    }

    public String getArg6() {
        return arg6;
    }

    public void setArg6(String arg6) {
        this.arg6 = arg6;
    }

    public String getArg7() {
        return arg7;
    }

    public void setArg7(String arg7) {
        this.arg7 = arg7;
    }

    public String getArg8() {
        return arg8;
    }

    public void setArg8(String arg8) {
        this.arg8 = arg8;
    }
}
package com.app.gigj.domin.entities;

/**
 * Created by duanlei on 17/1/2.
 */

public class User {

    /**
     * state : true
     * A01 : 10000009
     * A02 : 我不是黑客
     * A03 : $$ht_zx$$
     * A04 : http: //www.glgj.com.cn: 801/uassets/147910253771006.jpg
     * A05 : 1111110000
     * A06 : 10001
     */

    private String state;
    private String error;
    private String A01;
    private String A02;
    private String A03;
    private String A04;
    private String A05;
    private String A06;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getA01() {
        return A01;
    }

    public void setA01(String A01) {
        this.A01 = A01;
    }

    public String getA02() {
        return A02;
    }

    public void setA02(String A02) {
        this.A02 = A02;
    }

    public String getA03() {
        return A03;
    }

    public void setA03(String A03) {
        this.A03 = A03;
    }

    public String getA04() {
        return A04;
    }

    public void setA04(String A04) {
        this.A04 = A04;
    }

    public String getA05() {
        return A05;
    }

    public void setA05(String A05) {
        this.A05 = A05;
    }

    public String getA06() {
        return A06;
    }

    public void setA06(String A06) {
        this.A06 = A06;
    }
}

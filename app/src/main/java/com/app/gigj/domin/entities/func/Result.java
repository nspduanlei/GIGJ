package com.app.gigj.domin.entities.func;

/**
 * Created by duanlei on 17/1/1.
 */
public class Result<T> {

    private String state;
    private String error;
    private int rowcount;
    private T row01;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getRowcount() {
        return rowcount;
    }

    public void setRowcount(int rowcount) {
        this.rowcount = rowcount;
    }

    public T getRow01() {
        return row01;
    }

    public void setRow01(T row01) {
        this.row01 = row01;
    }
}

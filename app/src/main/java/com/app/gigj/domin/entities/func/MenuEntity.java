package com.app.gigj.domin.entities.func;

/**
 * Created by duanlei on 16/9/13.
 */
public class MenuEntity {
    private int resId;
    private String name;
    private int type;
    private boolean isSelect;

    public MenuEntity(int resId, String name) {
        this.resId = resId;
        this.name = name;
    }

    public MenuEntity(int resId, String name, int type) {
        this.type = type;
        this.resId = resId;
        this.name = name;
    }

    public MenuEntity(int resId, String name, int type, boolean isSelect) {
        this.type = type;
        this.resId = resId;
        this.name = name;
        this.isSelect = isSelect;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}

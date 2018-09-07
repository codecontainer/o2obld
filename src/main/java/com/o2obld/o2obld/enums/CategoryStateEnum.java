package com.o2obld.o2obld.enums;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 白色馒头
 * Date: 2018-09-07
 * Time: 22:35
 */
public enum CategoryStateEnum {
    OFFLINE(-1, "非法分类"), SUCCESS(0, "操作成功"), INNER_ERROR(-1001, "操作失败");

    CategoryStateEnum(int state, String stateinfo) {
        this.state = state;
        this.stateinfo = stateinfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private int state;
    private String stateinfo;

    public String getStateinfo() {
        return stateinfo;
    }

    public void setStateinfo(String stateinfo) {
        this.stateinfo = stateinfo;
    }

    public static CategoryStateEnum stateOf(int index) {
        for (CategoryStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}

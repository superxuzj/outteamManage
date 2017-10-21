package com.boliangshenghe.outteam.entity;

public class Yearm {
    private Integer id;

    private String yearm;

    private String state;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYearm() {
        return yearm;
    }

    public void setYearm(String yearm) {
        this.yearm = yearm == null ? null : yearm.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
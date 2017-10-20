package com.boliangshenghe.outteam.entity;

import java.util.Date;

public class Onduty {
    private Integer id;

    private String yearm;

    private Integer cid;

    private String company;

    private String state;

    private Date createtime;

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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
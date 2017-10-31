package com.boliangshenghe.outteam.entity;

public class Phone {
    private Integer id;

    private Integer userid;

    private String username;

    private Integer cid;

    private String company;

    private String phoneone;

    private String phonetwo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public String getPhoneone() {
        return phoneone;
    }

    public void setPhoneone(String phoneone) {
        this.phoneone = phoneone == null ? null : phoneone.trim();
    }

    public String getPhonetwo() {
        return phonetwo;
    }

    public void setPhonetwo(String phonetwo) {
        this.phonetwo = phonetwo == null ? null : phonetwo.trim();
    }
}
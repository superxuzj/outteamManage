package com.boliangshenghe.outteam.entity;

import java.util.Date;

public class OutteamDetail {
    private Integer id;

    private Integer userid;

    private String name;

    private String phone;

    private String iscontact;

    private String ismeet;

    private String idlead;

    private Integer fid;

    private Integer eqid;

    private String eqname;

    private String duty;

    private Integer otid;

    private Date createtime;

    private Date endtime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIscontact() {
        return iscontact;
    }

    public void setIscontact(String iscontact) {
        this.iscontact = iscontact == null ? null : iscontact.trim();
    }

    public String getIsmeet() {
        return ismeet;
    }

    public void setIsmeet(String ismeet) {
        this.ismeet = ismeet == null ? null : ismeet.trim();
    }

    public String getIdlead() {
        return idlead;
    }

    public void setIdlead(String idlead) {
        this.idlead = idlead == null ? null : idlead.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getEqid() {
        return eqid;
    }

    public void setEqid(Integer eqid) {
        this.eqid = eqid;
    }

    public String getEqname() {
        return eqname;
    }

    public void setEqname(String eqname) {
        this.eqname = eqname == null ? null : eqname.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public Integer getOtid() {
        return otid;
    }

    public void setOtid(Integer otid) {
        this.otid = otid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
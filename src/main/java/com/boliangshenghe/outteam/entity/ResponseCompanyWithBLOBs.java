package com.boliangshenghe.outteam.entity;

public class ResponseCompanyWithBLOBs extends ResponseCompany {
    private byte[] rname;

    private byte[] company;

    private byte[] duty;

    private byte[] state;

    public byte[] getRname() {
        return rname;
    }

    public void setRname(byte[] rname) {
        this.rname = rname;
    }

    public byte[] getCompany() {
        return company;
    }

    public void setCompany(byte[] company) {
        this.company = company;
    }

    public byte[] getDuty() {
        return duty;
    }

    public void setDuty(byte[] duty) {
        this.duty = duty;
    }

    public byte[] getState() {
        return state;
    }

    public void setState(byte[] state) {
        this.state = state;
    }
}
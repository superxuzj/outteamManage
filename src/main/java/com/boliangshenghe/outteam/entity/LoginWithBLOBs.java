package com.boliangshenghe.outteam.entity;

public class LoginWithBLOBs extends Login {
    private byte[] username;

    private byte[] ip;

    public byte[] getUsername() {
        return username;
    }

    public void setUsername(byte[] username) {
        this.username = username;
    }

    public byte[] getIp() {
        return ip;
    }

    public void setIp(byte[] ip) {
        this.ip = ip;
    }
}
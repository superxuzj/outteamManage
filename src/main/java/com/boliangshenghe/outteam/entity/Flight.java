package com.boliangshenghe.outteam.entity;

import java.util.Date;

public class Flight {
    private Integer id;

    private String flight;

    private String depcity;

    private String arrcity;

    private String depterminal;

    private String arrterminal;

    private String depscheduled;

    private String arrscheduled;

    private String depactual;

    private String arractual;

    private Date depdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight == null ? null : flight.trim();
    }

    public String getDepcity() {
        return depcity;
    }

    public void setDepcity(String depcity) {
        this.depcity = depcity == null ? null : depcity.trim();
    }

    public String getArrcity() {
        return arrcity;
    }

    public void setArrcity(String arrcity) {
        this.arrcity = arrcity == null ? null : arrcity.trim();
    }

    public String getDepterminal() {
        return depterminal;
    }

    public void setDepterminal(String depterminal) {
        this.depterminal = depterminal == null ? null : depterminal.trim();
    }

    public String getArrterminal() {
        return arrterminal;
    }

    public void setArrterminal(String arrterminal) {
        this.arrterminal = arrterminal == null ? null : arrterminal.trim();
    }

    public String getDepscheduled() {
        return depscheduled;
    }

    public void setDepscheduled(String depscheduled) {
        this.depscheduled = depscheduled == null ? null : depscheduled.trim();
    }

    public String getArrscheduled() {
        return arrscheduled;
    }

    public void setArrscheduled(String arrscheduled) {
        this.arrscheduled = arrscheduled == null ? null : arrscheduled.trim();
    }

    public String getDepactual() {
        return depactual;
    }

    public void setDepactual(String depactual) {
        this.depactual = depactual == null ? null : depactual.trim();
    }

    public String getArractual() {
        return arractual;
    }

    public void setArractual(String arractual) {
        this.arractual = arractual == null ? null : arractual.trim();
    }

    public Date getDepdate() {
        return depdate;
    }

    public void setDepdate(Date depdate) {
        this.depdate = depdate;
    }
}
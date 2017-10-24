package com.boliangshenghe.outteam.entity;


public class Flight {
    private Integer id;

    private String flight;

    private String depcity;//出发城市

    private String arrcity;//到达城市
    
    private String arrport;//到达机场名称

    private String depport;//出发机场名称

    private String depterminal;//出发航站楼

    private String arrterminal;//到达航站楼

    private String depscheduled;//计划出发时间

    private String arrscheduled;//计划到达时间

    private String depactual;//实际出发时间

    private String arractual;//实际到达时间

	private String flightstate; //航班状态

    private String depdate;//出发日期
    
    public String getFlightstate() {
		return flightstate;
	}

	public void setFlightstate(String flightstate) {
		this.flightstate = flightstate;
	}

	public String getDepdate() {
		return depdate;
	}

	public void setDepdate(String depdate) {
		this.depdate = depdate;
	}

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

	public String getArrport() {
		return arrport;
	}

	public void setArrport(String arrport) {
		this.arrport = arrport;
	}

	public String getDepport() {
		return depport;
	}

	public void setDepport(String depport) {
		this.depport = depport;
	}

}
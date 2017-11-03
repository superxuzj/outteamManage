package com.boliangshenghe.outteam.entity;

import java.util.Date;

public class Leave {
    private Integer id;

    private Integer cid;

    private String company;

    private Integer fid;

    private Integer eqid;

    private String eqname;

    private Integer otid;

    private String state;

    private Date createtime;

    private String remark;
    
    private Integer start;
    
    private Integer limit;
    
    
  //航班信息
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getOtid() {
        return otid;
    }

    public void setOtid(Integer otid) {
        this.otid = otid;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getDepcity() {
		return depcity;
	}

	public void setDepcity(String depcity) {
		this.depcity = depcity;
	}

	public String getArrcity() {
		return arrcity;
	}

	public void setArrcity(String arrcity) {
		this.arrcity = arrcity;
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

	public String getDepterminal() {
		return depterminal;
	}

	public void setDepterminal(String depterminal) {
		this.depterminal = depterminal;
	}

	public String getArrterminal() {
		return arrterminal;
	}

	public void setArrterminal(String arrterminal) {
		this.arrterminal = arrterminal;
	}

	public String getDepscheduled() {
		return depscheduled;
	}

	public void setDepscheduled(String depscheduled) {
		this.depscheduled = depscheduled;
	}

	public String getArrscheduled() {
		return arrscheduled;
	}

	public void setArrscheduled(String arrscheduled) {
		this.arrscheduled = arrscheduled;
	}

	public String getDepactual() {
		return depactual;
	}

	public void setDepactual(String depactual) {
		this.depactual = depactual;
	}

	public String getArractual() {
		return arractual;
	}

	public void setArractual(String arractual) {
		this.arractual = arractual;
	}

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
}
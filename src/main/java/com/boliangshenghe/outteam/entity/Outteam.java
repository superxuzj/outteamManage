package com.boliangshenghe.outteam.entity;

import java.util.Date;

public class Outteam {
    private Integer id;

    private Integer eqid;

    private String eqname;

    private Integer cid;

    private String company;

    private String outtype;//1 震源省份 2 响应等级 3 轮值 4 自己申请

    private String state;//状态 1 通知 2 出队 3撤退申请 4撤退同意  5结束  写总结

    private Integer count;

    private Integer fid;
    
    private String flight;
    
    private Integer lid;

    private String duty;

    private String summary;
    
    private String hit;

    private String creator;

    private Date createtime;

    private String operator;

    private Date operatetime;
    
    private String chooses;
    
    private String contacts;
    
    private String leaders;

    private Integer start;
    
    private Integer limit;
    
    Integer [] eqids;
    
    //航班信息
    

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

	public String getDepterminal() {
		return depterminal;
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getOuttype() {
        return outtype;
    }

    public void setOuttype(String outtype) {
        this.outtype = outtype == null ? null : outtype.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getChooses() {
		return chooses;
	}

	public void setChooses(String chooses) {
		this.chooses = chooses;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getLeaders() {
		return leaders;
	}

	public void setLeaders(String leaders) {
		this.leaders = leaders;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public Integer[] getEqids() {
		return eqids;
	}

	public void setEqids(Integer[] eqids) {
		this.eqids = eqids;
	}

}
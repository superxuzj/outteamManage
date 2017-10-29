package com.boliangshenghe.outteam.entity;

import java.util.Date;

public class Link {
    private Integer id;

    private String name;

    private Integer rid;

    private Integer eqcid;

    private String eqcompany;

    private String state;

    private String remark;

    private Date createtime;
    
    private Integer start;
    
	private Integer limit;
	
	private String cids;

    public String getCids() {
		return cids;
	}

	public void setCids(String cids) {
		this.cids = cids;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getEqcid() {
        return eqcid;
    }

    public void setEqcid(Integer eqcid) {
        this.eqcid = eqcid;
    }

    public String getEqcompany() {
        return eqcompany;
    }

    public void setEqcompany(String eqcompany) {
        this.eqcompany = eqcompany == null ? null : eqcompany.trim();
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
}
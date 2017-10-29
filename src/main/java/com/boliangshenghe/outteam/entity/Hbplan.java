package com.boliangshenghe.outteam.entity;

import java.util.Date;

public class Hbplan {
    private Integer id;

    private String name;

    private String state;

    private String remark;

    private Date createtime;
    
    private Integer limit;
    
    private Integer start;
    
    private String cids;
    
    private String secondcids;
    
    public String getCids() {
		return cids;
	}

	public void setCids(String cids) {
		this.cids = cids;
	}

	public String getSecondcids() {
		return secondcids;
	}

	public void setSecondcids(String secondcids) {
		this.secondcids = secondcids;
	}

    public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
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
}
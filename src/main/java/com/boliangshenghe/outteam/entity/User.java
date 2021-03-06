package com.boliangshenghe.outteam.entity;

import java.util.Date;

public class User {
    private Integer id;

    private Integer roleid;//1 系统管理员 2 单位管理员 3 领导 4 队员

    private String name;

    private String username;

    private String phone;

    private String password;

    private String sex;

    private String idcard;

    private Integer cid;

    private String company;

    private String profession;

    private Date createtime;
    
    private Integer limit;
    
    private Integer start;
    
    private String iscontact;

    private String ismeet;

    private String islead;
    
    private String ischoose;
    
    private String state;
    
    private String phoneone;

    private String phonetwo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

	public String getIscontact() {
		return iscontact;
	}

	public void setIscontact(String iscontact) {
		this.iscontact = iscontact;
	}

	public String getIsmeet() {
		return ismeet;
	}

	public void setIsmeet(String ismeet) {
		this.ismeet = ismeet;
	}

	public String getIslead() {
		return islead;
	}

	public void setIslead(String islead) {
		this.islead = islead;
	}

	public String getIschoose() {
		return ischoose;
	}

	public void setIschoose(String ischoose) {
		this.ischoose = ischoose;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneone() {
		return phoneone;
	}

	public void setPhoneone(String phoneone) {
		this.phoneone = phoneone;
	}

	public String getPhonetwo() {
		return phonetwo;
	}

	public void setPhonetwo(String phonetwo) {
		this.phonetwo = phonetwo;
	}
}
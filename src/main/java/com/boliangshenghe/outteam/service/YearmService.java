package com.boliangshenghe.outteam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.entity.Onduty;
import com.boliangshenghe.outteam.entity.Yearm;
import com.boliangshenghe.outteam.repository.CompanyMapper;
import com.boliangshenghe.outteam.repository.OndutyMapper;
import com.boliangshenghe.outteam.repository.YearmMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 年月service
 * @author Administrator
 *
 */
@Service
public class YearmService {

	@Autowired
	YearmMapper yearmMapper;
	
	@Autowired
	OndutyMapper ondutyMapper;
	@Autowired
	CompanyMapper companyMapper;
	
	public int insertSelective(Yearm yearm) {
        return yearmMapper.insertSelective(yearm);
    }
	
    public Yearm selectByPrimaryKey(Integer id){
    	return yearmMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Yearm record){
    	return yearmMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return yearmMapper.deleteByPrimaryKey(id);
    }
    
    public List<Yearm> selectYearmList(Yearm record){
    	return yearmMapper.selectYearmList(record);
    }
    
    public PageBean<Yearm> getYearmByPage(Yearm record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Yearm> list = this.yearmMapper.selectYearmList(record);
        return new PageBean<Yearm>(list);
    }
    
    public void addDetail(Yearm yearm){
    	if(null == yearm.getId()){
    		yearmMapper.insertSelective(yearm);
			
    	}else{
    		yearmMapper.updateByPrimaryKeySelective(yearm);
    	}
    	String cids = yearm.getCids();
		String[] cidsArr = cids.split(",");
		if(!cidsArr[0].equals("")){
			Onduty onduty = new Onduty();
			onduty.setYearm(yearm.getYearm());//单位id有修改或者新增，先删除数据库里面该月份的配置，然后再重新插入
			ondutyMapper.deleteByOnduty(onduty);
			for (String cidtemp : cidsArr) {
				Onduty temp = new Onduty();
				temp.setCid(Integer.parseInt(cidtemp));
				Company company = companyMapper.selectByPrimaryKey(Integer.parseInt(cidtemp));//单位
				temp.setCompany(company.getProvince());
				temp.setYid(yearm.getId());
				temp.setYearm(yearm.getYearm());
				temp.setState("1");
				temp.setCreatetime(new Date());
				ondutyMapper.insertSelective(temp);
			}
		}
    	System.out.println(yearm.getCids());
    }
}

package com.boliangshenghe.outteam.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.entity.Earthquake;
import com.boliangshenghe.outteam.entity.Onduty;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.ResponseCompany;
import com.boliangshenghe.outteam.repository.CompanyMapper;
import com.boliangshenghe.outteam.repository.EarthquakeMapper;
import com.boliangshenghe.outteam.repository.OndutyMapper;
import com.boliangshenghe.outteam.repository.OutteamMapper;
import com.boliangshenghe.outteam.repository.ResponseCompanyMapper;
import com.boliangshenghe.outteam.util.CodeUtils;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

@Service
public class EarthquakeService {

	@Autowired
	EarthquakeMapper earthquakeMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	
	@Autowired
	OutteamMapper outteamMapper;
	
	@Autowired
	ResponseCompanyMapper responseCompanyMapper;
	
	@Autowired
	OndutyMapper ondutyMapper;
	
	public int insertSelective(Earthquake earthquake) {
        return earthquakeMapper.insertSelective(earthquake);
    }
	
    public Earthquake selectByPrimaryKey(Integer id){
    	return earthquakeMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Earthquake record){
    	return earthquakeMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Earthquake> selectEarthquakeList(Earthquake record){
    	return earthquakeMapper.selectEarthquakeList(record);
    }
    
    public PageBean<Earthquake> getEarthquakeByPage(Earthquake record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Earthquake> list = this.earthquakeMapper.selectEarthquakeList(record);
        return new PageBean<Earthquake>(list);
    }
    
    public void addoutteam(Integer eqid){
    	Set<String> set = new HashSet<String>();
    	Earthquake earthquake = earthquakeMapper.selectByPrimaryKey(eqid);//地震事件
    	
    	//震源省份出队
    	Company company = new Company();
		company.setProvince(earthquake.getProvince());
		List<Company> comlist = companyMapper.selectCompanyList(company);
		if(comlist!=null && comlist.size()>0){
			Company temp =  comlist.get(0);
			set.add(temp.getProvince());
			Outteam source = new Outteam();
			source.setCid(temp.getId());
			source.setCompany(temp.getProvince());
			source.setEqid(eqid);
			source.setEqname(earthquake.getEqname());
			source.setOuttype("1");//1 震源省份 2 响应等级 3 轮值 4 自己申请
			source.setState("1");
			source.setCreatetime(new Date());
			source.setCreator("管理员");
			outteamMapper.insertSelective(source);
		}
		
		//响应等级出队
		ResponseCompany responseCompany = new ResponseCompany();
		responseCompany.setRid(earthquake.getResponseid());//根据响应id查
		List<ResponseCompany> rcList = responseCompanyMapper.selectResponseCompanyList(responseCompany);
		if(rcList!=null && rcList.size()>0){
			for (ResponseCompany temp : rcList) {
				if(set.add(temp.getCompany())){//去重操作
					Outteam source = new Outteam();
					source.setCid(temp.getCid());
					source.setCompany(temp.getCompany());
					source.setEqid(eqid);
					source.setCount(temp.getCount());
					source.setDuty(temp.getDuty());
					source.setEqname(earthquake.getEqname());
					source.setOuttype("2");//1 震源省份 2 响应等级 3 轮值 4 自己申请
					source.setState("1");
					source.setCreatetime(new Date());
					source.setCreator("管理员");
					outteamMapper.insertSelective(source);	
				}
			}
		}
		
		//轮值出队------
		Onduty onduty = new Onduty();
		onduty.setYearm(CodeUtils.getYearMonth());
		List<Onduty> dutyList = ondutyMapper.selectOndutyList(onduty);
		if(dutyList!=null && dutyList.size()>0){
			for (Onduty temp : dutyList) {
				if(set.add(temp.getCompany())){//去重操作
					Outteam source = new Outteam();
					source.setCid(temp.getCid());
					source.setCompany(temp.getCompany());
					source.setEqid(eqid);
					source.setEqname(earthquake.getEqname());
					source.setOuttype("3");//1 震源省份 2 响应等级 3 轮值 4 自己申请
					source.setState("1");
					source.setCreatetime(new Date());
					source.setCreator("管理员");
					outteamMapper.insertSelective(source);	
				}
			}
		}
    }
}

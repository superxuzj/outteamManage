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
import com.boliangshenghe.outteam.entity.Hbplan;
import com.boliangshenghe.outteam.entity.HbplanDetail;
import com.boliangshenghe.outteam.entity.Link;
import com.boliangshenghe.outteam.entity.LinkDetail;
import com.boliangshenghe.outteam.entity.Onduty;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.ResponseCompany;
import com.boliangshenghe.outteam.repository.CompanyMapper;
import com.boliangshenghe.outteam.repository.EarthquakeMapper;
import com.boliangshenghe.outteam.repository.HbplanDetailMapper;
import com.boliangshenghe.outteam.repository.LinkDetailMapper;
import com.boliangshenghe.outteam.repository.LinkMapper;
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
	@Autowired
	HbplanService hbplanService;
	@Autowired
	HbplanDetailMapper hbplanDetailMapper;
	
	@Autowired
	LinkMapper linkMapper;
	
	@Autowired
	LinkDetailMapper linkDetailMapper;
		
	
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
    
    public void addoutteam(Integer eqid,String cids){
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
			source.setOuttype("1");//1 震源省份 2 响应等级 3 轮值 4 华北预案 5 联动 6管理员添加 7 自己申请
			source.setState("1");
			source.setCreatetime(new Date());
			source.setHit("1");
			source.setCreator("管理员");
			outteamMapper.insertSelective(source);
		}
		
		if(earthquake.getArea().equals("华北")){
			//华北地区 通过t_hbplan 来判断
			Hbplan hbplan = new Hbplan();
			hbplan.setCompanys(earthquake.getProvince());//发震省份
			hbplan.setHigh(earthquake.getMagnitude());//地震级数
			Hbplan hbplantemp = hbplanService.selectHbplanByCompanys(hbplan);
			
			HbplanDetail hbplanDetail = new HbplanDetail();
			hbplanDetail.setHbplanid(hbplantemp.getId());
			List<HbplanDetail> hbplanDetailList = hbplanDetailMapper.selectHbplanDetailList(hbplanDetail);
			if(null!=hbplanDetailList && hbplanDetailList.size()>0){
				for (HbplanDetail temp : hbplanDetailList) {
					if(set.add(temp.getCompany())){//去重操作
						Outteam source = new Outteam();
						source.setCid(temp.getCid());
						source.setCompany(temp.getCompany());
						source.setEqid(eqid);
						source.setCount(temp.getCount());
						source.setEqname(earthquake.getEqname());
						source.setOuttype("4");//1 震源省份 2 响应等级 3 轮值 4 华北预案 5 联动 6管理员添加 7 自己申请
						source.setState("1");
						source.setHit("2");
						source.setCreatetime(new Date());
						source.setCreator("管理员");
						outteamMapper.insertSelective(source);	
					}
				}
			}
		}else{
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
						source.setOuttype("2");//1 震源省份 2 响应等级 3 轮值 4 华北预案 5 联动 6管理员添加 7 自己申请
						source.setState("1");
						source.setHit("2");
						source.setCreatetime(new Date());
						source.setCreator("管理员");
						outteamMapper.insertSelective(source);	
					}
				}
			}
			
			//联动方案
			Link link = new Link();
			link.setRid(earthquake.getResponseid());
			link.setEqcompany(earthquake.getProvince());
			List<Link> linkList = linkMapper.selectLinkList(link);
			if(null != linkList && linkList.size()>0){
				Link linktemp = linkList.get(0);
				LinkDetail linkDetail = new LinkDetail();
				linkDetail.setLinkid(linktemp.getId());
				List<LinkDetail> linkDetailList = linkDetailMapper.selectLinkDetailList(linkDetail);
				if(linkDetailList!=null && linkDetailList.size()>0){
					for (LinkDetail temp : linkDetailList) {
						if(set.add(temp.getCompany())){//去重操作
							Outteam source = new Outteam();
							source.setCid(temp.getCid());
							source.setCompany(temp.getCompany());
							source.setEqid(eqid);
							source.setCount(temp.getCount());
							source.setEqname(earthquake.getEqname());
							source.setOuttype("5");//1 震源省份 2 响应等级 3 轮值 4 华北预案 5 联动 6管理员添加 7 自己申请
							source.setState("1");
							source.setHit("2");
							source.setCreatetime(new Date());
							source.setCreator("管理员");
							outteamMapper.insertSelective(source);	
						}
					}
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
					source.setOuttype("3");//1 震源省份 2 响应等级 3 轮值 4 华北预案 5 联动 6管理员添加 7 自己申请
					source.setState("1");
					source.setHit("2");
					source.setCreatetime(new Date());
					source.setCreator("管理员");
					outteamMapper.insertSelective(source);	
				}
			}
		}
		//手动添加的
		if(null != cids && !cids.trim().equals("")){
			String[] cidsArr = cids.split(",");
			if(!cidsArr[0].equals("")){
				for (String cidtemp : cidsArr) {
					Outteam source = new Outteam();
					source.setCid(Integer.parseInt(cidtemp));
					Company com = companyMapper.selectByPrimaryKey(Integer.parseInt(cidtemp));//单位
					if(set.add(com.getProvince())){//去重操作
						source.setCompany(com.getProvince());
						source.setEqid(eqid);
						source.setEqname(earthquake.getEqname());
						source.setOuttype("6");//1 震源省份 2 响应等级 3 轮值 4 华北预案 5 联动 6管理员添加 7 自己申请
						source.setState("1");
						source.setHit("2");
						source.setCreatetime(new Date());
						source.setCreator("管理员");
						outteamMapper.insertSelective(source);
					}
					
				}
			}
		}
    }
}

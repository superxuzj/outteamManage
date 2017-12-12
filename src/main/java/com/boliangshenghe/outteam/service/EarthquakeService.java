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
import com.boliangshenghe.outteam.entity.Phone;
import com.boliangshenghe.outteam.entity.Response;
import com.boliangshenghe.outteam.entity.ResponseCompany;
import com.boliangshenghe.outteam.repository.CompanyMapper;
import com.boliangshenghe.outteam.repository.EarthquakeMapper;
import com.boliangshenghe.outteam.repository.HbplanDetailMapper;
import com.boliangshenghe.outteam.repository.LinkDetailMapper;
import com.boliangshenghe.outteam.repository.LinkMapper;
import com.boliangshenghe.outteam.repository.OndutyMapper;
import com.boliangshenghe.outteam.repository.OutteamMapper;
import com.boliangshenghe.outteam.repository.PhoneMapper;
import com.boliangshenghe.outteam.repository.ResponseCompanyMapper;
import com.boliangshenghe.outteam.repository.ResponseMapper;
import com.boliangshenghe.outteam.util.CodeUtils;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.boliangshenghe.outteam.util.SendMessageUtil;
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
	ResponseMapper responseMapper;
	
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
	
	@Autowired
	PhoneMapper phoneMapper;
	
	@Autowired
	private PhoneService phoneService;
		
	
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
    
    /**
     * 查看该地震是够有出队单位
     * @param eqid
     * @return
     */
    public Set<String> getOutteamCompany(Integer eqid){
    	Set<String> set = new HashSet<String>();
    	Outteam o = new Outteam();
    	o.setEqid(eqid);
    	List<Outteam> outtemlist = outteamMapper.selectOutteamList(o);
    	if(null!=outtemlist && outtemlist.size()>0){
    		for (Outteam outteam : outtemlist) {
				set.add(outteam.getCompany());
			}
    		return set;
    	}else{
    		return set;
    	}
    }
    
    public void addoutteam(Integer eqid,String cids,Integer rid){
    	
    	Set<String> set = getOutteamCompany(eqid);
    	Set<Integer> sendSet = new HashSet<Integer>();//出队单位短信通知
    	Earthquake earthquake = earthquakeMapper.selectByPrimaryKey(eqid);//地震事件
    	
    	//震源省份出队
    	Company company = new Company();
		company.setProvince(earthquake.getProvince());
		List<Company> comlist = companyMapper.selectCompanyList(company);
		if(comlist!=null && comlist.size()>0){
			Company cp =  comlist.get(0);
			if(set.add(cp.getProvince())){
				Outteam source = new Outteam();
				source.setCid(cp.getId());
				source.setCompany(cp.getProvince());
				source.setEqid(eqid);
				source.setEqname(earthquake.getEqname());
				source.setOuttype("1");//1 震源省份 2 响应等级 3 轮值 4 华北预案 5 联动 6管理员添加 7 自己申请
				source.setState("1");
				source.setCreatetime(new Date());
				source.setHit("1");
				source.setCreator("管理员");
				outteamMapper.insertSelective(source);
				sendSet.add(cp.getId());
			}
		}
		
		if(earthquake.getArea().equals("华北")){
			//华北地区 通过t_hbplan 来判断
			Hbplan hbplan = new Hbplan();
			hbplan.setCompanys(earthquake.getProvince());//发震省份
			if(null!=earthquake.getMagnitude() && earthquake.getMagnitude().length()==1){
				earthquake.setMagnitude(earthquake.getMagnitude()+".0");
			}
			hbplan.setHigh(Double.parseDouble(earthquake.getMagnitude()));//地震级数
			Hbplan hbplantemp = hbplanService.selectHbplanByCompanys(hbplan);
			if(null!=hbplantemp.getId()){//有对应的华预案
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
							sendSet.add(temp.getCid());
						}
					}
				}
			}
			
		}else{
			//发送响应等级变更
			if(null!=rid && rid>0){
	    		if(rid.toString().equals(earthquake.getResponseid().toString())){//发生修改响应等级
	    			earthquake.setResponseid(rid);
	    			earthquakeMapper.updateByPrimaryKey(earthquake);
	    			//给所有单位发送升降级短信
    				Response r = responseMapper.selectByPrimaryKey(earthquake.getResponseid());
    				String message = earthquake.getEqname()+"的响应等级变更为："+r.getName();
    				SendMessageUtil.sendMessage(phoneService.getAllCompanyPhone(message), message);
	    		}
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
						source.setOuttype("2");//1 震源省份 2 响应等级 3 轮值 4 华北预案 5 联动 6管理员添加 7 自己申请
						source.setState("1");
						source.setHit("2");
						source.setCreatetime(new Date());
						source.setCreator("管理员");
						outteamMapper.insertSelective(source);
						sendSet.add(temp.getCid());
					}
				}
			}
			
			//联动方案
			Link link = new Link();
			link.setRid(earthquake.getResponseid());
			link.setEqcompany(earthquake.getProvince());
			link.setState("1");
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
							sendSet.add(temp.getCid());
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
					sendSet.add(temp.getCid());
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
						sendSet.add(com.getId());
					}
					
				}
			}
		}
		
		//给新增出队单位发送出队信息
		if(sendSet.size()>0){
			String tels = "tel:18611453795;";
			for (Integer cid : sendSet) {
				Phone p =  new Phone();
				p.setCid(cid);
				List<Phone> phonelist = phoneMapper.selectListByPhone(p);
				if(null!=phonelist && phonelist.size()>0){
					Phone phone = phonelist.get(0);
					if(null!=phone.getPhoneone() 
							&& !phone.getPhoneone().trim().equals("")
							&&phone.getPhoneone().trim().length()==11){
						tels = tels+ "tel:"+phone.getPhoneone()+";";
					}
					if(null!=phone.getPhonetwo() 
							&& !phone.getPhonetwo().trim().equals("")
							&&phone.getPhonetwo().trim().length()==11){
						tels = tels+ "tel:"+phone.getPhonetwo()+";";
					}
				}
			}
			tels = tels.substring(0, tels.length()-1);
			String message = earthquake.getEqname()+"地震，请到出队系统安排出队人员。";
			SendMessageUtil.sendMessage(phoneService.getAllCompanyPhone(message), message);
		}
    }
   
}

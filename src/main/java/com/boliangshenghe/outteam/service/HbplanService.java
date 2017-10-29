package com.boliangshenghe.outteam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.entity.Hbplan;
import com.boliangshenghe.outteam.entity.HbplanDetail;
import com.boliangshenghe.outteam.entity.LinkDetail;
import com.boliangshenghe.outteam.repository.CompanyMapper;
import com.boliangshenghe.outteam.repository.HbplanDetailMapper;
import com.boliangshenghe.outteam.repository.HbplanMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 华北预案service
 * @author Administrator
 *
 */
@Service
public class HbplanService {

	@Autowired
	HbplanMapper hbplanMapper;
	
	@Autowired
	HbplanDetailMapper hbplanDetailMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	
	public int insertSelective(Hbplan hbplan) {
        return hbplanMapper.insertSelective(hbplan);
    }
	
    public Hbplan selectByPrimaryKey(Integer id){
    	return hbplanMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Hbplan record){
    	return hbplanMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return hbplanMapper.deleteByPrimaryKey(id);
    }
    
    public List<Hbplan> selectHbplanList(Hbplan record){
    	return hbplanMapper.selectHbplanList(record);
    }
    
    public PageBean<Hbplan> gethbplanByPage(Hbplan record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Hbplan> list = this.hbplanMapper.selectHbplanList(record);
        return new PageBean<Hbplan>(list);
    }
    
    public void addDetail(Hbplan hbplan){
    	if(null == hbplan.getId()){
    		hbplan.setCreatetime(new Date());
    		hbplanMapper.insertSelective(hbplan);
    	}else{
    		hbplan.setCreatetime(new Date());
    		hbplanMapper.updateByPrimaryKeySelective(hbplan);
    	}
    	String cids = hbplan.getCids();
		String[] cidsArr = cids.split(",");
		if(!cidsArr[0].equals("")){
			HbplanDetail hbplanDetail = new HbplanDetail();
			hbplanDetail.setHbplanid(hbplan.getId());
			hbplanDetail.setType("1");
			hbplanDetailMapper.deleteByHbplanDetail(hbplanDetail);//如果有修改，先删除之前的配置
			for (String cidtemp : cidsArr) {
				HbplanDetail temp = new HbplanDetail();
				temp.setCid(Integer.parseInt(cidtemp));
				Company company = companyMapper.selectByPrimaryKey(Integer.parseInt(cidtemp));//单位
				temp.setCompany(company.getProvince());
				temp.setHbplanid(hbplan.getId());
				temp.setType("1");
				temp.setState("1");
				temp.setCreatetime(new Date());
				hbplanDetailMapper.insertSelective(temp);
			}
		}
		
		String secondcids = hbplan.getSecondcids();
		String[] secondcidsArr = secondcids.split(",");
		if(!secondcidsArr[0].equals("")){
			HbplanDetail hbplanDetail = new HbplanDetail();
			hbplanDetail.setHbplanid(hbplan.getId());
			hbplanDetail.setType("2");
			hbplanDetailMapper.deleteByHbplanDetail(hbplanDetail);//如果有修改，先删除之前的配置
			for (String cidtemp : secondcidsArr) {
				HbplanDetail temp = new HbplanDetail();
				temp.setCid(Integer.parseInt(cidtemp));
				Company company = companyMapper.selectByPrimaryKey(Integer.parseInt(cidtemp));//单位
				temp.setCompany(company.getProvince());
				temp.setHbplanid(hbplan.getId());
				temp.setType("2");
				temp.setState("1");
				temp.setCreatetime(new Date());
				hbplanDetailMapper.insertSelective(temp);
			}
		}
    }
    
}

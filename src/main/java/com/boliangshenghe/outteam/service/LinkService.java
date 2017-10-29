package com.boliangshenghe.outteam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.entity.Link;
import com.boliangshenghe.outteam.entity.LinkDetail;
import com.boliangshenghe.outteam.entity.Onduty;
import com.boliangshenghe.outteam.entity.Yearm;
import com.boliangshenghe.outteam.repository.CompanyMapper;
import com.boliangshenghe.outteam.repository.LinkDetailMapper;
import com.boliangshenghe.outteam.repository.LinkMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 联动service
 * @author Administrator
 *
 */
@Service
public class LinkService {

	@Autowired
	LinkMapper linkMapper;
	
	@Autowired
	LinkDetailMapper linkDetailMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	
	public int insertSelective(Link link) {
        return linkMapper.insertSelective(link);
    }
	
    public Link selectByPrimaryKey(Integer id){
    	return linkMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Link record){
    	return linkMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return linkMapper.deleteByPrimaryKey(id);
    }
    
    public List<Link> selectLinkList(Link record){
    	return linkMapper.selectLinkList(record);
    }
    
    public PageBean<Link> getLinkByPage(Link record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Link> list = this.linkMapper.selectLinkList(record);
        return new PageBean<Link>(list);
    }
    
    public void addDetail(Link link){
    	if(null!=link.getEqcid()){
			Company company = companyMapper.selectByPrimaryKey(link.getEqcid());
			link.setEqcompany(company.getProvince());
		}
    	if(null == link.getId()){
    		
    		linkMapper.insertSelective(link);
    	}else{
    		linkMapper.updateByPrimaryKeySelective(link);
    	}
    	String cids = link.getCids();
		String[] cidsArr = cids.split(",");
		if(!cidsArr[0].equals("")){
			LinkDetail linkDetail = new LinkDetail();
			linkDetail.setLinkid(link.getId());
			linkDetailMapper.deleteByLinkDetail(linkDetail);//如果有修改，先删除之前的配置
			for (String cidtemp : cidsArr) {
				LinkDetail temp = new LinkDetail();
				temp.setCid(Integer.parseInt(cidtemp));
				Company company = companyMapper.selectByPrimaryKey(Integer.parseInt(cidtemp));//单位
				temp.setCompany(company.getProvince());
				temp.setLinkid(link.getId());
				temp.setState("1");
				temp.setCreatetime(new Date());
				linkDetailMapper.insertSelective(temp);
			}
		}
    	System.out.println(link.getCids());
    }
    
}

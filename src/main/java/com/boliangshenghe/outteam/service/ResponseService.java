package com.boliangshenghe.outteam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.entity.Hbplan;
import com.boliangshenghe.outteam.entity.HbplanDetail;
import com.boliangshenghe.outteam.entity.Response;
import com.boliangshenghe.outteam.entity.ResponseCompany;
import com.boliangshenghe.outteam.repository.CompanyMapper;
import com.boliangshenghe.outteam.repository.ResponseCompanyMapper;
import com.boliangshenghe.outteam.repository.ResponseMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 响应service
 * @author Administrator
 *
 */
@Service
public class ResponseService {

	@Autowired
	ResponseMapper responseMapper;
	
	@Autowired
	ResponseCompanyMapper responseCompanyMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	
	public int insertSelective(Response response) {
        return responseMapper.insertSelective(response);
    }
	
    public Response selectByPrimaryKey(Integer id){
    	return responseMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Response record){
    	return responseMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return responseMapper.deleteByPrimaryKey(id);
    }
    
    public List<Response> selectResponseList(Response record){
    	return responseMapper.selectResponseList(record);
    }
    
    public PageBean<Response> getResponseByPage(Response record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Response> list = this.responseMapper.selectResponseList(record);
        return new PageBean<Response>(list);
    }
    
    public void addDetail(Response resp){
    	if(null == resp.getId()){
    		responseMapper.insertSelective(resp);
    	}else{
    		responseMapper.updateByPrimaryKeySelective(resp);
    	}
    	String cids = resp.getCids();
		String[] cidsArr = cids.split(",");
		if(!cidsArr[0].equals("")){
			ResponseCompany responseCompany = new ResponseCompany();
			responseCompany.setRid(resp.getId());
			responseCompanyMapper.deleteByResponseCompany(responseCompany);//如果有修改，先删除之前的配置
			for (String cidtemp : cidsArr) {
				ResponseCompany temp = new ResponseCompany();
				temp.setCid(Integer.parseInt(cidtemp));
				Company company = companyMapper.selectByPrimaryKey(Integer.parseInt(cidtemp));//单位
				temp.setCompany(company.getProvince());
				temp.setRid(resp.getId());
				temp.setRname(resp.getName());
				temp.setState("1");
				responseCompanyMapper.insertSelective(temp);
			}
		}
		
    }
}

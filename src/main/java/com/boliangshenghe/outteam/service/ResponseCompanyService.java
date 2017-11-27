package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.ResponseCompany;
import com.boliangshenghe.outteam.repository.ResponseCompanyMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 响应service
 * @author Administrator
 *
 */
@Service
public class ResponseCompanyService {

	@Autowired
	ResponseCompanyMapper responseCompanyMapper;
	
	public int insertSelective(ResponseCompany ResponseCompany) {
        return responseCompanyMapper.insertSelective(ResponseCompany);
    }
	
    public ResponseCompany selectByPrimaryKey(Integer id){
    	return responseCompanyMapper.selectByPrimaryKey(id);
    }
    
    public int deleteByResponseCompany(ResponseCompany record){
    	return responseCompanyMapper.deleteByResponseCompany(record);
    }
    
    public  int updateByPrimaryKeySelective(ResponseCompany record){
    	return responseCompanyMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return responseCompanyMapper.deleteByPrimaryKey(id);
    }
    
    public List<ResponseCompany> selectResponseCompanyList(ResponseCompany record){
    	return responseCompanyMapper.selectResponseCompanyList(record);
    }
    
    public PageBean<ResponseCompany> getResponseCompanyByPage(ResponseCompany record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<ResponseCompany> list = this.responseCompanyMapper.selectResponseCompanyList(record);
        return new PageBean<ResponseCompany>(list);
    }
}

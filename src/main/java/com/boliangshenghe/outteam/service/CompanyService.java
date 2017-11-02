package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.repository.CompanyMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 单位service
 * @author Administrator
 *
 */
@Service
public class CompanyService {

	@Autowired
	CompanyMapper companyMapper;
	
	public int insertSelective(Company company) {
        return companyMapper.insertSelective(company);
    }
	
    public Company selectByPrimaryKey(Integer id){
    	return companyMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Company record){
    	return companyMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return companyMapper.deleteByPrimaryKey(id);
    }
    
    public List<Company> selectCompanyList(Company record){
    	return companyMapper.selectCompanyList(record);
    }
    
    public PageBean<Company> getCompanyByPage(Company record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Company> list = this.companyMapper.selectCompanyList(record);
        /*for (Company company : list) {

        	 System.out.println("INSERT INTO t_user (roleid,name,username,password,cid,company) VALUES(2,'"
        	 +company.getProvince()+"','"+company.getCode()+"','111111',"
        	 +company.getId()+",'"+company.getProvince()+"');");
		}*/
        return new PageBean<Company>(list);
    }
}

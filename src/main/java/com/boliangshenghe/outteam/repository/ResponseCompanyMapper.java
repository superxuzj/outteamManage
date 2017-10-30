package com.boliangshenghe.outteam.repository;

import java.util.List;

import com.boliangshenghe.outteam.entity.ResponseCompany;

public interface ResponseCompanyMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByResponseCompany(ResponseCompany record);

    int insert(ResponseCompany record);

    int insertSelective(ResponseCompany record);

    ResponseCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResponseCompany record);

    int updateByPrimaryKey(ResponseCompany record);
    
    List<ResponseCompany> selectResponseCompanyList(ResponseCompany record);
}
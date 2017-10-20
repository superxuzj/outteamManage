package com.boliangshenghe.outteam.repository;

import com.boliangshenghe.outteam.entity.ResponseCompany;

public interface ResponseCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResponseCompany record);

    int insertSelective(ResponseCompany record);

    ResponseCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResponseCompany record);

    int updateByPrimaryKey(ResponseCompany record);
}
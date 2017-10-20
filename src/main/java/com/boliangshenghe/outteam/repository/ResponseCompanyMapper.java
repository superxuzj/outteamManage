package com.boliangshenghe.outteam.repository;

import com.boliangshenghe.outteam.entity.ResponseCompany;
import com.boliangshenghe.outteam.entity.ResponseCompanyWithBLOBs;

public interface ResponseCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResponseCompanyWithBLOBs record);

    int insertSelective(ResponseCompanyWithBLOBs record);

    ResponseCompanyWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResponseCompanyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ResponseCompanyWithBLOBs record);

    int updateByPrimaryKey(ResponseCompany record);
}
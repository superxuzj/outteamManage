package com.boliangshenghe.outteam.repository;

import com.boliangshenghe.outteam.entity.CompanyContact;

public interface CompanyContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyContact record);

    int insertSelective(CompanyContact record);

    CompanyContact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyContact record);

    int updateByPrimaryKey(CompanyContact record);
}
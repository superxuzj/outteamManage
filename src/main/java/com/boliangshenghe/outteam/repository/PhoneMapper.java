package com.boliangshenghe.outteam.repository;

import java.util.List;

import com.boliangshenghe.outteam.entity.Phone;

public interface PhoneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Phone record);

    int insertSelective(Phone record);

    Phone selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Phone record);

    int updateByPrimaryKey(Phone record);
    
    List<Phone> selectListByPhone(Phone record);
}
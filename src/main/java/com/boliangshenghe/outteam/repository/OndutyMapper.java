package com.boliangshenghe.outteam.repository;

import java.util.List;

import com.boliangshenghe.outteam.entity.Onduty;

public interface OndutyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Onduty record);

    int insertSelective(Onduty record);

    Onduty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Onduty record);

    int updateByPrimaryKey(Onduty record);
    
    List<Onduty> selectOndutyList(Onduty record);
}
package com.boliangshenghe.outteam.repository;

import java.util.List;

import com.boliangshenghe.outteam.entity.Yearm;

public interface YearmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yearm record);

    int insertSelective(Yearm record);

    Yearm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yearm record);

    int updateByPrimaryKey(Yearm record);
    
    List<Yearm> selectYearmList(Yearm record);
}
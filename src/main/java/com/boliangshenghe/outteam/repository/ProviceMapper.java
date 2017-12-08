package com.boliangshenghe.outteam.repository;

import java.util.List;

import com.boliangshenghe.outteam.entity.Provice;

public interface ProviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provice record);

    int insertSelective(Provice record);

    Provice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provice record);

    int updateByPrimaryKey(Provice record);
    
    List<Provice> selectProviceByRecord(Provice record);
    
}
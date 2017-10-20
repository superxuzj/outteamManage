package com.boliangshenghe.outteam.repository;

import java.util.List;

import com.boliangshenghe.outteam.entity.Earthquake;

public interface EarthquakeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Earthquake record);

    int insertSelective(Earthquake record);

    Earthquake selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Earthquake record);

    int updateByPrimaryKey(Earthquake record);
    
    List<Earthquake> selectEarthquakeList(Earthquake record);
}
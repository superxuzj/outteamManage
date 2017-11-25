package com.boliangshenghe.outteam.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boliangshenghe.outteam.entity.Hbplan;
@Mapper
public interface HbplanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hbplan record);

    int insertSelective(Hbplan record);

    Hbplan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hbplan record);

    int updateByPrimaryKey(Hbplan record);
    
    List<Hbplan> selectHbplanList(Hbplan record);
    
    List<Hbplan> selectHbplanByCompanys(Hbplan record);
}
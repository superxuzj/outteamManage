package com.boliangshenghe.outteam.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boliangshenghe.outteam.entity.HbplanDetail;
@Mapper
public interface HbplanDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HbplanDetail record);

    int insertSelective(HbplanDetail record);

    HbplanDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HbplanDetail record);

    int updateByPrimaryKey(HbplanDetail record);
    
    int deleteByHbplanDetail(HbplanDetail hbplanDetail);
    
    List<HbplanDetail> selectHbplanDetailList(HbplanDetail record);
}
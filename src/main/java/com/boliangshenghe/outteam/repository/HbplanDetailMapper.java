package com.boliangshenghe.outteam.repository;

import java.util.List;

import com.boliangshenghe.outteam.entity.HbplanDetail;

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
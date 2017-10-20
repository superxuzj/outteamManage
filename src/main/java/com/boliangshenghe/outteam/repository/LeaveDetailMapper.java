package com.boliangshenghe.outteam.repository;

import com.boliangshenghe.outteam.entity.LeaveDetail;

public interface LeaveDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeaveDetail record);

    int insertSelective(LeaveDetail record);

    LeaveDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeaveDetail record);

    int updateByPrimaryKey(LeaveDetail record);
}
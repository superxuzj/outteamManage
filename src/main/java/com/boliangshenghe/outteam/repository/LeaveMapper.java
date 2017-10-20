package com.boliangshenghe.outteam.repository;

import com.boliangshenghe.outteam.entity.Leave;

public interface LeaveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leave record);

    int insertSelective(Leave record);

    Leave selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKey(Leave record);
}
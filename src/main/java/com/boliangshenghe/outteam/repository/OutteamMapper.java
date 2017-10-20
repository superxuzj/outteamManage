package com.boliangshenghe.outteam.repository;

import com.boliangshenghe.outteam.entity.Outteam;

public interface OutteamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Outteam record);

    int insertSelective(Outteam record);

    Outteam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Outteam record);

    int updateByPrimaryKey(Outteam record);
}
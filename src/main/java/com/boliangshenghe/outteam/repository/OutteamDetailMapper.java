package com.boliangshenghe.outteam.repository;

import com.boliangshenghe.outteam.entity.OutteamDetail;

public interface OutteamDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OutteamDetail record);

    int insertSelective(OutteamDetail record);

    OutteamDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OutteamDetail record);

    int updateByPrimaryKey(OutteamDetail record);
}
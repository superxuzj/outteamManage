package com.boliangshenghe.outteam.repository;

import com.boliangshenghe.outteam.entity.Login;

public interface LoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
}
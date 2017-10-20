package com.boliangshenghe.outteam.repository;

import com.boliangshenghe.outteam.entity.Login;
import com.boliangshenghe.outteam.entity.LoginWithBLOBs;

public interface LoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginWithBLOBs record);

    int insertSelective(LoginWithBLOBs record);

    LoginWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LoginWithBLOBs record);

    int updateByPrimaryKey(Login record);
}
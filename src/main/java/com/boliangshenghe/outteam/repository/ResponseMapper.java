package com.boliangshenghe.outteam.repository;

import java.util.List;

import com.boliangshenghe.outteam.entity.Response;

public interface ResponseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Response record);

    int insertSelective(Response record);

    Response selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Response record);

    int updateByPrimaryKey(Response record);
    
    List<Response> selectResponseList(Response record);
}
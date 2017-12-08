package com.boliangshenghe.outteam.repository;

import java.util.List;

import com.boliangshenghe.outteam.entity.Flight;

public interface FlightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Flight record);

    int insertSelective(Flight record);

    Flight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Flight record);

    int updateByPrimaryKey(Flight record);
    
    List<Flight> selectFlightByRecord(Flight record);
    
    List<Flight> selectFlightNoProvice(Flight record);
    
    List<Flight> selectFlightNoArrive(Flight record);
    
    
}
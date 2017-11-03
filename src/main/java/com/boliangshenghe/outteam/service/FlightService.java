package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.entity.Flight;
import com.boliangshenghe.outteam.repository.FlightMapper;

/**
 * 航班service
 * @author Administrator
 *
 */
@Service
public class FlightService {

	@Autowired
	FlightMapper flightMapper;
	
	public int insertSelective(Flight Flight) {
        return flightMapper.insertSelective(Flight);
    }
	
    public Flight selectByPrimaryKey(Integer id){
    	return flightMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Flight record){
    	return flightMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return flightMapper.deleteByPrimaryKey(id);
    }
    
    public List<Flight> selectFlightByRecord(Flight record){
    	return flightMapper.selectFlightByRecord(record);
    }
    
}

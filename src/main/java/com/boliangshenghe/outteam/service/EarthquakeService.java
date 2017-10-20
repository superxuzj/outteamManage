package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Earthquake;
import com.boliangshenghe.outteam.repository.EarthquakeMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

@Service
public class EarthquakeService {

	@Autowired
	EarthquakeMapper earthquakeMapper;
	
	public int insertSelective(Earthquake earthquake) {
        return earthquakeMapper.insertSelective(earthquake);
    }
	
    public Earthquake selectByPrimaryKey(Integer id){
    	return earthquakeMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Earthquake record){
    	return earthquakeMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Earthquake> selectEarthquakeList(Earthquake record){
    	return earthquakeMapper.selectEarthquakeList(record);
    }
    
    public PageBean<Earthquake> getEarthquakeByPage(Earthquake record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Earthquake> list = this.earthquakeMapper.selectEarthquakeList(record);
        return new PageBean<Earthquake>(list);
    }
}

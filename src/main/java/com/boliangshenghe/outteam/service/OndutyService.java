package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Onduty;
import com.boliangshenghe.outteam.repository.OndutyMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 出队service
 * @author Administrator
 *
 */
@Service
public class OndutyService {

	@Autowired
	OndutyMapper ondutyMapper;
	
	public int insertSelective(Onduty Onduty) {
        return ondutyMapper.insertSelective(Onduty);
    }
	
    public Onduty selectByPrimaryKey(Integer id){
    	return ondutyMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Onduty record){
    	return ondutyMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return ondutyMapper.deleteByPrimaryKey(id);
    }
    
    public List<Onduty> selectOndutyList(Onduty record){
    	return ondutyMapper.selectOndutyList(record);
    }
    
    public PageBean<Onduty> getOndutyByPage(Onduty record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Onduty> list = this.ondutyMapper.selectOndutyList(record);
        return new PageBean<Onduty>(list);
    }
}

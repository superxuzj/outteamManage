package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Leave;
import com.boliangshenghe.outteam.entity.Onduty;
import com.boliangshenghe.outteam.repository.LeaveMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 撤离service
 * @author Administrator
 *
 */
@Service
public class LeaveService {

	@Autowired
	LeaveMapper LeaveMapper;
	
	public int insertSelective(Leave Leave) {
        return LeaveMapper.insertSelective(Leave);
    }
	
    public Leave selectByPrimaryKey(Integer id){
    	return LeaveMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Leave record){
    	return LeaveMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return LeaveMapper.deleteByPrimaryKey(id);
    }
    
    public List<Leave> selectLeaveList(Leave record){
    	return LeaveMapper.selectLeaveList(record);
    }
    
    public PageBean<Leave> getOndutyByPage(Leave record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Leave> list = this.LeaveMapper.selectLeaveList(record);
        return new PageBean<Leave>(list);
    }
    
}

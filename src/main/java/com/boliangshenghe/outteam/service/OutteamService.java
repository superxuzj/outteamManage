package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.repository.OutteamMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 出队service
 * @author Administrator
 *
 */
@Service
public class OutteamService {

	@Autowired
	OutteamMapper outteamMapper;
	
	public int insertSelective(Outteam outteam) {
        return outteamMapper.insertSelective(outteam);
    }
	
    public Outteam selectByPrimaryKey(Integer id){
    	return outteamMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Outteam record){
    	return outteamMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return outteamMapper.deleteByPrimaryKey(id);
    }
    
    public int selectOutteamCount(Outteam record){
    	return outteamMapper.selectOutteamCount(record);
    }
    
    public List<Outteam> selectOutteamList(Outteam record){
    	return outteamMapper.selectOutteamList(record);
    }
    
    public PageBean<Outteam> getOutteamByPage(Outteam record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Outteam> list = this.outteamMapper.selectOutteamList(record);
        return new PageBean<Outteam>(list);
    }
}

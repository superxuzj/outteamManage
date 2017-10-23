package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.OutteamDetail;
import com.boliangshenghe.outteam.repository.OutteamDetailMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 出队详情service
 * @author Administrator
 *
 */
@Service
public class OutteamDetailService {

	@Autowired
	OutteamDetailMapper outteamDetailMapper;
	
	public int insertSelective(OutteamDetail outteam) {
        return outteamDetailMapper.insertSelective(outteam);
    }
	
    public OutteamDetail selectByPrimaryKey(Integer id){
    	return outteamDetailMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(OutteamDetail record){
    	return outteamDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return outteamDetailMapper.deleteByPrimaryKey(id);
    }
    public List<OutteamDetail> selectOutteamDetailList(OutteamDetail record){
    	return outteamDetailMapper.selectOutteamDetailList(record);
    }
    
    public PageBean<OutteamDetail> getOutteamDetailByPage(OutteamDetail record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<OutteamDetail> list = this.outteamDetailMapper.selectOutteamDetailList(record);
        return new PageBean<OutteamDetail>(list);
    }
    
}

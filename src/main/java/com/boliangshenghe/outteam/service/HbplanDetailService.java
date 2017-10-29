package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.HbplanDetail;
import com.boliangshenghe.outteam.repository.HbplanDetailMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 华北预案详情service
 * @author Administrator
 *
 */
@Service
public class HbplanDetailService {

	@Autowired
	HbplanDetailMapper hbplanDetailMapper;
	
	public int insertSelective(HbplanDetail hbplanDetail) {
        return hbplanDetailMapper.insertSelective(hbplanDetail);
    }
	
    public HbplanDetail selectByPrimaryKey(Integer id){
    	return hbplanDetailMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(HbplanDetail record){
    	return hbplanDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return hbplanDetailMapper.deleteByPrimaryKey(id);
    }
    
    public int deleteByHbplanDetail(HbplanDetail hbplanDetail){
    	return hbplanDetailMapper.deleteByHbplanDetail(hbplanDetail);
    }
    
    public List<HbplanDetail> selectHbplanDetailList(HbplanDetail record){
    	return hbplanDetailMapper.selectHbplanDetailList(record);
    }
    
    public PageBean<HbplanDetail> getHbplanDetailByPage(HbplanDetail record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<HbplanDetail> list = this.hbplanDetailMapper.selectHbplanDetailList(record);
        return new PageBean<HbplanDetail>(list);
    }
}

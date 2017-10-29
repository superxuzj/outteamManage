package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.LinkDetail;
import com.boliangshenghe.outteam.repository.LinkDetailMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 联动详情service
 * @author Administrator
 *
 */
@Service
public class LinkDetailService {

	@Autowired
	LinkDetailMapper linkDetailMapper;
	
	public int insertSelective(LinkDetail linkDetail) {
        return linkDetailMapper.insertSelective(linkDetail);
    }
	
    public LinkDetail selectByPrimaryKey(Integer id){
    	return linkDetailMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(LinkDetail record){
    	return linkDetailMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return linkDetailMapper.deleteByPrimaryKey(id);
    }
    
    public int deleteByLinkDetail(LinkDetail linkDetail){
    	return linkDetailMapper.deleteByLinkDetail(linkDetail);
    }
    
    public List<LinkDetail> selectLinkDetailList(LinkDetail record){
    	return linkDetailMapper.selectLinkDetailList(record);
    }
    
    public PageBean<LinkDetail> getLinkDetailByPage(LinkDetail record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<LinkDetail> list = this.linkDetailMapper.selectLinkDetailList(record);
        return new PageBean<LinkDetail>(list);
    }
}

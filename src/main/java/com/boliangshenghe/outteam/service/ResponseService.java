package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Response;
import com.boliangshenghe.outteam.repository.ResponseMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 响应service
 * @author Administrator
 *
 */
@Service
public class ResponseService {

	@Autowired
	ResponseMapper responseMapper;
	
	public int insertSelective(Response response) {
        return responseMapper.insertSelective(response);
    }
	
    public Response selectByPrimaryKey(Integer id){
    	return responseMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Response record){
    	return responseMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return responseMapper.deleteByPrimaryKey(id);
    }
    
    public List<Response> selectResponseList(Response record){
    	return responseMapper.selectResponseList(record);
    }
    
    public PageBean<Response> getResponseByPage(Response record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Response> list = this.responseMapper.selectResponseList(record);
        return new PageBean<Response>(list);
    }
}

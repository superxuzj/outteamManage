package com.boliangshenghe.outteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.entity.Login;
import com.boliangshenghe.outteam.repository.LoginMapper;

/**
登录记录service
 * @author Administrator
 *
 */
@Service
public class LoginService {

	@Autowired
	LoginMapper loginMapper;
	
	public int insertSelective(Login login) {
        return loginMapper.insertSelective(login);
    }
	
    public Login selectByPrimaryKey(Integer id){
    	return loginMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Login record){
    	return loginMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return loginMapper.deleteByPrimaryKey(id);
    }
}

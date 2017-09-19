package com.boliangshenghe.outteam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.repository.UserMapper;
import com.github.pagehelper.PageHelper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }
	
    public Integer selectUserListCount(User record){
    	return userMapper.selectUserListCount(record);
    }
    
    public User selectByPrimaryKey(Integer id){
    	return userMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(User record){
    	return userMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<User> selectUserList(User record){
    	return userMapper.selectUserList(record);
    }
    
    public PageBean<User> getUserByPage(User record,Integer pageNo,Integer size) {
        
        PageHelper.startPage(pageNo,10);
        List<User> list = this.userMapper.selectUserList(record);
        return new PageBean<User>(list);
    }
}

package com.boliangshenghe.outteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Role;
import com.boliangshenghe.outteam.repository.RoleMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.github.pagehelper.PageHelper;

@Service
public class RoleService {

	@Autowired
	RoleMapper roleMapper;
	
	public int insertSelective(Role role) {
        return roleMapper.insertSelective(role);
    }
	
    public Role selectByPrimaryKey(Integer id){
    	return roleMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Role record){
    	return roleMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Role> selectRoleList(Role record){
    	return roleMapper.selectRoleList(record);
    }
    
    public PageBean<Role> getRoleByPage(Role record,Integer pageNo) {
    	 PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Role> list = this.roleMapper.selectRoleList(record);
        return new PageBean<Role>(list);
    }
}

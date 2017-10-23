package com.boliangshenghe.outteam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.OutteamDetail;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.repository.OutteamDetailMapper;
import com.boliangshenghe.outteam.repository.OutteamMapper;
import com.boliangshenghe.outteam.repository.UserMapper;
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

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	OutteamDetailMapper outteamDetailMapper;
	
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
    
    public void addDetail(Outteam outteam){
	    //获取航班信息，插入航班表 获取航班表id
			
		//插入出队详情表
		
		String chooses = outteam.getChooses();
		String[] choosesArr = chooses.split(",");
		if(choosesArr!=null && choosesArr.length>0){
			for (String choosetemp : choosesArr) {
				User user = userMapper.selectByPrimaryKey(Integer.parseInt(choosetemp));
				OutteamDetail outteamDetail = new OutteamDetail();
				outteamDetail.setCreatetime(new Date());
				outteamDetail.setEqid(outteam.getEqid());
				outteamDetail.setEqname(outteam.getEqname());
				if(isInclude(user.getId().toString(),outteam.getContacts())){
					outteamDetail.setIscontact("1");
				}
				if(isInclude(user.getId().toString(),outteam.getLeaders())){
					outteamDetail.setIdlead("1");
				}
				outteamDetail.setName(user.getName());
				outteamDetail.setOtid(outteam.getId());
				outteamDetail.setPhone(user.getPhone());
				outteamDetail.setCid(user.getCid());
				outteamDetail.setCompany(user.getCompany());
				outteamDetailMapper.insertSelective(outteamDetail);
			}
		}
    }
    
    private boolean isInclude(String value,String arrString){
    	String[] arr = arrString.split(",");
    	if(arr!=null && arr.length>0){
    		for(int i = 0 ; i < arr.length ; i++){
        		if(arr[i].equals(value)){
        			return true;
        		}
        	}
    	}
    	return false;
    }
}

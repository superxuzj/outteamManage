package com.boliangshenghe.outteam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.entity.Message;
import com.boliangshenghe.outteam.entity.Phone;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.repository.CompanyMapper;
import com.boliangshenghe.outteam.repository.MessageMapper;
import com.boliangshenghe.outteam.repository.PhoneMapper;

/**
 * 联动service
 * @author Administrator
 *
 */
@Service
public class PhoneService {

	@Autowired
	PhoneMapper phoneMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	
	@Autowired
	MessageMapper messageMapper;
	
	public int insertSelective(Phone phone) {
        return phoneMapper.insertSelective(phone);
    }
	
    public Phone selectByPrimaryKey(Integer id){
    	return phoneMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Phone record){
    	return phoneMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return phoneMapper.deleteByPrimaryKey(id);
    }
    
    public List<Phone> selectListByPhone(Phone record){
    	return phoneMapper.selectListByPhone(record);			
    }
    
    public void addDetail(User user){
    	
    	Phone phone = new Phone();
    	phone.setUserid(user.getId());
    	List<Phone> list = phoneMapper.selectListByPhone(phone);
    	if(null!=list && list.size()>0){
    		Phone p = list.get(0);
    		p.setPhoneone(user.getPhoneone());
    		p.setPhonetwo(user.getPhonetwo());
    		phoneMapper.updateByPrimaryKeySelective(p);
    	}else{
    		phone.setCid(user.getCid());
    		phone.setCompany(user.getCompany());
    		phone.setUsername(user.getUsername());
    		phone.setPhoneone(user.getPhoneone());
    		phone.setPhonetwo(user.getPhonetwo());
    		phoneMapper.insertSelective(phone);
    	}
    }
    
    /**
     *获得所有单位的电话 
     * @return
     */
    public String getAllCompanyPhone(String message){
    	List<Phone> phonelist = phoneMapper.selectListByPhone(new Phone());
    	String tels = "tel:18611453795;";
		if(null!=phonelist && phonelist.size()>0){
			for (Phone phone : phonelist) {
				if(null!=phone.getPhoneone() 
						&& !phone.getPhoneone().trim().equals("")
						&&phone.getPhoneone().trim().length()==11){
					tels = tels+ "tel:"+phone.getPhoneone()+";";
					
					Message record = new Message();
					record.setContent(message);
					record.setPhone(phone.getPhoneone());
					record.setSendtime(new Date());
					messageMapper.insertSelective(record);
				}
				if(null!=phone.getPhonetwo() 
						&& !phone.getPhonetwo().trim().equals("")
						&&phone.getPhonetwo().trim().length()==11){
					tels = tels+ "tel:"+phone.getPhonetwo()+";";
					Message record = new Message();
					record.setContent(message);
					record.setPhone(phone.getPhonetwo());
					record.setSendtime(new Date());
					messageMapper.insertSelective(record);
				}
			}
			tels = tels.substring(0, tels.length()-1);
		}	
		return tels;
    }
}

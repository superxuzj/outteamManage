package com.boliangshenghe.outteam.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Catalogcopy;
import com.boliangshenghe.outteam.repository.CatalogcopyMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.boliangshenghe.outteam.util.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xml.internal.resolver.Catalog;

@Service
public class CatalogcopyService {
	
	@Autowired
	CatalogcopyMapper catalogcopyMapper;
	
	public int insertSelective(Catalogcopy catalogcopy) {
        return catalogcopyMapper.insertSelective(catalogcopy);
    }
	
    public Catalogcopy selectByPrimaryKey(String id){
    	return catalogcopyMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Catalogcopy record){
    	return catalogcopyMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Catalogcopy> selectCatalogcopyList(Catalogcopy record){
    	List<Catalogcopy> list = catalogcopyMapper.selectCatalogcopyList(record);
    	return list;
    }
    
    public Catalogcopy selectCatalogcopyByEventId(String eventId){
    	Catalogcopy record = new Catalogcopy();
    	record.setEventId(eventId);
    	List<Catalogcopy> list = catalogcopyMapper.selectCatalogcopyList(record);
    	if(null!=list && list.size()>0){
    		return list.get(0);
    	}
    	return null;
    }
    
    
    //根据Eventid去重
    public Set<String> selectCatalogcopyEventIDList(Catalogcopy record){
    	List<Catalogcopy> jlist = catalogcopyMapper.selectCatalogcopyEventIDList(record);
    	Set<String> jset = new HashSet<String>();
    	for (Catalogcopy jdata : jlist) {
    		jset.add(jdata.getEventId());
		}
    	return jset;
    }
    
    public PageBean<Catalogcopy> getCatalogcopyByPage(Catalogcopy record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Catalogcopy> list = this.selectCatalogcopyList(record);
        return new PageBean<Catalogcopy>(list);
    }
   
}

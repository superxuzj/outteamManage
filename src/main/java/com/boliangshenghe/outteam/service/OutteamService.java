package com.boliangshenghe.outteam.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Flight;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.OutteamDetail;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.repository.FlightMapper;
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
	
	@Autowired
	FlightMapper flightMapper;
	
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
    
    /**
     * select 
    DISTINCT eqid
    from t_outteam where cid=#{cid,jdbcType=INTEGER} and hit=1
         获取是受灾省份对应的eqid
     * @param record
     * @return
     */
    public List<Outteam> selectDistinctEqIDByCid(Outteam record){
    	return outteamMapper.selectDistinctEqIDByCid(record);
    }
    
    public PageBean<Outteam> getOutteamByPageForLeave(Outteam record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Outteam> list = this.outteamMapper.selectOutteamListForLeave(record);
        return new PageBean<Outteam>(list);
    }
    
    public void addDetail(Outteam outteam){
	    //获取航班信息，插入航班表 获取航班表id
//    	
    	
    	Flight flight = new Flight();
    	flight.setArractual(outteam.getArractual());
    	flight.setArrcity(outteam.getArrcity());
    	flight.setArrport(outteam.getArrport());
    	flight.setArrscheduled(outteam.getArrscheduled());
    	flight.setArrterminal(outteam.getArrterminal());
    	flight.setDepactual(outteam.getDepactual());
    	flight.setDepcity(outteam.getDepcity());
    	flight.setDepdate(outteam.getDepdate());
    	flight.setDepport(outteam.getDepport());
    	flight.setDepscheduled(outteam.getDepscheduled());
    	flight.setDepterminal(outteam.getDepterminal());
    	flight.setFlight(outteam.getFlight());
    	flight.setFlightstate(outteam.getFlightstate());
    	flight.setDepdate(outteam.getDepdate());
    	if(!outteam.getFlight().equals("")){//要是不要坐飞机，没有航班信息
    		List<Flight> flightlist = flightMapper.selectFlightByRecord(flight);
        	if(flightlist!=null && flightlist.size()>0){
        		flight.setId(flightlist.get(0).getId());
        		flightMapper.updateByPrimaryKeySelective(flight);
        	}else{
        		flightMapper.insertSelective(flight);
        	}
        	
        	outteam.setFid(flight.getId());
        	outteam.setFlight(flight.getFlight());
    	}
    	
    	outteamMapper.updateByPrimaryKeySelective(outteam);
		
		String chooses = outteam.getChooses();
		String[] choosesArr = chooses.split(",");
		if(!choosesArr[0].equals("")){
			//插入出队详情表 -- 先删除上次保存的(根据单位id和eqid)，再插入
			OutteamDetail upd = new OutteamDetail();
	    	upd.setCid(outteam.getCid());
	    	upd.setEqid(outteam.getEqid());
	    	outteamDetailMapper.updateByOutteamDetail(upd);
			
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
					outteamDetail.setIslead("1");
				}
				outteamDetail.setUserid(user.getId());
				outteamDetail.setName(user.getName());
				outteamDetail.setOtid(outteam.getId());
				outteamDetail.setPhone(user.getPhone());
				outteamDetail.setCid(user.getCid());
				outteamDetail.setCompany(user.getCompany());
				outteamDetail.setFid(flight.getId());
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

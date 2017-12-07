package com.boliangshenghe.outteam.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.outteam.entity.Flight;
import com.boliangshenghe.outteam.repository.FlightMapper;
import com.boliangshenghe.outteam.util.CommonUtils;

/**
 * 航班service
 * @author Administrator
 *
 */
@Service
public class FlightService {

	@Autowired
	FlightMapper flightMapper;
	
	public int insertSelective(Flight Flight) {
        return flightMapper.insertSelective(Flight);
    }
	
    public Flight selectByPrimaryKey(Integer id){
    	return flightMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Flight record){
    	return flightMapper.updateByPrimaryKeySelective(record);
    }
    
    public int deleteByPrimaryKey(Integer id){
    	return flightMapper.deleteByPrimaryKey(id);
    }
    
    public List<Flight> selectFlightByRecord(Flight record){
    	return flightMapper.selectFlightByRecord(record);
    }
    
    /**
     * 省数据为空
     * @param record
     * @return
     */
    public List<Flight> selectFlightNoProvice(Flight record){
    	return flightMapper.selectFlightNoProvice(record);
    }
    
    public void updateFlightStateBytask(){
    	Flight record = new Flight();
    	List<Flight> flightList = this.selectFlightNoProvice(record);
    	if(null != flightList && flightList.size()>0){
    		for (Flight flight : flightList) {
				if(null == flight.getArrcode() || flight.getArrcode().equals("")){
					Connection conn = Jsoup.connect("http://www.variflight.com/schedule/PEK-SZX-ZH9112.html?AE71649A58c77=");//获取连接
		            //设置请求头，伪装成浏览器(否则会报403)
		            conn.header("User-Agent", CommonUtils.HEAD);
		            Document doc = null;
					try {
						doc = conn.timeout(CommonUtils.TIMEOUT).get();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Element page = doc.select("div.pagination").first().nextElementSibling();
					System.out.println(doc.html());
				}
			}
    	}
    }
    
    public static void main(String[] args) {
    	Connection conn = Jsoup.connect("http://www.variflight.com/schedule/PEK-SZX-ZH9112.html?AE71649A58c77=");//获取连接
        //设置请求头，伪装成浏览器(否则会报403)
        conn.header("User-Agent", CommonUtils.HEAD);
        Document doc = null;
		try {
			doc = conn.timeout(CommonUtils.TIMEOUT).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Element page = doc.select("div.pagination").first().nextElementSibling();
		Element stateEle = doc.select("div.gre_cor").first();
		String state = stateEle.text();
		System.out.println(state);
//		System.out.println(doc.html());
	}
    
}

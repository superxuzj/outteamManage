package com.boliangshenghe.outteam.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boliangshenghe.outteam.entity.Flight;
import com.boliangshenghe.outteam.entity.Provice;
import com.boliangshenghe.outteam.json.JsonFlight;
import com.boliangshenghe.outteam.json.Result;
import com.boliangshenghe.outteam.pojo.ProviceBean;
import com.boliangshenghe.outteam.pojo.ProviceResult;
import com.boliangshenghe.outteam.repository.FlightMapper;
import com.boliangshenghe.outteam.repository.ProviceMapper;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.boliangshenghe.outteam.util.FlightUtils;
import com.boliangshenghe.outteam.util.HttpUtils;
import com.boliangshenghe.outteam.util.JsonUtils;

/**
 * 航班service
 * @author Administrator
 *
 */
@Service
public class FlightService {

	@Autowired
	FlightMapper flightMapper;
	
	@Autowired
	private ProviceMapper proviceMapper;
	
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
    
    /**
     * 航班还没有到达
     * @param record
     * @return
     */
    public List<Flight> selectFlightNoArrive(Flight record){
    	return flightMapper.selectFlightNoArrive(record);
    }
    
    /**
     * 更新航班状态信息
     */
    public void updateFlightStateBytask(){
    	Flight record = new Flight();
    	List<Flight> flightList = this.selectFlightNoArrive(record);
    	if(null != flightList && flightList.size()>0){
    		for (Flight flight : flightList) {
				if(null==flight.getFlightstate()||!flight.getFlightstate().equals("到达")){//航班状态还没到达
					String state = getStateByFlight(flight);
					if(state.equals("到达")){
						flight.setFlightstate("到达");
						try {
							String content = FlightUtils.makeRequest(flight.getFlight(), flight.getDepdate());
							System.out.println(content+" -------");
							if(content.indexOf("output")==-1){//查询失败，返回失败信息
								continue;
							}
							JSONObject jsonObj = JSONObject.parseObject(content);
							JsonFlight jsonFlight = JSON.toJavaObject(jsonObj, JsonFlight.class);
							List<Result> resultList = jsonFlight.getOutput().getResult();
							if(resultList!=null && resultList.size()>0){
								for (Result result : resultList) {
									if(result.getArrCity().equals(flight.getArrcity())
											&&result.getDepCity().equals(flight.getDepcity())){
										flight.setDepactual(result.getDepActual());
										flight.setArractual(result.getArrActual());
										break;
									}
								}
							}
							flightMapper.updateByPrimaryKeySelective(flight);
						} catch (Exception c) {
							// TODO Auto-generated catch block
							c.printStackTrace();
						}
					}
				}
			}
    	}
    }
    
    /**
     * 更新省份
     */
    public void updateProviceBytask(){
    	Flight record = new Flight();
    	List<Flight> flightList = this.selectFlightNoProvice(record);
    	if(null != flightList && flightList.size()>0){
    		for (Flight flight : flightList) {
				if(null == flight.getArrprovice() || flight.getArrprovice().equals("")){
					String provice = getProviceByFlight(flight.getArrcity());
					if(!provice.equals("")){
						flight.setArrprovice(provice);
						this.updateByPrimaryKeySelective(flight);
					}
				}
				if(null == flight.getDepprovice() || flight.getDepprovice().equals("")){
					String provice = getProviceByFlight(flight.getDepcity());
					if(!provice.equals("")){
						flight.setDepprovice(provice);
						this.updateByPrimaryKeySelective(flight);
					}
				}
			}
    	}
    }
    
    /**
     * 根据市查找所在省
     * @param flight
     * @return
     */
    private String getProviceByFlight(String city){
    	Provice temp = new Provice();
    	if(null == city||city.equals("")){
    		temp.setName("none");
    	}else{
    		temp.setName(city);
    	}
		List<Provice> prolist = proviceMapper.selectProviceByRecord(temp);
		if(null!=prolist && prolist.size()>0){
			Provice provice = prolist.get(0);
			return provice.getParentname();
		}
    	return "";
    }
    
    private String getStateByFlight(Flight flight){
    	String dateString = flight.getDepdate().replace("-", "");
    	String url = "http://www.variflight.com/schedule/"+flight.getDepcode()
    			+"-"+flight.getArrcode()+"-"+flight.getFlight()+".html?AE71649A58c77=&fdate="+dateString;
    	//System.out.println(url);
		try {
			Connection conn = Jsoup.connect(url);//获取连接
	        //设置请求头，伪装成浏览器(否则会报403)
	        conn.header("User-Agent", CommonUtils.HEAD);
	        Document doc = conn.timeout(CommonUtils.TIMEOUT).get();
			Element stateEle = doc.select("div.reg").first();
			String state = stateEle.text();
			System.out.println(state);
			return state;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "none";
		}
    }
    
    public static void main(String[] args) {
    	/*Connection conn = Jsoup.connect("http://www.variflight.com/schedule/PEK-YIC-ZH9112.html?AE71649A58c77=&fdate=20171207");//获取连接
        //设置请求头，伪装成浏览器(否则会报403)
        conn.header("User-Agent", CommonUtils.HEAD);
        Document doc = null;
		try {
			doc = conn.timeout(CommonUtils.TIMEOUT).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element stateEle = doc.select("div.reg").first();
		String state = stateEle.text();
		System.out.println(state);
		String a = "2017-10-25";
		System.out.println(a.replace("-", ""));*/
    	
    	String host = "http://jisuarea.market.alicloudapi.com";
	    String path = "/area/all";
	    String method = "GET";
	    String appcode = "46b8fc4323a74f3bbc412de17c9c77c9";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	System.out.println(response.toString());
	    	System.out.println(response.getEntity().getContent());
	    	InputStream is = response.getEntity().getContent();
    	  BufferedReader reader = new BufferedReader(new InputStreamReader(is));   
          StringBuilder sb = new StringBuilder();   
      
          String line = null;   
          try {   
              while ((line = reader.readLine()) != null) {   
                  sb.append(line + "/n");   
              }   
          } catch (IOException e) {   
              e.printStackTrace();   
          } finally {   
              try {   
                  is.close();   
              } catch (IOException e) {   
                  e.printStackTrace();   
              }   
          }   
          ProviceBean proviceBean = JsonUtils.toBean(sb.toString(), ProviceBean.class);//result对象
          List<ProviceResult> resultList = proviceBean.getResult();
          for (ProviceResult result : resultList) {
			Provice provice = new Provice();
			
			provice.setId(Integer.valueOf(result.getId()));
			provice.setDepth(result.getDepth());
			provice.setAreacode(result.getAreacode());
			provice.setName(result.getName());
			provice.setParentid(Integer.valueOf(result.getParentid()));
			provice.setParentname(result.getParentname());
			provice.setZipcode(result.getZipcode());
			
			//proviceMapper.
			
          }
	         System.out.println();
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	}
    
}

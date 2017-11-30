package com.boliangshenghe.outteam.controller.activemq;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boliangshenghe.outteam.entity.Catalogcopy;
import com.boliangshenghe.outteam.entity.Earthquake;
import com.boliangshenghe.outteam.service.CatalogcopyService;
import com.boliangshenghe.outteam.service.EarthquakeService;
import com.boliangshenghe.outteam.util.JsonUtils;

@Component
public class TopicReceiver implements MessageListener {

	@Autowired
	private EarthquakeService earthquakeService;
	
	@Autowired
	private CatalogcopyService catalogcopyService;
	public void onMessage(Message message) {
		try {
			System.out.println("maven  ---TopicReceiver1接收到消息:"
					+ ((TextMessage) message).getText());
			String mes = ((TextMessage) message).getText();
			Catalogcopy catalogcopy = JsonUtils.toBean(mes, Catalogcopy.class);//result对象
			catalogcopy.setIsouttem("2");//默认不出队
			catalogcopyService.insertSelective(catalogcopy);
			/*Map<String,String> map = new HashMap<String,String>();
			map.put("key", CommonUtils.GAODEKEY);
			map.put("location",catalogcopy.getLon()+","+catalogcopy.getLat());
			map.put("radius","1000");
			map.put("extensions","all");
			map.put("batch","false");
			map.put("roadlevel","0");
			String retu = HttpClientUtil.doGet("http://restapi.amap.com/v3/geocode/regeo",map);
			
			String provice = retu.substring(retu.indexOf("province")+11, retu.indexOf("city")-3);*/
			
			
			/*Earthquake earthquake = new Earthquake();
			
			earthquake.setCreatetime(new Date());
			earthquake.setCreator("管理员");
			earthquake.setState("2");//1演练 2 eqim触发
			
			
			//earthquake.setProvince(company.getProvince());
			earthquakeService.insertSelective(earthquake);*/
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
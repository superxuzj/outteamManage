package com.boliangshenghe.outteam.activemq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boliangshenghe.outteam.entity.Catalogcopy;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.service.CatalogcopyService;
import com.boliangshenghe.outteam.service.CompanyService;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.boliangshenghe.outteam.util.HttpClientUtil;
import com.boliangshenghe.outteam.util.JsonUtils;

@Component
public class TopicReceiver implements MessageListener {

	@Autowired
	private CatalogcopyService catalogcopyService;
	
	@Autowired
	private CompanyService companyService;
	
	public void onMessage(Message message) {
		try {
			System.out.println("maven  ---TopicReceiver1接收到消息:"
					+ ((TextMessage) message).getText());
			String mes = ((TextMessage) message).getText();
			if(mes.indexOf("cataId")!=-1){
				Catalogcopy catalogcopy = JsonUtils.toBean(mes, Catalogcopy.class);//result对象
				List<Catalogcopy> list = catalogcopyService.selectCatalogcopyList(catalogcopy);
				if(null != list && list.size()>0){
					
				}else{
					Map<String,String> map = new HashMap<String,String>();
					map.put("key", CommonUtils.GAODEKEY);
					map.put("location",catalogcopy.getLon()+","+catalogcopy.getLat());
					map.put("radius","1000");
					map.put("extensions","all");
					map.put("batch","false");
					map.put("roadlevel","0");
					String retu = HttpClientUtil.doGet("http://restapi.amap.com/v3/geocode/regeo",map);
					
					String province = retu.substring(retu.indexOf("province")+11, retu.indexOf("city")-3);
					
					if(!province.trim().equals("")){
						String pro = province.substring(0, 2);
						Company record = new Company();
						record.setProvince(pro);
						List<Company> companyList = companyService.selectCompanyList(record);
						if(null!=companyList && companyList.size()>0){
							Company company = companyList.get(0);
							catalogcopy.setProvince(company.getProvince());
							catalogcopy.setCid(company.getId());
							catalogcopy.setArea(getArea(company.getProvince()));
							System.out.println(company.getProvince()+" zhen省份");
							catalogcopy.setIsouttem("2");//默认不出队
							try {
								catalogcopyService.insertSelective(catalogcopy);
							} catch (Exception c) {
								// TODO: handle exception
								c.printStackTrace();
							}
						}
					}
				}
			}
			
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
	
	/**
	 * 根据省份判断 华北地区
	 * @param provice
	 * @return
	 */
	public String getArea(String provice){
		if(provice.equals("北京")||provice.equals("天津")
				||provice.equals("山西")||provice.equals("河北")
				||provice.equals("内蒙古")||provice.equals("山东")
				||provice.equals("河南")){
			return "华北";
		}else{
			return "非华北";
		}
	}
}
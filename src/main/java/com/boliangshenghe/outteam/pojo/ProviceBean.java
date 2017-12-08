/**
  * Copyright 2017 bejson.com 
  */
package com.boliangshenghe.outteam.pojo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boliangshenghe.outteam.entity.Provice;
import com.boliangshenghe.outteam.util.HttpUtils;

/**
 * Auto-generated: 2017-12-08 10:36:51
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ProviceBean {
	
	/*String host = "http://jisuarea.market.alicloudapi.com";
    String path = "/area/all";
    String method = "GET";
    String appcode = "46b8fc4323a74f3bbc412de17c9c77c9";
    Map<String, String> headers = new HashMap<String, String>();
    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
    headers.put("Authorization", "APPCODE " + appcode);
    Map<String, String> querys = new HashMap<String, String>();
    try {
    	*//**
    	* 重要提示如下:
    	* HttpUtils请从
    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
    	* 下载
    	*
    	* 相应的依赖请参照
    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
    	*//*
    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
    	System.out.println(response.toString());
    	System.out.println(response.getEntity().getContent());
    	InputStream is = response.getEntity().getContent();
	  BufferedReader reader = new BufferedReader(new InputStreamReader(is));   
      StringBuilder sb = new StringBuilder();   
  
      String line = null;   
      try {   
          while ((line = reader.readLine()) != null) {   
              sb.append(line);   
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
      System.out.println(sb.toString());
      JSONObject jsonObj = JSONObject.parseObject(sb.toString());
		System.out.println(jsonObj.toString());
		ProviceBean ProviceBean = JSON.toJavaObject(jsonObj, ProviceBean.class);
      //ProviceBean proviceBean = JsonUtils.toBean(sb.toString(), ProviceBean.class);//result对象
      List<Result> resultList = ProviceBean.getResult();
      for (Result result : resultList) {
		Provice provice = new Provice();
		
		provice.setId(Integer.valueOf(result.getId()));
		provice.setDepth(result.getDepth());
		provice.setAreacode(result.getAreacode());
		provice.setName(result.getName());
		provice.setParentid(Integer.valueOf(result.getParentid()));
		provice.setParentname(result.getParentname());
		provice.setZipcode(result.getZipcode());
		
		proviceMapper.insertSelective(provice);
		
      }
    	//获取response的body
    	//System.out.println(EntityUtils.toString(response.getEntity()));
    } catch (Exception e) {
    	e.printStackTrace();
    }*/

    private String status;
    private String msg;
    private List<ProviceResult> result;
    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setMsg(String msg) {
         this.msg = msg;
     }
     public String getMsg() {
         return msg;
     }

    public void setResult(List<ProviceResult> result) {
         this.result = result;
     }
     public List<ProviceResult> getResult() {
         return result;
     }

}
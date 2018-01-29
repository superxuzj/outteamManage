package com.boliangshenghe.outteam.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.HttpMethod;

import org.apache.http.HttpEntity;
import org.apache.http.entity.BasicHttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String appid = "";
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxff6334ce4ea4b97b&secret=5e54e39cdb81727ea1209a13ff42284d";
		System.out.println(System.currentTimeMillis());
		long befo = System.currentTimeMillis();
		String result = HttpClientUtil.doPost(url);
		System.out.println(System.currentTimeMillis()-befo);
		System.out.println(result);
		result = result.substring(17, result.length()-19);
		String urlbusi = "https://api.weixin.qq.com/wxa/getwxacodeunlimit";
		Map<String, String> param = new HashMap<String,String>();
		param.put("access_token", result);
		param.put("path", "pages/index");
		param.put("scene", "123456");
		String str = HttpClientUtil.doPost(urlbusi, param);
		System.out.println(str);
		
	}


}

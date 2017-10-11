package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 地震事件管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/earthquake")
public class EarthquakeController {
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/earthquake/list";
	}
	
	@RequestMapping("list")
	public String index(){
		return "earthquake/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "earthquake/info";
	}
}

package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 轮值管理
 * 
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/onduty")
public class OndutyController {
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/onduty/list";
	}
	
	@RequestMapping("list")
	public String index(){
		return "onduty/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "onduty/info";
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("goadd")
	public String goadd(){
		return "onduty/add";
	}
}

package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 响应管理
 * 
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/respond")
public class RespondController {
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/respond/list";
	}
	
	@RequestMapping("list")
	public String index(){
		return "respond/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "respond/info";
	}
}

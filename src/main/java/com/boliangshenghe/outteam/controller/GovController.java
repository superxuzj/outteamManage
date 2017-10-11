package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 单位管理
 * 
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/gov")
public class GovController {
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/gov/list";
	}
	
	@RequestMapping("list")
	public String index(){
		return "gov/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "gov/info";
	}
}

package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 预案管理
 * 
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/plan")
public class PlanController {
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/plan/list";
	}
	
	@RequestMapping("list")
	public String index(){
		return "plan/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "plan/info";
	}
}

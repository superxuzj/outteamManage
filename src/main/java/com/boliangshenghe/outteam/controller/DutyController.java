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
@RequestMapping("/duty")
public class DutyController {
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/duty/list";
	}
	
	@RequestMapping("list")
	public String index(){
		return "duty/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "duty/info";
	}
}

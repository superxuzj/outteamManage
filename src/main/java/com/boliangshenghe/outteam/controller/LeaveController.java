package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 撤退管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/leave/list";
	}
	
	@RequestMapping("list")
	public String index(){
		return "leave/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "leave/info";
	}
}

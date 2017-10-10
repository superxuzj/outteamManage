package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/outteam")
public class OutTeamController {
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/outteam/list";
	}
	
	@RequestMapping("list")
	public String index(){
		return "outteam/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "outteam/info";
	}
}

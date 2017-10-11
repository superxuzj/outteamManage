package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 个人出队管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/personteam")
public class PersonOutTeamController {
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/personteam/info";
	}
	
	@RequestMapping("info")
	public String info(){
		return "personteam/info";
	}
}

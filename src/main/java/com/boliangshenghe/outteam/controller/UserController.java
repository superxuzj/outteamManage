package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *用户管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/user/list";
	}
	
	@RequestMapping("list")
	public String index(){
		return "user/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "user/info";
	}
}

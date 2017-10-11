package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 个人信息
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	@RequestMapping
	public String defaultIndex(){
		return "redirect:/person/info";
	}
	
	@RequestMapping("info")
	public String info(){
		return "person/info";
	}
}

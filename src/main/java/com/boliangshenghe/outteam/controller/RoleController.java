package com.boliangshenghe.outteam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *角色管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/role/list";
	}
	
	@RequestMapping("list")
	public String index(){
		return "role/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "role/info";
	}
}

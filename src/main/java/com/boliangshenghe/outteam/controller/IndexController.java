package com.boliangshenghe.outteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping("/page")
	public String hello(User user,Model model,@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		user.setType("1");
		PageBean<User> page =  userService.getUserByPage(user,pageNo,10);
		System.out.println(page.getTotal());
		model.addAttribute("page", page);
		model.addAttribute("hello", "sdfds");
		return "hello";
	}
}

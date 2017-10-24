package com.boliangshenghe.outteam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.service.OutteamService;
import com.boliangshenghe.outteam.service.UserService;

/**
 * 撤退管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {
	@Autowired
	private OutteamService outteamService;
	
	@Autowired
	private UserService userService;
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/leave/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Outteam outteam,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		PageBean<Outteam> page = outteamService.getOutteamByPage(outteam, pageNo);
		model.addAttribute("page", page);
		return "leave/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "leave/info";
	}
}

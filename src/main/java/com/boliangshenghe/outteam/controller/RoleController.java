package com.boliangshenghe.outteam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Role;
import com.boliangshenghe.outteam.service.RoleService;

/**
 *角色管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/role/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Role role,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		PageBean<Role> page = roleService.getRoleByPage(role, pageNo);
		model.addAttribute("page", page);
		return "role/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "role/info";
	}
}

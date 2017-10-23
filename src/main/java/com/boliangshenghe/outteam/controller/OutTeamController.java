package com.boliangshenghe.outteam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.service.OutteamDetailService;
import com.boliangshenghe.outteam.service.OutteamService;
import com.boliangshenghe.outteam.service.UserService;

/**
 * 出队管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/outteam")
public class OutTeamController {
	
	@Autowired
	private OutteamService outteamService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OutteamDetailService outteamDetailService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/outteam/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Outteam outteam,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		
		PageBean<Outteam> page = outteamService.getOutteamByPage(outteam, pageNo);
		model.addAttribute("page", page);
		return "outteam/list";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Outteam outteam = outteamService.selectByPrimaryKey(id);
			model.addAttribute("outteam", outteam);
		}
		return "outteam/info";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, 
  			HttpServletResponse response,Outteam outteam,Model model){
		
		outteamService.addDetail(outteam);
		
		System.out.println(outteam.getChooses());
		return "redirect:/outteam/list";
	}
	
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Outteam outteam = outteamService.selectByPrimaryKey(id);
			model.addAttribute("outteam", outteam);
			
			
		}
		return "outteam/addOrEdit";
	}
	
	@RequestMapping("personlist")
	public String personlist(HttpServletRequest request, 
  			HttpServletResponse response,Integer cid,Model model){
		
		User user = new User();
		user.setCid(cid);
		//user.setCid(1);
		List<User> userlist = userService.selectUserList(user);//查询单位员工
		model.addAttribute("userlist", userlist);
		return "outteam/personlist";
	}
}

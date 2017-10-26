package com.boliangshenghe.outteam.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Leave;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.service.LeaveService;
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
	private LeaveService leaveService;
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
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, 
  			HttpServletResponse response,Leave leave,Model model){
		if(leave.getId()!=null){
			leaveService.updateByPrimaryKeySelective(leave);
		}else{
			leave.setCreatetime(new Date());
			leave.setState("1");//1 撤离申请  2撤离
			leaveService.insertSelective(leave);
			
			Outteam outteam = outteamService.selectByPrimaryKey(leave.getOtid());
			outteam.setState("3");
			outteam.setLid(leave.getId());
			outteamService.updateByPrimaryKeySelective(outteam);
		}
		
//		model.addAttribute("page", page);
		return "redirect:/leave/list";
	}
	
	/**
	 * 申请页面
	 * @return
	 */
	@RequestMapping("ask")
	public String ask(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Outteam outteam = outteamService.selectByPrimaryKey(id);
			model.addAttribute("outteam", outteam);
			if(outteam.getLid()!=null){
				Leave leave = leaveService.selectByPrimaryKey(outteam.getLid());
				model.addAttribute("leave", leave);
			}
		}
		return "leave/ask";
	}
}

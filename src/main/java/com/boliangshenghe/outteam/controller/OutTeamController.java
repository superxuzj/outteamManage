package com.boliangshenghe.outteam.controller;

import java.util.ArrayList;
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
import com.boliangshenghe.outteam.entity.OutteamDetail;
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
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Outteam outteam = outteamService.selectByPrimaryKey(id);
			model.addAttribute("outteam", outteam);
			
			OutteamDetail outteamDetail = new OutteamDetail();
			outteamDetail.setCid(outteam.getCid());
			outteamDetail.setEqid(outteam.getEqid());
			List<OutteamDetail> otdetailList = outteamDetailService.selectOutteamDetailList(outteamDetail);
			if(otdetailList!=null && otdetailList.size()>0){
				model.addAttribute("otdetailList", otdetailList);
			}
		}
		return "outteam/addOrEdit";
	}
	/**
	 * 选择出队员工弹出框
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("personlist")
	public String personlist(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		Outteam outteam = outteamService.selectByPrimaryKey(id);
		User user = new User();
		user.setCid(outteam.getCid());
		//user.setCid(1);
		List<User> userlist = userService.selectUserList(user);//查询单位员工
		OutteamDetail outteamDetail = new OutteamDetail();
		outteamDetail.setCid(outteam.getCid());
		outteamDetail.setEqid(outteam.getEqid());
		List<OutteamDetail> otdetailList = outteamDetailService.selectOutteamDetailList(outteamDetail);
		if(otdetailList!=null && otdetailList.size()>0){
			for (OutteamDetail detail : otdetailList) {
				for (User u : userlist) {
					if(detail.getUserid()==u.getId()){
						u.setIschoose("1");
					}
					if(detail.getIslead()!=null && detail.getIslead().equals("1") && detail.getUserid()==u.getId()){
						u.setIslead("1");
					}
					if(detail.getIscontact()!=null && detail.getIscontact().equals("1") && detail.getUserid()==u.getId()){
						u.setIscontact("1");
					}
					if(detail.getIsmeet()!=null && detail.getIsmeet().equals("1") && detail.getUserid()==u.getId()){
						u.setIsmeet("1");
					}
				}
			}
		}
		
		model.addAttribute("otdetailList", otdetailList);
		model.addAttribute("userlist", userlist);
		return "outteam/personlist";
	}
	
	/**
	 * 获取航班信息
	 * @param request
	 * @param response
	 * @param outteam
	 * @param model
	 * @return
	 */
	@RequestMapping("flight")
	public String flight(HttpServletRequest request, 
  			HttpServletResponse response,Outteam outteam,Model model){
		
		outteamService.addDetail(outteam);
		
		System.out.println(outteam.getChooses());
		return "redirect:/outteam/list";
	}
}

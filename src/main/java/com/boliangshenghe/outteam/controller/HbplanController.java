package com.boliangshenghe.outteam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Hbplan;
import com.boliangshenghe.outteam.entity.Link;
import com.boliangshenghe.outteam.service.HbplanService;

/**
 * 华北预案管理
 * 
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/hbplan")
public class HbplanController {
	
	@Autowired
	private HbplanService hbplanService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/hbplan/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Hbplan hbplan,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		PageBean<Hbplan> page = hbplanService.gethbplanByPage(hbplan, pageNo);
		model.addAttribute("page", page);
		return "hbplan/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "hbplan/info";
	}
	
	/**
	 * 添加 插入
	 * @param request
	 * @param response
	 * @param outteam
	 * @param model
	 * @return
	 */
	@RequestMapping("save")
	public String save(HttpServletRequest request, 
  			HttpServletResponse response,Hbplan hbplan,Model model){
		
		hbplanService.addDetail(hbplan);
		
		return "redirect:/Hbplan/list";
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(null!=id){
			Hbplan hbplan = hbplanService.selectByPrimaryKey(id);
			model.addAttribute("hbplan", hbplan);
			/*
			LinkDetail linkDetail = new LinkDetail();
			linkDetail.setLinkid(id);
			List<LinkDetail> detailList = linkDetailService.selectLinkDetailList(linkDetail);
			model.addAttribute("detailList", detailList);*/
		}
		
		
		return "hbplan/addOrEdit";
	}
}

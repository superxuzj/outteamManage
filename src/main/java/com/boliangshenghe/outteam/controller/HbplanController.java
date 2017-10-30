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
import com.boliangshenghe.outteam.entity.Hbplan;
import com.boliangshenghe.outteam.entity.HbplanDetail;
import com.boliangshenghe.outteam.service.HbplanDetailService;
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
	
	@Autowired
	private HbplanDetailService hbplanDetailService;
	
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
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(null!=id){
			Hbplan hbplan = hbplanService.selectByPrimaryKey(id);
			model.addAttribute("hbplan", hbplan);
			
			HbplanDetail hbplanDetail = new HbplanDetail();
			hbplanDetail.setHbplanid(id);
			hbplanDetail.setType("1");
			List<HbplanDetail> firstdetailList = hbplanDetailService.selectHbplanDetailList(hbplanDetail);
			model.addAttribute("firstdetailList", firstdetailList);
			
			HbplanDetail hbplanDetail2 = new HbplanDetail();
			hbplanDetail2.setHbplanid(id);
			hbplanDetail2.setType("2");
			List<HbplanDetail> seconddetailList = hbplanDetailService.selectHbplanDetailList(hbplanDetail2);
			model.addAttribute("seconddetailList", seconddetailList);
		}
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
		
		return "redirect:/hbplan/list";
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
			HbplanDetail hbplanDetail = new HbplanDetail();
			hbplanDetail.setHbplanid(id);
			hbplanDetail.setType("1");
			List<HbplanDetail> firstdetailList = hbplanDetailService.selectHbplanDetailList(hbplanDetail);
			model.addAttribute("firstdetailList", firstdetailList);
			
			HbplanDetail hbplanDetail2 = new HbplanDetail();
			hbplanDetail2.setHbplanid(id);
			hbplanDetail2.setType("2");
			List<HbplanDetail> seconddetailList = hbplanDetailService.selectHbplanDetailList(hbplanDetail2);
			model.addAttribute("seconddetailList", seconddetailList);
		}
		
		
		return "hbplan/addOrEdit";
	}
}

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
import com.boliangshenghe.outteam.entity.Onduty;
import com.boliangshenghe.outteam.entity.Yearm;
import com.boliangshenghe.outteam.service.OndutyService;
import com.boliangshenghe.outteam.service.YearmService;

/**
 * 轮值管理
 * 年月+单位
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/onduty")
public class OndutyController {
	
	@Autowired
	private YearmService yearmService;
	
	@Autowired
	private OndutyService ondutyService;
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/onduty/list";
	}
	
	/**
	 * 显式所有的年月
	 * @param request
	 * @param response
	 * @param yearm
	 * @param model
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Yearm yearm,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		
		PageBean<Yearm> page = yearmService.getYearmByPage(yearm, pageNo);
		model.addAttribute("page", page);
		return "onduty/list";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(null!=id){
			Yearm yearm = yearmService.selectByPrimaryKey(id);
			model.addAttribute("yearm", yearm);
			Onduty onduty = new Onduty();
			onduty.setYid(id);//根据年月表id查
			List<Onduty> dutyList = ondutyService.selectOndutyList(onduty);
			model.addAttribute("dutyList", dutyList);
		}
		return "onduty/info";
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
  			HttpServletResponse response,Yearm yearm,Model model){
		
		yearmService.addDetail(yearm);
		
		return "redirect:/onduty/list";
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(null!=id){
			Yearm yearm = yearmService.selectByPrimaryKey(id);
			model.addAttribute("yearm", yearm);
			
			Onduty onduty = new Onduty();
			onduty.setYid(id);//根据年月表id查
			List<Onduty> dutyList = ondutyService.selectOndutyList(onduty);
			model.addAttribute("dutyList", dutyList);
		}
		return "onduty/addOrEdit";
	}
}

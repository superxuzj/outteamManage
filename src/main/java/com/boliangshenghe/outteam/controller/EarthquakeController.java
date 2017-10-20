package com.boliangshenghe.outteam.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.controller.base.BaseController;
import com.boliangshenghe.outteam.entity.Earthquake;
import com.boliangshenghe.outteam.service.EarthquakeService;
/**
 * 地震事件管理
 2017
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/earthquake")
public class EarthquakeController extends BaseController{
	
	@Autowired
	private EarthquakeService earthquakeService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/earthquake/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Earthquake earthquake,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		
		PageBean<Earthquake> page = earthquakeService.getEarthquakeByPage(earthquake, pageNo);
		model.addAttribute("page", page);
		return "earthquake/list";
	}
	
	@RequestMapping("info")
	public String info(){
		return "earthquake/info";
	}
	
	@RequestMapping("goadd")
	public String goadd(){
		return "earthquake/add";
	}
	/**
	 * 添加到数据库
	 * @param request
	 * @param response
	 * @param earthquake
	 * @param model
	 * @return
	 */
	@RequestMapping("save")
	public String save(HttpServletRequest request, 
  			HttpServletResponse response,Earthquake earthquake,Model model){
		
		System.out.println("123");
		
		earthquake.setCreatetime(new Date());
		earthquake.setCreator("管理员");
		earthquakeService.insertSelective(earthquake);
		return "redirect:/earthquake/list";
	}
}

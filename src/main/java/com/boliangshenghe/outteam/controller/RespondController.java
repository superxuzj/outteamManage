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
import com.boliangshenghe.outteam.entity.Response;
import com.boliangshenghe.outteam.entity.ResponseCompany;
import com.boliangshenghe.outteam.service.ResponseCompanyService;
import com.boliangshenghe.outteam.service.ResponseService;

/**
 * 响应管理
 * 
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/respond")
public class RespondController {
	
	@Autowired
	private ResponseService responseService;
	
	@Autowired
	private ResponseCompanyService responseCompanyService;
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/respond/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Response resp,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		PageBean<Response> page = responseService.getResponseByPage(resp, pageNo);
		model.addAttribute("page", page);
		return "respond/list";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(null!=id){
			Response resp = responseService.selectByPrimaryKey(id);
			model.addAttribute("response", resp);
			
			ResponseCompany responseCompany = new ResponseCompany();
			responseCompany.setRid(id);
			List<ResponseCompany> companyList = responseCompanyService.selectResponseCompanyList(responseCompany);
			model.addAttribute("companyList", companyList);
		}
		return "respond/info";
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
  			HttpServletResponse response,Response resp,Model model){
		
		responseService.addDetail(resp);
		
		return "redirect:/respond/list";
	}
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(null!=id){
			Response resp = responseService.selectByPrimaryKey(id);
			model.addAttribute("response", resp);
			
			ResponseCompany responseCompany = new ResponseCompany();
			responseCompany.setRid(id);
			List<ResponseCompany> companyList = responseCompanyService.selectResponseCompanyList(responseCompany);
			model.addAttribute("companyList", companyList);
			
		}
		
		
		return "respond/addOrEdit";
	}
}

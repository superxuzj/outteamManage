package com.boliangshenghe.outteam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.entity.Response;
import com.boliangshenghe.outteam.entity.ResponseCompany;
import com.boliangshenghe.outteam.service.CompanyService;
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
	
	@Autowired
	private CompanyService companyService;
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
	/*@RequestMapping("save")
	public String save(HttpServletRequest request, 
  			HttpServletResponse response,Response resp,Model model){
		
		responseService.addDetail(resp);
		
		return "redirect:/respond/list";
	}*/
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
	
	/**
	 *修改页面ajax添加单位
	 * 
	 * @param request
	 * @param response
	 * @param linkDetail
	 * @param model
	 * @return
	 */
	@RequestMapping("addResponseCompany")
	@ResponseBody
	public String addLinkDetail(HttpServletRequest request, 
  			HttpServletResponse response,ResponseCompany responseCompany,Model model){
		//System.out.println(hbplanDetail.getHbplanid());
		Company company = companyService.selectByPrimaryKey(responseCompany.getCid());
		responseCompany.setCompany(company.getProvince());
		responseCompany.setState("1");
		Response resp = responseService.selectByPrimaryKey(responseCompany.getRid());
		responseCompany.setRname(resp.getName());
		responseCompanyService.insertSelective(responseCompany);//
		return "success";
	}
	
	/**
	 *删除linkDetail
	 * @param request
	 * @param response
	 * @param hbplanDetail
	 * @param model
	 * @return
	 */
	@RequestMapping("delResponseCompany")
	@ResponseBody
	public String delyLinkDetail(HttpServletRequest request, 
  			HttpServletResponse response,ResponseCompany responseCompany,Model model){
		responseCompanyService.deleteByResponseCompany(responseCompany);
		
		return "success";
	}
}

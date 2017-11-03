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
import com.boliangshenghe.outteam.service.CompanyService;

/**
 * 单位管理
 * 
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/company/list";
	}
	
	/**
	 * 分页查询
	 * @param request
	 * @param response
	 * @param company
	 * @param model
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Company company,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		PageBean<Company> page = companyService.getCompanyByPage(company, pageNo);
		model.addAttribute("page", page);
		model.addAttribute("company", company);
		return "company/list";
	}
	
	@RequestMapping("all")
	public String all(HttpServletRequest request, 
  			HttpServletResponse response,Company company,Model model){
		List<Company> list = companyService.selectCompanyList(company);
		model.addAttribute("list", list);
		return "company/all";
	}
	//第二梯队
	@RequestMapping("second")
	public String second(HttpServletRequest request, 
  			HttpServletResponse response,Company company,Model model){
		List<Company> list = companyService.selectCompanyList(company);
		model.addAttribute("list", list);
		return "company/second";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		System.out.println(id);
		if(id!=null){
			Company company = companyService.selectByPrimaryKey(id);
			model.addAttribute("company", company);
		}
		return "company/info";
	}
	
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		System.out.println(id);
		if(id!=null){
			Company company = companyService.selectByPrimaryKey(id);
			model.addAttribute("company", company);
		}
		return "company/addOrEdit";
	}
	
	/**
	 * 新增或者修改
	 * @param request
	 * @param response
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping("addOrEdit")
	public String addOrEdit(HttpServletRequest request, 
  			HttpServletResponse response,Company company,Model model){
		System.out.println(company.getProvince());
		System.out.println(company.getId());
		
		if(company.getId()==null){
			companyService.insertSelective(company);
		}else{
			companyService.updateByPrimaryKeySelective(company);
		}
		return "redirect:/company/list";
	}
	
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("del")
	public String del(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		
		companyService.deleteByPrimaryKey(id);
		return "redirect:/company/list";
	}
	
	@RequestMapping("valdel")
	@ResponseBody
	public String valdel(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		
		//验证其他表是否用到的该单位
		return "success";
	}
	
}

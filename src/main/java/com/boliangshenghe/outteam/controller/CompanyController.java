package com.boliangshenghe.outteam.controller;

import java.util.Date;
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
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.service.CompanyService;
import com.boliangshenghe.outteam.service.OutteamService;
import com.boliangshenghe.outteam.service.UserService;
import com.boliangshenghe.outteam.util.CommonUtils;

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
	@Autowired
	private OutteamService  outteamService;
	@Autowired
	private UserService userService;
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
	
	/**
	 * 所有的单位 需要输入人数
	 * @param request
	 * @param response
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping("allhascount")
	public String allhascount(HttpServletRequest request, 
  			HttpServletResponse response,Company company,Model model){
		List<Company> list = companyService.selectCompanyList(company);
		model.addAttribute("list", list);
		return "company/allhascount";
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
		
		if(company.getId()==null){
			companyService.insertSelective(company);
			User user = new User();
			user.setCid(company.getId());
			user.setCompany(company.getProvince());
			user.setCreatetime(new Date());
			user.setName(company.getProvince());
			user.setRoleid(2);
			user.setPassword(CommonUtils.DEFAUTPWD);
			user.setUsername(company.getCode());
			user.setState("1");
			userService.insertSelective(user);
			
		}else{
			User user = new User();
			user.setRoleid(2);
			user.setCid(company.getId());
			//user.setUsername(company.getCode());
			List<User> list = userService.selectUserList(user);
			if(null!=list && list.size()>0){
				User record = list.get(0);
				record.setUsername(company.getCode());
				record.setCompany(company.getProvince());
				record.setCreatetime(new Date());
				record.setName(company.getProvince());
				userService.updateByPrimaryKeySelective(record);
			}
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
		Company company = companyService.selectByPrimaryKey(id);
		Outteam ot = new Outteam();
		ot.setCompany(company.getProvince());
		List<Outteam> otlist = outteamService.selectOutteamList(ot);
		if(null!=otlist && otlist.size()>0){
			return "fail";
		}
		System.out.println("valdel");
		return "success";
	}
	
}

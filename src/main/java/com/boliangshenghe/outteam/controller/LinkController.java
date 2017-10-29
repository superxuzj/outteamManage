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
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.entity.Link;
import com.boliangshenghe.outteam.entity.LinkDetail;
import com.boliangshenghe.outteam.entity.Response;
import com.boliangshenghe.outteam.service.CompanyService;
import com.boliangshenghe.outteam.service.LinkDetailService;
import com.boliangshenghe.outteam.service.LinkService;
import com.boliangshenghe.outteam.service.ResponseService;

/**
 * 联动管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/link")
public class LinkController {
	
	@Autowired
	private LinkService linkService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private LinkDetailService linkDetailService;
	
	@Autowired
	private ResponseService responseService;
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/link/list";
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
  			HttpServletResponse response,Link link,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		
		PageBean<Link> page = linkService.getLinkByPage(link, pageNo);
		model.addAttribute("page", page);
		return "link/list";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(null!=id){
			Link link = linkService.selectByPrimaryKey(id);
			model.addAttribute("link", link);
			
			Response re = responseService.selectByPrimaryKey(link.getRid());
			Company company = companyService.selectByPrimaryKey(link.getEqcid());//单位
			model.addAttribute("company", company);
			model.addAttribute("re", re);
			
			LinkDetail linkDetail = new LinkDetail();
			linkDetail.setLinkid(id);
			List<LinkDetail> detailList = linkDetailService.selectLinkDetailList(linkDetail);
			model.addAttribute("detailList", detailList);
		}
		return "link/info";
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
  			HttpServletResponse response,Link link,Model model){
		
		linkService.addDetail(link);
		
		return "redirect:/link/list";
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(null!=id){
			Link link = linkService.selectByPrimaryKey(id);
			model.addAttribute("link", link);
			
			LinkDetail linkDetail = new LinkDetail();
			linkDetail.setLinkid(id);
			List<LinkDetail> detailList = linkDetailService.selectLinkDetailList(linkDetail);
			model.addAttribute("detailList", detailList);
		}
		
		List<Response> responseList = responseService.selectResponseList(new Response());
		Company company  = new Company();
		company.setType("1");
		List<Company> companyList = companyService.selectCompanyList(company);
		model.addAttribute("companyList", companyList);
		model.addAttribute("responseList", responseList);
		return "link/addOrEdit";
	}
}

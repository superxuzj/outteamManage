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
import com.boliangshenghe.outteam.controller.base.BaseController;
import com.boliangshenghe.outteam.entity.Earthquake;
import com.boliangshenghe.outteam.entity.Onduty;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.Response;
import com.boliangshenghe.outteam.entity.ResponseCompany;
import com.boliangshenghe.outteam.service.EarthquakeService;
import com.boliangshenghe.outteam.service.OndutyService;
import com.boliangshenghe.outteam.service.OutteamService;
import com.boliangshenghe.outteam.service.ResponseCompanyService;
import com.boliangshenghe.outteam.service.ResponseService;
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
	
	@Autowired
	private ResponseService responseService;
	
	@Autowired
	private OutteamService outteamService;
	
	@Autowired
	private OndutyService ondutyService;
	
	@Autowired
	private ResponseCompanyService responseCompanyService;
	
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
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
			model.addAttribute("earthquake", earthquake);
		}
		return "earthquake/info";
	}
	
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
			model.addAttribute("earthquake", earthquake);
		}
		
		/**
		 * 这段话是不是考虑放到base里面
		 */
		List<Response> responseList = responseService.selectResponseList(new Response());
		model.addAttribute("responseList", responseList);
		
		return "earthquake/addOrEdit";
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
		
		if(earthquake.getId()!=null){
			earthquake.setCreatetime(new Date());
			earthquake.setCreator("管理员");
			earthquakeService.updateByPrimaryKeySelective(earthquake);
		}else{
			earthquake.setCreatetime(new Date());
			earthquake.setCreator("管理员");
			earthquakeService.insertSelective(earthquake);
		}
		
		return "redirect:/earthquake/list";
	}
	
	/**
	 * 判断该地震是否按照
	 * 震源省份 响应等级 轮值单位这三个判断依据
	 * 分配了出队单位
	 * @param request
	 * @param response
	 * @param earthquake
	 * @param model
	 * @return
	 */
	@RequestMapping("valCompany")
	@ResponseBody
	public String valCompany(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		
		//Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
		Outteam outteam = new Outteam();
		outteam.setEqid(id);
		int count= outteamService.selectOutteamCount(outteam);
//		System.out.println(count);
		//还没有安排出队
		if(count==0){
			return "success";
		}else{
			return "fail";
		}
	}
	
	/**
	 * 震源省份 响应等级 轮值单位这三个判断规则应该出队的单位
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("ruleoutteam")
	public String ruleoutteam(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		System.out.println(id);
		Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
		model.addAttribute("earthsource", earthquake.getProvince());//震源省份
		
		ResponseCompany responseCompany = new ResponseCompany();
		responseCompany.setRid(earthquake.getResponseid());//根据响应id查
		List<ResponseCompany> rcList = responseCompanyService.selectResponseCompanyList(responseCompany);
		model.addAttribute("responseName", earthquake.getResponseName());
		model.addAttribute("rcList", rcList);//响应等级出队单位
		
		Onduty onduty = new Onduty();
		onduty.setYearm("2017-10");
		List<Onduty> dutyList = ondutyService.selectOndutyList(onduty);
		model.addAttribute("yearm", "2017-10");//轮值年月
		model.addAttribute("dutyList", dutyList);//轮值单位
		
		return "earthquake/addOrEdit";
	}
}

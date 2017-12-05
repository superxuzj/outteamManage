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

import com.boliangshenghe.outteam.entity.Catalogcopy;
import com.boliangshenghe.outteam.entity.Earthquake;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.OutteamDetail;
import com.boliangshenghe.outteam.service.CatalogcopyService;
import com.boliangshenghe.outteam.service.EarthquakeService;
import com.boliangshenghe.outteam.service.OutteamDetailService;
import com.boliangshenghe.outteam.service.OutteamService;
import com.boliangshenghe.outteam.util.DateUtils;

@Controller
@RequestMapping("/leader")
public class LeaderController {
	
	@Autowired
	private CatalogcopyService catalogcopyService;
	
	@Autowired
	private EarthquakeService earthquakeService;
	
	@Autowired
	private OutteamService outteamService;
	
	@Autowired
	private OutteamDetailService outteamDetailService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/leader/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Catalogcopy record,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		
		List<Catalogcopy> list = catalogcopyService.selectCatalogcopyList(record);
		model.addAttribute("list", list);
		
//		model.addAttribute("title", "四川地震");
		return "leader/list";
	}
	
	@RequestMapping("outteam")
	public String outteam(HttpServletRequest request, 
  			HttpServletResponse response,String cataId,Model model){
		
		Catalogcopy catalogcopy = catalogcopyService.selectByPrimaryKey(cataId);
		Earthquake earthquake = new Earthquake();
		
		earthquake.setEqname(catalogcopy.getLocationCname()+catalogcopy.getM()+"级地震");
		earthquake.setArea(catalogcopy.getArea());
		earthquake.setProvince(catalogcopy.getProvince());
		earthquake.setCid(catalogcopy.getCid());
		earthquake.setCreatetime(new Date());
		earthquake.setCreator("领导");
		earthquake.setDepth(catalogcopy.getDepth().toString());
		earthquake.setEqdate(DateUtils.getYearMDayStringDate(catalogcopy.getOTime()));
		earthquake.setEqtime(DateUtils.getAllStringDate(catalogcopy.getOTime()));
		earthquake.setEventid(catalogcopy.getCataId());
		earthquake.setLatitude(catalogcopy.getLat().toString());
		earthquake.setLocation(catalogcopy.getLocationCname());
		earthquake.setLongitude(catalogcopy.getLon().toString());
		earthquake.setMagnitude(catalogcopy.getM().toString());
		earthquake.setResponseid(1);
		earthquake.setState("2");//地震事件为eqim触发
		
		earthquakeService.insertSelective(earthquake);
		
		catalogcopy.setIsouttem("1");
		catalogcopyService.updateByPrimaryKeySelective(catalogcopy);
		
		List<Catalogcopy> list = catalogcopyService.selectCatalogcopyList(new Catalogcopy());
		model.addAttribute("list", list);
		
//		model.addAttribute("title", "四川地震");
		return "leader/list";
	}
	
	@RequestMapping("unoutteam")
	public String unoutteam(HttpServletRequest request, 
  			HttpServletResponse response,String cataId,Model model){
		
		Catalogcopy catalogcopy = catalogcopyService.selectByPrimaryKey(cataId);
		
		
		catalogcopy.setIsouttem("3");//领导说不要出队
		catalogcopyService.updateByPrimaryKeySelective(catalogcopy);
		
		List<Catalogcopy> list = catalogcopyService.selectCatalogcopyList(new Catalogcopy());
		model.addAttribute("list", list);
		
//		model.addAttribute("title", "四川地震");
		return "leader/list";
	}
	
	/**
	 * 一个地震事件的出队单位
	 * @param request
	 * @param response
	 * @param cataId
	 * @param model
	 * @return
	 */
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,String cataId,Model model){
		
		Earthquake record = new Earthquake();
		record.setEventid(cataId);
		record.setState("2");
		List<Earthquake> earthquakeList =  earthquakeService.selectEarthquakeList(record);
		if(null !=earthquakeList && earthquakeList.size()>0){
			Earthquake earthquake = earthquakeList.get(0);
			
			Outteam ot = new Outteam();
			ot.setEqid(earthquake.getId());
			List<Outteam> outteamlist = outteamService.selectOutteamList(ot);
			
			model.addAttribute("outteamlist", outteamlist);
		}
		
		List<Catalogcopy> list = catalogcopyService.selectCatalogcopyList(new Catalogcopy());
		model.addAttribute("list", list);
		
		return "leader/list";
	}
	
	/**
	 * 一个地震事件的出队单位的人员
	 * @param request
	 * @param response
	 * @param cataId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="getPersonnel", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getPersonnel(HttpServletRequest request, 
  			HttpServletResponse response,Integer otid,Model model){
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
		OutteamDetail record = new OutteamDetail();
		record.setOtid(otid);
		List<OutteamDetail> outteamDetailList = outteamDetailService.selectOutteamDetailList(record);
		
		String retu="<dd><span>无</span></dd>";
		if(null!=outteamDetailList && outteamDetailList.size()>0){
			retu = "";
			for(int i=0 ; i<outteamDetailList.size() ;i++){
				OutteamDetail outteamDetail = outteamDetailList.get(i);
				if((i+1)%3==1){
					retu = retu +"<dd><span>"+outteamDetail.getName()+"</span>";
				}else if((i+1)%3==2){
					retu = retu +"<span>"+outteamDetail.getName()+"</span>";
				}else if((i+1)%3==0){
					retu = retu +"<span>"+outteamDetail.getName()+"</span></dd>";
				}
			}
			System.out.println(retu);
		}
		return retu;
	}
}
